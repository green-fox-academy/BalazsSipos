using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebAppWorkshop.Models;

namespace WebAppWorkshop.Controllers
{
    [Route("api")]
    //[ApiController]
    public class RestController : ControllerBase
    {
        [Route("greeting")]
        [HttpGet("{name}")]
        public Greeting Greet(string name)
        {
            return new Greeting(1,$"Hello, {name}!");
        }
    }
}