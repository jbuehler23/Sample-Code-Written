using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MySql.Data.MySqlClient;
using MySql.Data;
using BusinessApp.Models;
using BusinessApp.ViewModels;
using System.Web.Mvc;

namespace BusinessApp.Controllers
{
    public class TeacherController : Controller
    {
        private software_projEntities db = new software_projEntities();
        
        //
        // GET: /Teacher/

        public ActionResult Index()
        {
            var teachers = this.db.instructors;          
            return View(teachers.ToList());
        }

        public ActionResult Edit(int id)
        {
            instructor teacher = this.db.instructors.First();

            return View(teacher);
        }

        public ActionResult Delete(int id)
        {
            instructor teacher = this.db.instructors.Where(f => f.Instructor_id == id).First() ;

            if (teacher == null)
            {
                return RedirectToAction("/");
            }

            return this.View(teacher);
        }

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                instructor teacher = this.db.instructors.Where(f => f.Instructor_id == id).First();
                this.db.instructors.DeleteObject(teacher);
                this.db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        

        public ActionResult AddTeacher()
        {
            var loc = new SelectListItem[3];
            
            loc[0] = new SelectListItem { Value = "New Rochelle", Text = "New Rochelle" };
            loc[1] = new SelectListItem { Value = "Yonkers", Text = "Yonkers" };
            loc[2] = new SelectListItem { Value = "SUNY", Text = "SUNY" };

            var dept = new SelectListItem[8];
            dept[0] = new SelectListItem { Value = "Financial Management", Text = "Financial Management"};
            dept[1] = new SelectListItem { Value = "Information Systems", Text = "Information Systems" };
            dept[2] = new SelectListItem { Value = "Management", Text = " Management" };
            dept[3] = new SelectListItem { Value = "Human Resource Management", Text = "Human Resource Management" };
            dept[4] = new SelectListItem { Value = "Marketing", Text = "Marketing" };
            dept[5] = new SelectListItem { Value = "General Accounting", Text = "General Accounting" };
            dept[6] = new SelectListItem { Value = "Public Accounting", Text = "Public Accounting" };
            dept[7] = new SelectListItem { Value = "Healthcare Management", Text = "Healthcare Management" };

            ViewData["Department"] = dept;
            ViewData["Pref_Location"] = loc;

            instructor newTeacher = new instructor();
            return View(newTeacher);
        }

        [HttpPost]
        public ActionResult AddTeacher(instructor teacher)
        {
            var loc = new SelectListItem[3];

            loc[0] = new SelectListItem { Value = "New Rochelle", Text = "New Rochelle" };
            loc[1] = new SelectListItem { Value = "Yonkers", Text = "Yonkers" };
            loc[2] = new SelectListItem { Value = "SUNY", Text = "SUNY" };

            ViewData["PrefLocation"] = loc;
            
            
            if(ModelState.IsValid)
            {
                
                this.db.instructors.AddObject(teacher);
                this.db.SaveChanges();

                return RedirectToAction("Index");

                
            }
            // Return original form to fix errors
            return View(teacher);
        }
    }
}
