using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject.Models
{
    public class User
    {
        public int UserId { get; set; }
        public string UserName { get; set; }
        public Country Country { get; set; }
        public UserProfile Userprofile { get; set; }
    }
}
