using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject2.Models;

namespace MediProject2.Services
{
    public class CityService : ICityService
    {
        private readonly ApplicationContext applicationContext;

        public CityService(ApplicationContext applicationContext)
        {
            this.applicationContext = applicationContext;
        }

        public City FindByCityName(string cityName)
        {
            City city = applicationContext.Cities.FirstOrDefault(c => c.CityName == cityName);
            return city;
        }

        public City FindById(int cityId)
        {
            return applicationContext.Cities.FirstOrDefault(c => c.CityId == cityId);
        }

        public City EditCity(City city)
        {
            if(city != null)
            {
                applicationContext.Cities.Update(city);
                applicationContext.SaveChanges();
            }
            return city;
        }
    }
}
