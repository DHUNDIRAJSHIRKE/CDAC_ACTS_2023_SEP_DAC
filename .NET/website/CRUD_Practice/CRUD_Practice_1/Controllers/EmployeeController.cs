using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using CRUD_Practice_1.Models;
using Elfie.Serialization;
namespace CRUD_Practice_1.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: EmployeeController
        public ActionResult Index()
        {

            List<Models.Employee> list = Models.Employee.GetAllEmployees();
            return View(list);
        }

        // GET: EmployeeController/Details/5
        public ActionResult Details(int id)
        {
            Employee emp = Employee.GetSingleEmployee(id);
            //Employee emp = Employee.
            return View(emp);
        }

        // GET: EmployeeController/Create
        public ActionResult Create()
        {

            return View();
        }

        // POST: EmployeeController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee emp)
        {
            try
            {
                Employee.Insert(emp);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeeController/Edit/5
        public ActionResult Edit(int id)
        {
            Employee emp = Employee.GetSingleEmployee(id);
            return View(emp);
        }

        // POST: EmployeeController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit( Employee emp)
        {
            try
            {
                Employee.UpdateEmployee(emp);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeeController/Delete/5
        public ActionResult Delete(int id)
        {
            Employee emp = Employee.GetSingleEmployee(id);
            return View(emp);
        }

        // POST: EmployeeController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id ,IFormCollection formCollection )
        {
            try
            {
                Employee.DeleteEmployee(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
