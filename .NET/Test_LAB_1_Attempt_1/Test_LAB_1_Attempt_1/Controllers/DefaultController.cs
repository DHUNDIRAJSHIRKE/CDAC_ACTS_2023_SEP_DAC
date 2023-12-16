using Microsoft.AspNetCore.Mvc;
namespace WebApplications1.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id, int? a = 5, int? b = 10, int? c = 0)
        {
            {
                ViewBag.id = id;
                ViewBag.a = a;
                ViewBag.b = b;
                ViewBag.c = c;
                return View();
            }

        }

    }
}
