using System.ComponentModel.DataAnnotations;
using System.Data;
using Microsoft.Data.SqlClient;

namespace CRUD_Practice_1.Models
{
    public class Employee
    {
        [Key]
        [Display(Name="Employee Number")]
        public int EmpNo { get; set; }
        
        [Required(ErrorMessage ="Please Enter Name")]
        [StringLength(10,ErrorMessage ="The {0} value can't exceed {1} characters ")]
        public string Name {
            get
            {
                return Name;
            }
            set
            {
                if (Name.length() > 0)
                {
                    throw new ArgumentException("Name can't be null!!");
                }
            }
        public int DeptNo { get; set; }
        [DataType(DataType.Text)]//these Datatypes are Based on the datatype in HTML, 
        public decimal Basic { get; set; }
        [Required(ErrorMessage ="Please Enter Confirm Password")]
        [Compare("Password",ErrorMessage ="Password didn't match with the Password!!")]
        [DataType(DataType.Password)]
        public string ConfirmPassword { get; set; } 
        public static List<Employee> GetAllEmployees()
        {
            List<Employee> list = new List<Employee>();

            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees ";

                SqlDataReader dr = cmd.ExecuteReader();
                while (dr.Read())
                {
                    Employee emp = new Employee();
                    emp.EmpNo = dr.GetInt32(0);
                    emp.DeptNo = dr.GetInt32("DeptNo");
                    emp.Name = dr.GetString("Name");
                    emp.Basic = dr.GetDecimal("Basic");
                    //Console.WriteLine(emp.ToString());
                    list.Add(emp);

                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }


            return list;
        }
        public static Employee GetSingleEmployee(int EmpNo)
        {
            Employee emp = new Employee();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees where EmpNo = @id";
                cmd.Parameters.AddWithValue("id", EmpNo);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    emp.EmpNo = dr.GetInt32(0);
                    emp.DeptNo = dr.GetInt32("DeptNo");
                    emp.Name = dr.GetString("Name");
                    emp.Basic = dr.GetDecimal("Basic");
                    Console.WriteLine(emp.ToString());
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            return emp;
        }
        public static void Insert(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.StoredProcedure;
                cmdInsert.CommandText = "InsertEmployee";

                cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
                cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                cmdInsert.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        public static void UpdateEmployee( Employee emp)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True";
            cn.Open();
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdDelete = new SqlCommand();
            cmdDelete.Connection = cn;
            cmdDelete.Transaction = t;

            cmdDelete.CommandType = System.Data.CommandType.Text;
            cmdDelete.CommandText = "UPDATE Employees SET Name=@name, Basic=@basic, DeptNo=@deptNo WHERE EmpNo = @id";
            cmdDelete.Parameters.AddWithValue("name", emp.Name);
            cmdDelete.Parameters.AddWithValue("basic", emp.Basic);
            cmdDelete.Parameters.AddWithValue("deptNo", emp.DeptNo);
            cmdDelete.Parameters.AddWithValue("id", emp.EmpNo);
            //Console.WriteLine("PK 12 created, dept 30");
            /*
            SqlCommand cmdInsert2 = new SqlCommand();
            cmdInsert2.Connection = cn;
            cmdInsert2.Transaction = t;

            cmdInsert2.CommandType = System.Data.CommandType.Text;
            cmdInsert2.CommandText = "insert into Employees values(13, 'Shweta', 12345, 103)";
            Console.WriteLine("PK 20 created, dept 30");
            */

            try
            {
                cmdDelete.ExecuteNonQuery();
                Console.WriteLine($"PK {emp.EmpNo} Updated");

                t.Commit();
                Console.WriteLine("no errors- commit");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine("Rollback");
                Console.WriteLine(ex.Message);
            }
            cn.Close();
        }
        public static void DeleteEmployee(int  id)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True";
            cn.Open();
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdDelete = new SqlCommand();
            cmdDelete.Connection = cn;
            cmdDelete.Transaction = t;

            cmdDelete.CommandType = System.Data.CommandType.Text;
            cmdDelete.CommandText = "DELETE Employees WHERE EmpNo = @id";
        
            cmdDelete.Parameters.AddWithValue("id", id);
            //Console.WriteLine("PK 12 created, dept 30");
            /*
            SqlCommand cmdInsert2 = new SqlCommand();
            cmdInsert2.Connection = cn;
            cmdInsert2.Transaction = t;

            cmdInsert2.CommandType = System.Data.CommandType.Text;
            cmdInsert2.CommandText = "insert into Employees values(13, 'Shweta', 12345, 103)";
            Console.WriteLine("PK 20 created, dept 30");
            */

            try
            {
                cmdDelete.ExecuteNonQuery();
                //Console.WriteLine($"PK {emp.EmpNo} Updated");

                t.Commit();
                Console.WriteLine("no errors- commit");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine("Rollback");
                Console.WriteLine(ex.Message);
            }
            cn.Close();
        }
    }
}
