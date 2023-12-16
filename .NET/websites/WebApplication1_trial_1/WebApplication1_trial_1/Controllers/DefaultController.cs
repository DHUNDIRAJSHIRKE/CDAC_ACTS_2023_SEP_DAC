using Microsoft.AspNetCore.Mvc;

namespace WebApplication1_trial_1.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id,int a, int b,int c)//value of id will be automatically put in if the name is same as in the root
        {//ideally returning view should have same name as method name
            /*if(id == null){
                return NotFound();
            }else {
                return View();
                //return View("Index1");
            }*/
            //ViewBag : Dynamic Object. can add properties at runtime.
            //ViewBag is also available in the view
            ViewBag.Id = id;
            ViewBag.A = a;
            ViewBag.B = b;
            ViewBag.C = c;
            return View();
        }
    }
}
