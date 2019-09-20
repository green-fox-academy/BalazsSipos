using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace MediProject2.Models
{
    public class Building
    {
        public int BuildingId { get; set; }
        [Required]
        public string Name { get; set; }
        public int High { get; set; }
        public string Architect { get; set; }
    }
}
