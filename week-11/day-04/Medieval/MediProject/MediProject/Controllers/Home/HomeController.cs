using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject.Models;
using MediProject.Services;
using Microsoft.AspNetCore.Mvc;

namespace MediProject.Controllers
{
    public class HomeController : Controller
    {
        private readonly IUserService userService;

        public HomeController(IUserService userService)
        {
            this.userService = userService;
        }

        [HttpGet("/home")]
        public IActionResult Index(string userName)
        {
            User user = this.userService.findByUserName(userName);
            return View(user);
        }
    }
}