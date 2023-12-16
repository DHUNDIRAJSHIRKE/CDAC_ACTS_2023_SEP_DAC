namespace WebApplication1_trial_1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            WebApplicationBuilder builder = WebApplication.CreateBuilder(args);
            //returns WebApplicationBuilder
            //has services 
            
            // Add services to the container.
            builder.Services.AddControllersWithViews();

            var app = builder.Build();

            // the request , Between Server and Controller can be processed i.e. pipeline
            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }

            //in wwwroot folder, so the folder works
            app.UseStaticFiles();

            //when a request comes in , it comes with URL, using the URL, which action to trigger, is decided.
            app.UseRouting();

            //Authentication : Who are you? Identity
            //and Authorization : permissions
            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",//this name can be any name
                pattern: "{controller=Home}/{action=Index}/{id:int?}/{a?}/{b?}");//this is the only pattern , this website will recognize. 
                           //default value for controller is Home. default action is Index.
            //now it can accept requests
            //route is Valid URL.
            //actions are methods in Controller.
            //? in id indicates it need not be passed, it is optional
            //Employees/DisplayAll
            //Employees/DisplaySingle/1
            //Controller/Action/id
            //Employees   --> Employee/Index since Index is default for Action
            //multiple routes can be added
            /*app.MapControllerRoute(
                name: "default",//this name can be any name
                pattern: "{controller=Home}/{action=Index}/{id?}");
*/
            app.Run();
        }
    }
}
