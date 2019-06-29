using FDMC.Models.ViewModels;
using System.Collections.Generic;

namespace FDMC.Services
{
    public interface IHomeService
    {
        IList<CatHomeViewModel> GetAllCats();
    }
}
