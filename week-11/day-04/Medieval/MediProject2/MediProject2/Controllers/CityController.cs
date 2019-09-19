using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject2.Models;
using MediProject2.Services;
using Microsoft.AspNetCore.Mvc;

namespace MediProject2.Controllers
{
    public class CityController : Controller
    {
        private readonly ICityService cityService;

        public CityController(ICityService cityService)
        {
            this.cityService = cityService;
        }

        [HttpGet("/City/Edit/{cityId}")]
        public IActionResult Edit(int cityId)
        {
            City city= cityService.FindById(cityId);
            return View(city);
        }

        [HttpPost("/City/EditCity/{cityId}")]
        public IActionResult EditCity(int cityId, string cityName)
        {
            City city = cityService.FindById(cityId);
            if(city != null)
            {
                city.CityName = cityName;
                cityService.EditCity(city);
            }
            return RedirectToAction(nameof(CityController.Edit), "City", new { cityId });
        }
    }
}