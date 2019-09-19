using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebAppWorkshop.Models
{
    public class Greeting
    {
        public long Id { get; set; }
        public string Content { get; set; }

        public Greeting(long id, string content)
        {
            Id = id;
            Content = content;
        }

        public Greeting()
        {
        }
    }
}
