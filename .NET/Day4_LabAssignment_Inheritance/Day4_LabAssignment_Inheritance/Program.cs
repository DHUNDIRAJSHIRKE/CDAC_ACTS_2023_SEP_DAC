namespace Day4_LabAssignment_Inheritance
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Manager manager1 = new Manager("Atharva", 2, 66000, "HR Manager");
            Console.WriteLine(manager1.Name + " Salary : " + manager1.CalcNetSalaray());
            Console.WriteLine("Hello, World!");
        }
    }
    public class CEO : Employee
    {
        public override decimal Basic
        {
            get { return basic; }
            set
            {
                if (value < 50000)
                {
                    Console.WriteLine("CEO's Basic can't be less than 50000");
                }
                else
                {
                    basic = value;
                }
            }
        }
        public CEO(string Name, short DeptNo, decimal Basic) : base(Name, DeptNo, Basic)
        {
        }

        //public override decimal Basic { get => throw new NotImplementedException(); set => throw new NotImplementedException(); }

        public override decimal CalcNetSalaray()
        {
            decimal netSal = 0;
            return netSal;
        }
    }
    public class GeneralManager : Manager
    {
        private string? perks;
        public string Perks
        {
            get { return perks; }
            set { perks = value; }
        }
        public GeneralManager(string Name, short DeptNo, decimal Basic, string Designation, string Perks) : base(Name, DeptNo, Basic, Designation)
        {
            this.Perks = Perks;
        }
        public override decimal CalcNetSalaray()
        {
            return basic * (17 / 10);
        }
    }
    public class Manager : Employee
    {
        private string designation;
        public string Designation
        {
            get
            {
                return designation;
            }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    Console.WriteLine("Designation can't be blank!!");
                }
                else
                {
                    designation = value;
                }
            }
        }

        public Manager(string Name, short DeptNo, decimal Basic, string Designation) : base(Name, DeptNo, Basic)
        {
            this.Designation = Designation;
        }


        public override decimal Basic
        {
            get
            {
                return basic;
            }
            set
            {
                if (value < 10000)
                {
                    Console.WriteLine("Manager's Basic Can't be less than 10000");
                }
                else
                {
                    basic = value;
                }
            }
        }
        public override decimal CalcNetSalaray()
        {
            return Basic +55;
        }
    }
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }
    public abstract class Employee : IDbFunctions
    {
        private static int idGen = 100;
        private string? name;
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    Console.WriteLine("Invalid Name!!");
                }
                else
                {
                    name = value;
                }
            }
        }
        private int empNo;
        public int EmpNo
        {
            get { return empNo; }
        }
        private short deptNo;
        public short DeptNo
        {
            get { return deptNo; }
            set
            {
                if (value <= 0)
                {
                    Console.WriteLine("ENter valid dept no");
                }
                else
                {
                    deptNo = value;
                }
            }
        }
        protected decimal basic;
        public abstract decimal Basic
        {
            get;
            set;
        }


        public Employee(string Name, short DeptNo, decimal Basic)
        {
            empNo = idGen++;
            this.Name = Name;
            this.DeptNo = DeptNo;
            this.Basic = Basic;
        }
        public abstract decimal CalcNetSalaray();

        public void Insert()
        {
            throw new NotImplementedException();
        }

        public void Update()
        {
            throw new NotImplementedException();
        }

        public void Delete()
        {
            throw new NotImplementedException();
        }
    }
}