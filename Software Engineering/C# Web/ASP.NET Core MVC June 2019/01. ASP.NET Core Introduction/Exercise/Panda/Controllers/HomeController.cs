using Microsoft.AspNetCore.Mvc;

namespace Panda.Controllers
{
    [Controller]
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return this.View();
        }
    }
}
