using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebAppWorkshop.Models;

namespace WebAppWorkshop.Controllers
{
    [Route("web")]
    //[ApiController]
    public class WebController : Controller
    {
        public static int Counter { get; set; } = 0;

        [HttpGet("greeting")]
        public IActionResult Greeting([FromQuery]string name)
        {
            this.increaseCounter();
            var greeting = new Greeting()
            {
                Id = 1,
                Content = $"Hello, {name}! This site was loaded {Counter} times since last server start."
            };

            return View(greeting);
        }

        private void increaseCounter()
        {
            Counter++;
        }
    }
}