using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FDMC.Data;
using FDMC.Models;
using FDMC.Models.BindingModels;
using FDMC.Models.ViewModels;

namespace FDMC.Services
{
    public class CatService : ICatService
    {
        private readonly FDMCDbContext context;

        public CatService(FDMCDbContext context)
        {
            this.context = context;
        }

        public void Add(CatAddBindingModel model)
        {
            var cat = new Cat()
            {
                Name = model.Name,
                Age = model.Age,
                Breed = model.Breed,
                ImageUrl = model.ImageUrl
            };

            this.context.Cats.Add(cat);
            this.context.SaveChanges();
        }

        public CatDetailsViewModel GetCat(string id)
        {
            var catDetailsViewModel = this.context.Cats
                .Where(x => x.Id == id)
                .Select(x => new CatDetailsViewModel
                {
                    Id = x.Id,
                    Age = x.Age,
                    Breed = x.Breed,
                    Name = x.Name,
                    ImageUrl = x.ImageUrl
                })
                .FirstOrDefault();

            return catDetailsViewModel;
        }
    }
}
