using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebTest.Models
{
    public class Building
    {
        public int BuildingId { get; set; }
        public string Name { get; set; }
        public int High { get; set; }
        public string Architect { get; set; }
    }
}
