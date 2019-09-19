using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MediProject.Models;
using Microsoft.EntityFrameworkCore;

namespace MediProject.Services
{
    public class UserService : IUserService
    {
        private readonly ApplicationContext applicationContext;

        public UserService(ApplicationContext applicationContext)
        {
            this.applicationContext = applicationContext;
        }

        public User AddUser(string userName, string countryName)
        {
            User user = findByUserName(userName);
            if(user == null)
            {
                User newUser = new User
                {
                    UserName = userName,
                    Country = new Country
                    {
                        CountryName = countryName
                    }
                };
                this.applicationContext.Users.Add(newUser);
                this.applicationContext.SaveChanges();
                return newUser;
            }
            return user;
        }

        public User findByUserName(string userName)
        {
            User user = applicationContext.Users.Include(u => u.Country).FirstOrDefault(u => u.UserName == userName);
            return user;
        }
    }
}
