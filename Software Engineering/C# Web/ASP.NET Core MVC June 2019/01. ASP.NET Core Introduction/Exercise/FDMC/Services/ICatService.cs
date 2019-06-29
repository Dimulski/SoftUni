using FDMC.Models.BindingModels;
using FDMC.Models.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FDMC.Services
{
    public interface ICatService
    {
        void Add(CatAddBindingModel cat);

        CatDetailsViewModel GetCat(string id);
    }
}
