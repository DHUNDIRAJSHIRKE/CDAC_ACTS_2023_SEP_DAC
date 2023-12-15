using System.Data.SqlClient;
namespace DB_Test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Insert(new Employee(1, "Shubham", 103, 20040));
        }
        public static void Insert(Employee  e)
        {
            
        }
    }
    public class Employee { 
        public Employee()
        {

        }
        public int Id { get; set; }
        public string Name { get; set; }
        public int DeptId { get;set; }
        public double Salary { get; set; }
        public Employee(int Id,string Name , int DeptNo,double Salary)
        {
            this.Id = Id;
            this.Name = Name;
            this.DeptId = DeptNo;
            this.Salary = Salary;

        }
    }

}