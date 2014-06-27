using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MySql.Data.MySqlClient;
using MySql.Data;
using BusinessApp.Models;
using BusinessApp.ViewModels;

namespace BusinessApp.Controllers
{
    public class StudentController : Controller
    {
        //
        // GET: /Student/
        public ActionResult Index()
        {
            var model = new students_table().ToString();
            
            return View(model);
        }

        public ActionResult AddStudent()
        {
            // Populate locations dropdown
            var loc = new SelectListItem[3] ;

            loc[0] = new SelectListItem { Value = "New Rochelle", Text = "New Rochelle" };
            loc[1] = new SelectListItem { Value = "Yonkers", Text = "Yonkers" };
            loc[2] = new SelectListItem { Value = "SUNY", Text = "SUNY" };

            ViewData["preferredLocation"] = loc;

            Student newStudent = new Student();
            return View(newStudent);
        }

        [HttpPost]
        public ActionResult AddStudent(Student studentToAdd)
        {
            // Populate locations dropdown to send to view if validation fails
            var loc = new SelectListItem[3];

            loc[0] = new SelectListItem { Value = "New Rochelle", Text = "New Rochelle" };
            loc[1] = new SelectListItem { Value = "Yonkers", Text = "Yonkers" };
            loc[2] = new SelectListItem { Value = "SUNY", Text = "SUNY" };

            string age = "22";
            string athlete, loans;
            string freeDays = "";
            

            ViewData["preferredLocation"] = loc;

            // Check input
            if (ModelState.IsValid)
            {
                MySqlConnection msqlConnection = new MySqlConnection("server=localhost; user id=root; database=software_proj; ");

                try
                {
                    if(studentToAdd.athlete.Equals("true"))
                        athlete="T";
                    else athlete="F";

                    if (studentToAdd.acceptingLoans.Equals("true"))
                        loans = "T";
                    else loans = "F";

                    if (studentToAdd.n[0] == true)
                        freeDays += "Monday";
                    if (studentToAdd.n[1] == true)
                        freeDays += " Tuesday";
                    if (studentToAdd.n[2] == true)
                        freeDays += " Wednesday";
                    if (studentToAdd.n[3] == true)
                        freeDays += " Thursday";
                    if (studentToAdd.n[4] == true)
                        freeDays += " Friday";

                    
                    //open the connection
                    msqlConnection.Open();

                    // Format insert query
                    string insertQuery = string.Format("INSERT into students_table (IONA_Student_id, First_Name, Last_Name, Full_Name, Date_of_Birth, " +
                        "Age, Email, Phone_Number, Street_Address, City, Zip_Code, Total_Credits_Complete, Prefered_Location, MBA_Speed, Student_Type, " +
                        "Days_Available, Athlete, Loans) VALUES ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}','{15}','{16}','{17}') ", studentToAdd.ionaID,
                        studentToAdd.firstName, studentToAdd.lastName, studentToAdd.firstName + " " + studentToAdd.lastName, studentToAdd.DOB, age, studentToAdd.email,
                        studentToAdd.phoneNum, studentToAdd.address, studentToAdd.city, studentToAdd.zip, studentToAdd.totalCredits, studentToAdd.preferredLocation,
                        "derp", studentToAdd.studentType, freeDays, athlete, loans);

                    MySql.Data.MySqlClient.MySqlCommand myCommand = new MySql.Data.MySqlClient.MySqlCommand(insertQuery, msqlConnection);

                    //execute
                    myCommand.ExecuteNonQuery();
                    
  
                }
                catch (Exception er)
                {
                    //do something with the exception
                }
                finally
                {
                    //always close the connection
                    msqlConnection.Close();
                }

                // On successful insert, redirect to student's newly created plan of study page
               // return Redirect("PlanOfStudy");
                return RedirectToAction("PlanOfStudy", "Student", new { ID = studentToAdd.ionaID });
            }
            // Return original form to fix errors
            return View(studentToAdd);
        }
         
        
        public ActionResult LookupStudent()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LookupStudentID()
        {
            return Redirect("/");
        }

        [HttpPost]
        public ActionResult LookupStudentName()
        {
            return Redirect("google.com");
        }


        public ActionResult PlanOfStudy(string ID)
        {
            ViewData["studentID"] = ID;
            // DISPLAY PLAN OF STUDY FOR STUDENT USING ID
            
            return View();
        }



    }
}
