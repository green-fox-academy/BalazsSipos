using MediProject2.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject2
{
    public class ApplicationContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Country> Countries { get; set; }
        public DbSet<UserProfile> UserProfiles { get; set; }
        public DbSet<City> Cities { get; set; }

        public ApplicationContext(DbContextOptions options) : base(options)
        {
        }
    }
}
