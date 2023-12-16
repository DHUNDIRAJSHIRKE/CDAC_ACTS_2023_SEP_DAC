using Microsoft.Data.Sql;
using Microsoft.Data.SqlClient;
//acquire a connection as late as possible and release it as early as possible
namespace Day_9_DB_Attempt_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            //Connect();
            Employee newEmp = new Employee(9, "O'brien", 10000, 102);
            //Insert3(newEmp);
            Insert4(newEmp);
        }
        static void Connect()
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = cn.CreateCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.Text;//direct statement : Text
                                                                         //Call a stored procedure, StoredProcedure
                                                                         //Stored procedures are faster than text, prefer that over text. Third option is , Table directory, it is for backward compatibility
                    cmdInsert.CommandText = "INSERT INTO Employees values(5,'Shivani',12345,103)";
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                    //Console.WriteLine("Connection opened");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }


                //Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False
                //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
                //Integrated security tool uses windows Authentication.... same password and user id as windows.
               
            
        }

        static void Insert2(Employee emp)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = cn.CreateCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.Text;//direct statement : Text
                                                                         //Call a stored procedure, StoredProcedure
                                                                         //Stored procedures are faster than text, prefer that over text. Third option is , Table directory, it is for backward compatibility
                    cmdInsert.CommandText = $"INSERT INTO Employees values({emp.Id},'{emp.Name}',{emp.Salary},{emp.DeptNo})";
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                    //Console.WriteLine("Connection opened");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }

        }
        static void Insert3(Employee obj)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = cn.CreateCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.Text;//direct statement : Text
                                                                         //Call a stored procedure, StoredProcedure
                                                                         //Stored procedures are faster than text, prefer that over text. Third option is , Table directory, it is for backward compatibility
                    cmdInsert.CommandText = $"INSERT INTO Employees values(@EmpNo,@Name,@Salary,@DeptNo)";
                    cmdInsert.Parameters.AddWithValue("@EmpNo", obj.Id);
                    cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                    cmdInsert.Parameters.AddWithValue("@Salary", obj.Salary);
                    cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                    //Console.WriteLine("Connection opened");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }
        static void Insert4(Employee obj)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = cn.CreateCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.StoredProcedure;//direct statement : Text
                                                                         //Call a stored procedure, StoredProcedure
                                                                         //Stored procedures are faster than text, prefer that over text. Third option is , Table directory, it is for backward compatibility
                    cmdInsert.CommandText = "InsertEmployee";
                    cmdInsert.Parameters.AddWithValue("@EmpNo", obj.Id);
                    cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                    cmdInsert.Parameters.AddWithValue("@Salary", obj.Salary);
                    cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                    cmdInsert.ExecuteNonQuery();
                    Console.WriteLine("Success");
                    //Console.WriteLine("Connection opened");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }

    }
    public class Employee
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public double Salary{ get; set; }
        public int DeptNo{ get; set; }
        public Employee(int Id, string Name, double Salary,int DeptNo) 
        {
            this.Id = Id;
            this.Name = Name;
            this.DeptNo = DeptNo;
            this.Salary = Salary;
        }
    }
}
