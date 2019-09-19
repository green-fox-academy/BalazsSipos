using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject2.Models;
using Microsoft.EntityFrameworkCore;

namespace MediProject2.Services
{
    public class UserService : IUserService
    {
        private readonly ApplicationContext applicationContext;

        public UserService(ApplicationContext applicationContext)
        {
            this.applicationContext = applicationContext;
        }

        public User AddUser(string userName, string countryName, string cityName)
        {
            User user = FindByUserName(userName);
            if (user == null)
            {
                User newUser = new User
                {
                    UserName = userName,
                    Country = new Country
                    {
                        CountryName = countryName
                    }
                };
                newUser.Country.Cities = new List<City>();
                City city = new City
                {
                    CityName = cityName
                };
                newUser.Country.Cities.Add(city);
                this.applicationContext.Users.Add(newUser);
                this.applicationContext.SaveChanges();
                return newUser;
            }
            return user;
        }

        public User FindByUserName(string userName)
        {
            User user = applicationContext.Users.Include(u => u.Country.Cities).FirstOrDefault(u => u.UserName == userName);
            return user;
        }
    }
}
