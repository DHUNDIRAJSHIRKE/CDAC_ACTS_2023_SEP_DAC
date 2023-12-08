using Mathmatics;
namespace Assignment_1_054
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Employee o1 = new Employee("Amol", 123454565, -10);
            Employee o2 = new Employee("Bharat", 45);
            Employee o3 = new Employee("Chaitanya");
            Employee o4 = new Employee();
            Console.WriteLine("Enter Details Of Employee: ");


            //Console.ReadLine();
            Employee o5 = new Employee();
            Console.WriteLine(o1);
            Console.WriteLine(o2);
            Console.WriteLine(o3);
            Console.WriteLine(o4);
            Console.WriteLine(o5);
            Console.WriteLine(o1.GetNetSalary());

            Console.WriteLine(maths.getNetSalary(12223));
        }
    }
    public class Employee
    {
        private static int s_EmpNo = 100;
        private int empNo;
        public int EmpNo
        {
            get { return empNo; }
        }
        private string name;
        public string Name
        {
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    Console.WriteLine("Invalid name");
                }
                name = value;
            }
            get { return name; }
        }
        private decimal basic;
        public decimal Basic
        {
            get { return basic; }
            set 
            {
                if(value>=11000 && value <= 56000)
                {
                    basic = value;
                }
                else
                {
                    Console.WriteLine("Invalid. Should be between 11000 to 56000"+this.Name);
                }
            }
        }
        private short deptNo = 0;
        public short DeptNo
        {
            get
            {
                return deptNo;
            }
            set 
            {
                if (value <= 0)
                {
                    Console.WriteLine("Dept no should be more than 0" + this.Name);
                }
                else
                {
                    deptNo = value;
                }
            }
        }



        public Employee(string Name = "xyz", decimal Basic = 11000, short DeptNo = 1)
        {
            empNo = ++s_EmpNo;
            this.Name=Name;
            this.Basic=Basic;
            this.DeptNo= DeptNo;
        }



        public decimal GetNetSalary()
        {
            return Basic * (14 / 10) + 5500;
        }




        public override string ToString()
        {
            return "Employee [EmpNo :" + EmpNo + " Name : " + Name + " Basic " + Basic + " DeptNo " + DeptNo + " ]";
        }
    }

}