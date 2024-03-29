﻿using System;
using System.Collections.Generic;
using System.Linq;
using BusinessApp.Models;
using BusinessApp.ViewModels;
using System.Web;
using System.Web.Mvc;

namespace BusinessApp.Controllers
{
    public class TeachersController : Controller
    {
        private software_projEntities db = new software_projEntities();
        
        //
        // GET: /Teachers/

        public ActionResult Index()
        {
            return View();
        }

        //
        // GET: /Teachers/Details/5

        public ActionResult Details(int id)
        {
            return View();
        }

        //
        // GET: /Teachers/Create

        public ActionResult Create()
        {
          
            
            return View();
        } 

        //
        // POST: /Teachers/Create

        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        
        //
        // GET: /Teachers/Edit/5
 
        public ActionResult Edit(int id)
        {
            instructor teacher = this.db.instructors.First();
            
            return View();
        }

        //
        // POST: /Teachers/Edit/5

        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Teachers/Delete/5
 
        public ActionResult Delete(int id)
        {
            return View();
        }

        //
        // POST: /Teachers/Delete/5

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
