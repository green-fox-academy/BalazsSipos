using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject.Services;
using Microsoft.AspNetCore.Mvc;

namespace MediProject.Controllers
{
    public class UserController : Controller
    {
        private readonly IUserService userService;

        public UserController(IUserService userService)
        {
            this.userService = userService;
        }

        [HttpGet("/")]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost("/login")]
        public IActionResult AddUser(string userName, string countryName)
        {
            userService.AddUser(userName, countryName);
            return RedirectToAction(nameof(HomeController.Index), "Home", new { userName });
        }
    }
}