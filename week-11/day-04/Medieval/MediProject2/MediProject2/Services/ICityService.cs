using MediProject2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject2.Services
{
    public interface ICityService
    {
        City FindByCityName(string cityName);
        City FindById(int cityId);
        City EditCity(City city);
    }
}
