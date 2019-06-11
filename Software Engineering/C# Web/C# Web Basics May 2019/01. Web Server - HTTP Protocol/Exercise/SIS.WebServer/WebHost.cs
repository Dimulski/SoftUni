using SIS.HTTP.Enums;
using SIS.HTTP.Responses;
using SIS.MvcFramework.Attributes;
using SIS.WebServer;
using SIS.WebServer.Routing;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;

namespace SIS.MvcFramework
{
    public static class WebHost
    {
        public static void Start(IMvcApplication application)
        {
            IServerRoutingTable serverRoutingTable = new ServerRoutingTable();
            AutoRegisterRoutes(application, serverRoutingTable);
            application.ConfigureServices();
            application.Configure(serverRoutingTable);
            var server = new Server(8000, serverRoutingTable);
            server.Run();
        }

        private static void AutoRegisterRoutes(IMvcApplication application, IServerRoutingTable serverRoutingTable)
        {
            var controllers = application.GetType().Assembly.GetTypes().Where(type =>
                type.IsClass && 
                !type.IsAbstract && 
                typeof(Controller).IsAssignableFrom(type));
            // TODO: Remove ToString from non-existent InfoController
            foreach (var controller in controllers)
            {
                var actions = controller.GetMethods(BindingFlags.DeclaredOnly | BindingFlags.Public | BindingFlags.Instance)
                    .Where(method => !method.IsSpecialName && method.DeclaringType == controller);
                foreach (var action in actions)
                {
                    var path = $"/{controller.Name.Replace("Controller", string.Empty)}/{action.Name}";
                    var attribute = action.GetCustomAttributes().Where(
                        x => x.GetType().IsSubclassOf(typeof(BaseHttpAttribute))).LastOrDefault() as BaseHttpAttribute;
                    var httpMethod = HttpRequestMethod.Get;
                    if (attribute != null)
                    {
                        httpMethod = attribute.Method;
                    }

                    if (attribute ? .Url != null)
                    {
                        path = attribute.Url;
                    }

                    if (attribute ? .ActionName != null)
                    {
                        path = $"/{controller.Name.Replace("Controller", string.Empty)}/{attribute.ActionName}";

                    }

                    serverRoutingTable.Add(httpMethod, path, request =>
                    {
                        var controllerInstance = Activator.CreateInstance(controller);
                        var response = action.Invoke(controllerInstance, new[] { request }) as IHttpResponse;
                        return response;
                    });

                    Console.WriteLine(httpMethod + " " + path);
                }
            }
        }
    }
}
