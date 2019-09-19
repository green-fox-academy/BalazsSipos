using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject2.Models;
using Microsoft.EntityFrameworkCore;

namespace MediProject2.Services
{
    public class CountryService : ICountryService
    {
        private readonly ApplicationContext applicationContext;

        public CountryService(ApplicationContext applicationContext)
        {
            this.applicationContext = applicationContext;
        }

        public Country FindByCountryName(string countryName)
        {
            Country country = applicationContext.Countries.Include(c => c.Cities).FirstOrDefault(c => c.CountryName == countryName);
            return country;
        }

        public Country FindById(int countryId)
        {
            return applicationContext.Countries.Include(c => c.Cities).FirstOrDefault(c => c.CountryId == countryId);
        }
    }
}
