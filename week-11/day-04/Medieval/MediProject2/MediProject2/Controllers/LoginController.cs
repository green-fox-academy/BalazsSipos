using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace MediProject2.Controllers
{
    public class LoginController : Controller
    {
        private readonly IUserService userService;

        public LoginController(IUserService userService)
        {
            this.userService = userService;
        }

        public IActionResult Login()
        {
            return View();
        }

        public IActionResult AddUser(string userName, string countryName, string cityName)
        {
            userService.AddUser(userName, countryName, cityName);
            return RedirectToAction(nameof(HomeController.Index), "Home", new { userName });
        }

        public IActionResult Logout()
        {
            return RedirectToAction(nameof(LoginController.Login), "Login");
        }
    }
}