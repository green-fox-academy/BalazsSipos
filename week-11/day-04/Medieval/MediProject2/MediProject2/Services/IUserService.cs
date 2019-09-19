using MediProject2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject2
{
    public interface IUserService
    {
        User AddUser(string userName, string countryName, string cityName);
        User FindByUserName(string userName);
    }
}
