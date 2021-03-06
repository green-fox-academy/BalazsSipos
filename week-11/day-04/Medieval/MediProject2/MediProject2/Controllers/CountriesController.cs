﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MediProject2;
using MediProject2.Models;
using MediProject2.Services;

namespace MediProject2.Controllers
{
    public class CountriesController : Controller
    {
        private readonly ICountryService countryService;

        public CountriesController(ICountryService countryService)
        {
            this.countryService = countryService;
        }

        public IActionResult Details(int Id)
        {
            Country country = countryService.FindById(Id);
            return View(country);
        }

        
    }
}
