using FDMC.Models.BindingModels;
using FDMC.Services;
using Microsoft.AspNetCore.Mvc;

namespace FDMC.Controllers
{
    public class CatsController : Controller
    {
        private readonly ICatService catService;

        public CatsController(ICatService catService)
        {
            this.catService = catService;
        }

        public IActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Add(CatAddBindingModel cat)
        {
            if (cat != null && ModelState.IsValid)
            {
                this.catService.Add(cat);
                return Redirect("/");
            }
            else
            {
                return this.View(cat);
            }
        }

        public IActionResult Details(string id)
        {
            var cat = this.catService.GetCat(id);
            return this.View(cat);
        }
    }
}
