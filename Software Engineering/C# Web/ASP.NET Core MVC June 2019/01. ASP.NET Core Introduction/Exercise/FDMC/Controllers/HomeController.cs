using Microsoft.AspNetCore.Mvc;
using FDMC.Services;

namespace FDMC.Controllers
{
    public class HomeController : Controller
    {
        private readonly IHomeService homeService;

        public HomeController(IHomeService homeService)
        {
            this.homeService = homeService;
        }

        public IActionResult Index()
        {
            return View(this.homeService.GetAllCats());
        }
    }
}
