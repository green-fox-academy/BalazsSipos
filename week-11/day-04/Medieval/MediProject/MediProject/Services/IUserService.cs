using MediProject.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject.Services
{
    public interface IUserService
    {
        User AddUser(string userName, string countryName);
        User findByUserName(string userName);
    }
}
