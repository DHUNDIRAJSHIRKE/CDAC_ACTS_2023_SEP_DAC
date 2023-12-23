using Book_MVC_EFC.Models;
using Microsoft.EntityFrameworkCore;

namespace Book_MVC_EFC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();
            builder.Services.AddDbContext<BooksMvcContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("BooksMvcContext")));
            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=TblBooks}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
