using Demo.App.Controllers;
using SIS.HTTP.Enums;
using SIS.WebServer;
using SIS.WebServer.Results;
using SIS.WebServer.Routing;
using SIS.WebServer.Routing.Contracts;

namespace Demo.App
{
    class Program
    {
        static void Main(string[] args)
        {
            IServerRoutingTable serverRoutingTable = new ServerRoutingTable();

            // [GET] MAPPINGS
            serverRoutingTable.Add(HttpRequestMethod.Get, "/", httpRequest => new HomeController().Home(httpRequest));
            serverRoutingTable.Add(HttpRequestMethod.Get, "/login", httpRequest => new HomeController().Login(httpRequest));
            serverRoutingTable.Add(HttpRequestMethod.Get, "/logout", httpRequest => new HomeController().Logout(httpRequest));

            // [POST] MAPPINGS


            Server server = new Server(8000, serverRoutingTable);
            server.Run();
        }
    }
}
