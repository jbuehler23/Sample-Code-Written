using System;
using System.Collections.Generic;
using System.Linq;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Mvc;
using System.Configuration;
using BusinessApp.Models;

namespace BusinessApp.Models
{
    public class instructor
    {
        [RegularExpression(@"^\d+$", ErrorMessage = "Incorrect ID")]
        [Required]
        [Display(Name = "IONA ID")]
        public string Instructor_id { get; set; }
        [Required]
        public string First_Name { get; set; }
        [Required]
        public string Last_Name { get; set; }
        public string Full_Name { get; set; }
        [Required]
        public string Email { get; set; }
        [Required]
        public string Phone_Number { get; set; }
        public string Department { get; set; }
        public string Pref_Location { get; set; }

    }
}