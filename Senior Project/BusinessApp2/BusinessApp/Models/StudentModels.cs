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
    #region Models

    
    public class Student
    {
        
        // Change in DB to string for searching
        [RegularExpression(@"^\d+$", ErrorMessage = "Incorrect ID")]
        [Required]
        [Display(Name="IONA ID")]
        public string ionaID { get; set; }
        [Required]
        public string firstName { get; set; }
        [Required]
        public string lastName { get; set; }
        [Required]
        public string DOB { get; set; }
        [Required]
        [EmailValidation(ErrorMessage="Not a valid email address")]
        public string email { get; set; }
        [RegularExpression(@"^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$", ErrorMessage = "Not a valid phone number")]
        [Required]
        public string phoneNum { get; set; }
        [Required]
        public string address { get; set; }
        [Required]
        public string city { get; set; }
        [Required]
        public string zip { get; set; }
        [RegularExpression(@"^\d+$", ErrorMessage = "Incorrect number")]
        [Required]
        public int totalCredits { get; set; }
        
        public string preferredLocation { get; set; }
        
        public string studentType { get; set; }

        public bool[] n { get; set; }
        
        public string athlete { get; set; }
        
        public string acceptingLoans { get; set; }
    }
}
    #endregion

  