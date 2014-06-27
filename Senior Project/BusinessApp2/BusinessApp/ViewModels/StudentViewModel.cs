using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BusinessApp.ViewModels
{
    public class StudentViewModel
    {
        public List<CheckBoxes> CheckBoxList { get; set; }
    }

    public class CheckBoxes
    {
        public string Text;
        public bool Checked;
    }
}