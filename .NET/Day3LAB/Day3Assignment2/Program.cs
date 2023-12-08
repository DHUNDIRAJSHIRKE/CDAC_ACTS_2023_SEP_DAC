namespace Day3Assignment2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("ENter NO of employees: ");
            int l = Convert.ToInt32(Console.ReadLine());
            Employee[] emps = new Employee[l];
            string? name = "";
            double salary = 0.0;

            for (int i = 0; i < l; i++)
            {
                Console.WriteLine("Enter details of employee " + (i + 1));
                Console.WriteLine("Name: ");
                name = Console.ReadLine();
                Console.WriteLine("Salary: ");
                salary = Convert.ToDouble(Console.ReadLine());
                Employee newEmp = new Employee(name, salary);
                emps[i] = newEmp;
            }
            Console.WriteLine();
            for (int i = 0; i < emps.Length; i++)
            {
                Console.WriteLine(emps[i]);
            }
            double highest = 0;
            int highId = -1;
            foreach (Employee e in emps)
            {
                if (e.salary > highest)
                {
                    highId = e.id;
                    highest = e.salary;
                }
            }
            bool exit = false;
            while (!exit)
            {
                Console.WriteLine("Employee with highest Salary : " + emps[highId]);
                Console.WriteLine("Enter a id : ");
                int id = -1;
                id = Convert.ToInt32(Console.ReadLine());
                if (id >= 0 && id < emps.Length)
                {
                    Console.WriteLine(emps[id]);
                }
                else
                {
                    exit = true;
                }
            }
        }
    }
    public class Employee
    {
        private static int Idcount = 0;

        public int id;
        public string name;
        public double salary;
        public Employee(string name, double salary)
        {
            id = Idcount++;
            this.name = name;
            this.salary = salary;
        }
        public override string ToString()
        {
            return "Employee [ ID : " + id + " Name : " + name + " Salary: " + salary + " ]";
        }
    }
}
