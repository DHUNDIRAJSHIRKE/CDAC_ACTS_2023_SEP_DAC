using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using WebApplication1_trial_1.Models;

namespace WebApplication1_trial_1.Controllers
{
    //this public class 'HomeController' needs to have 'Controller' suffix, to run, no Compiler errors, but won't run.
    public class HomeController : Controller//Base class for an MVC Controller with view Support
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)//Constructor Injection
        {
            _logger = logger;
        }


        //Action methods; URL mostly contains which Action method to call. 
        public IActionResult Index()
        {
            return View();//will lookout for a view having the same name as action method i.e. Index.cshtml (CSharpHTML)
        }
        //shared folder's view can be called from any Controller
        // URL: Home/Index --> will return Views/Home/Index.cshtml
        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
