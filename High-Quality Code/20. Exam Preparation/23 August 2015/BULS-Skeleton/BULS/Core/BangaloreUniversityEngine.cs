namespace BangaloreUniversityLearningSystem.Core
{
    using System;
    using System.Linq;
    using System.Reflection;

    using BangaloreUniversityLearningSystem.Data;
    using BangaloreUniversityLearningSystem.Interfaces;

    using buls;

    public class BangaloreUniversityEngine : IEngine
    {
        public void Run()
        {
            var database = new BangaloreUniversityData();
            User user = null;

            while (true)
            {
                string inputLine = Console.ReadLine();
                if (inputLine == null)
                {
                    break;
                }

                var route = new Route(inputLine);
                var controllerType = Assembly.GetExecutingAssembly().GetTypes() // Potential Bottleneck
                    .FirstOrDefault(type => type.Name == route.ControllerName);

                var controller = Activator.CreateInstance(controllerType, database, user) as Controller;
                var action = controllerType.GetMethod(route.ActionName);
                object[] @params = MapParameters(route, action);

                try
                {
                    var view = action.Invoke(controller, @params) as IView;
                    Console.WriteLine(view.Display());
                    user = controller.User;
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.InnerException.Message);
                }
            }
        }

        private static object[] MapParameters(Route route, MethodInfo action)
        {
            return action.GetParameters().Select<ParameterInfo, object>(
                p =>
                    {
                        if (p.ParameterType == typeof(int))
                        {
                            return int.Parse(route.Parameters[p.Name]);
                        }
                        else
                        {
                            return route.Parameters[p.Name];
                        }
                    })
                    .ToArray();
        }
    }
}
