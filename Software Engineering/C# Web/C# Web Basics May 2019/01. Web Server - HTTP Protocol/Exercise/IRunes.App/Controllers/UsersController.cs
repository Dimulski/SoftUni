using IRunes.Data;
using IRunes.Models;
using SIS.HTTP.Requests;
using SIS.HTTP.Responses;
using SIS.MvcFramework;
using SIS.MvcFramework.Attributes;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

namespace IRunes.App.Controllers
{
    public class UsersController : Controller
    {
        private string HashPassword(string password)
        {
            using (SHA256 sha256Hash = SHA256.Create())
            {
                return Encoding.UTF8.GetString(sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(password)));
            }
        }

        public IHttpResponse Login(IHttpRequest httpRequest)
        {
            return View();
        }

        [HttpPost(ActionName = "Login")]
        public IHttpResponse LoginConfirm(IHttpRequest httpRequest)
        {
            using (var context = new RunesDbContext())
            {
                string username = ((ISet<string>)httpRequest.FormData["username"]).FirstOrDefault();
                string password = ((ISet<string>)httpRequest.FormData["password"]).FirstOrDefault();

                User userFromDb = context.Users.FirstOrDefault(
                    user => user.Username == username && user.Password == HashPassword(password) ||
                    user.Email == username &&
                    user.Password == HashPassword(password));

                if (userFromDb == null)
                {
                    return Redirect("/Users/Login");
                }

                SignIn(httpRequest, userFromDb.Id, userFromDb.Username, userFromDb.Email);
            }

            return Redirect("/");
        }

        public IHttpResponse Register(IHttpRequest httpRequest)
        {
            return View();
        }

        [HttpPost(ActionName = "Register")]
        public IHttpResponse RegisterConfirm(IHttpRequest httpRequest)
        {
            using (var context = new RunesDbContext())
            {
                string username = ((ISet<string>)httpRequest.FormData["username"]).FirstOrDefault();
                string password = ((ISet<string>)httpRequest.FormData["password"]).FirstOrDefault();
                string confirmPassword = ((ISet<string>)httpRequest.FormData["confirmPassword"]).FirstOrDefault();
                string email = ((ISet<string>)httpRequest.FormData["email"]).FirstOrDefault();

                if (password != confirmPassword)
                {
                    return Redirect("/Users/Register");
                }

                User user = new User
                {
                    Username = username,
                    Password = HashPassword(password),
                    Email = email
                };

                context.Users.Add(user);
                context.SaveChanges();

                return this.Redirect("/Users/Login");
            }
        }

        public IHttpResponse Logout(IHttpRequest httpRequest)
        {
            SignOut(httpRequest);

            return Redirect("/");
        }
    }
}
