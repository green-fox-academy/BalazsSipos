using MediProject2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject2.Services
{
    public interface ICountryService
    {
        Country FindByCountryName(string countryName);
        Country FindById(int countryId);
    }
}
