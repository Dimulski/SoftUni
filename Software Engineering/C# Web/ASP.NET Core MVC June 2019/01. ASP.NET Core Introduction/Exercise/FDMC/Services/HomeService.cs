using System.Collections.Generic;
using System.Linq;
using FDMC.Data;
using FDMC.Models.ViewModels;

namespace FDMC.Services
{
    public class HomeService : IHomeService
    {
        private readonly FDMCDbContext context;

        public HomeService(FDMCDbContext context)
        {
            this.context = context;
        }

        public IList<CatHomeViewModel> GetAllCats()
        {
            var indexViewModel = this.context
                .Cats
                .Select(x => new CatHomeViewModel
                {
                    Id = x.Id,
                    Name = x.Name

                }).ToList();

            return indexViewModel;
        }
    }
}
