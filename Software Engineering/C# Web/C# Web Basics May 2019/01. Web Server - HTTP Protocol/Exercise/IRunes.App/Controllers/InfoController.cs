using SIS.HTTP.Requests;
using SIS.HTTP.Responses;
using SIS.MvcFramework;
using SIS.MvcFramework.Attributes.Action;

namespace IRunes.App.Controllers
{
    public class InfoController : Controller
    {
        public int myProperty { get; set; }

        [NonAction]
        public override string ToString()
        {
            return base.ToString();
        }

        public IHttpResponse About(IHttpRequest request)
        {
            return View();
        }
    }
}
