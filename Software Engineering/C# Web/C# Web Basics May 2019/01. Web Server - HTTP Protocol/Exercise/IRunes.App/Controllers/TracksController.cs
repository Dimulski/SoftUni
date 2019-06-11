using IRunes.App.Extensions;
using IRunes.Data;
using IRunes.Models;
using SIS.HTTP.Requests;
using SIS.HTTP.Responses;
using SIS.MvcFramework;
using SIS.MvcFramework.Attributes;
using System.Collections.Generic;
using System.Linq;

namespace IRunes.App.Controllers
{
    public class TracksController : Controller
    {
        public IHttpResponse Create(IHttpRequest httpRequest)
        {
            if (!IsLoggedIn(httpRequest))
            {
                return Redirect("/Users/Login");
            }

            string albumId = httpRequest.QueryData["albumId"].ToString();

            ViewData["AlbumId"] = albumId;
            return View();
        }

        [HttpPost(ActionName = "Create")]
        public IHttpResponse CreateConfirm(IHttpRequest httpRequest)
        {
            if (!IsLoggedIn(httpRequest))
            {
                return Redirect("/Users/Login");
            }

            string albumId = httpRequest.QueryData["albumId"].ToString();

            using (var context = new RunesDbContext())
            {
                Album albumFromDb = context.Albums.SingleOrDefault(album => album.Id == albumId);

                if (albumFromDb == null)
                {
                    return Redirect("/Albums/All");
                }

                string name = ((ISet<string>)httpRequest.FormData["name"]).FirstOrDefault();
                string link = ((ISet<string>)httpRequest.FormData["link"]).FirstOrDefault();
                string price = ((ISet<string>)httpRequest.FormData["price"]).FirstOrDefault();

                Track trackForDb = new Track
                {
                    Name = name,
                    Link = link,
                    Price = decimal.Parse(price)
                };

                albumFromDb.Tracks.Add(trackForDb);
                albumFromDb.Price = (albumFromDb.Tracks
                    .Select(track => track.Price)
                    .Sum() * 87) / 100;

                context.Update(albumFromDb);
                context.SaveChanges();
            }
            

            return Redirect($"/Albums/Details?id={albumId}");
        }

        public IHttpResponse Details(IHttpRequest httpRequest)
        {
            if (!IsLoggedIn(httpRequest))
            {
                return Redirect("/Users/Login");
            }

            string albumId = httpRequest.QueryData["albumId"].ToString();
            string trackId = httpRequest.QueryData["trackId"].ToString();

            using (var context = new RunesDbContext())
            {
                Track trackFromDb = context.Tracks.SingleOrDefault(track => track.Id == trackId);

                if (trackFromDb == null)
                {
                    return Redirect($"/Albums/Details?id={albumId}");
                }

                ViewData["AlbumId"] = albumId;
                ViewData["Track"] = trackFromDb.ToHtmlDetails(albumId);
                return View();
            }
        }
    }
}
