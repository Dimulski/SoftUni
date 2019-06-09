using SIS.HTTP.Requests.Contracts;
using SIS.HTTP.Responses.Contracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace IRunes.App.Controllers
{
    public class HomeController : BaseController
    {
        public IHttpResponse Index(IHttpRequest httpRequest)
        {
            if (IsLoggedIn(httpRequest))
            {
                ViewData["Username"] = httpRequest.Session.GetParameter("username");

                return View("Home");
            }

            return this.View();
        }
    }
}
