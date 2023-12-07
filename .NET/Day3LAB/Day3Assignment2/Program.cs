namespace Day3Assignment2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("ENter no of EMp");
            int n = Convert.ToInt32(Console.ReadLine());
            Employee[] employees = new Employee[n];
            for(int i = 0; i < employees.Length; i++) 
            {
                Console.WriteLine("Enter Name : ");
                string Name = Console.ReadLine();

                Console.WriteLine("Enter Salary : ");
                double Salary = Convert.ToDouble(Console.ReadLine());

                Employee newEmp = new Employee(Salary, Name);
                employees[i] = newEmp;

            }
            for(int i = 0;i < employees.Length;i++)
            {
                Console.WriteLine(employees[i]);
            }

            /*double max = 0;
            for(int i = 0;i<employees.Length ; i++) 
            {

            }*/
        }
    }
    public class Employee
    {
        private static int idGen = 100;
        public int EmpNo;
        public double Salary;
        public string Name;
        public Employee(double Salary, string Name)
        {
            EmpNo = ++idGen;
            this.Name = Name;
            this.Salary = Salary;
        }
        public override string ToString()
        {
            return $"EmpNO ; {EmpNo} Name : {Name} Salary : {Salary}";
        }

    }
}