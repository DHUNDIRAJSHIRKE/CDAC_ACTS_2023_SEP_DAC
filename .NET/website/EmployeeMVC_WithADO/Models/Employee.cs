using Microsoft.Data.SqlClient;
using System.Data;

namespace EmployeeMVC_WithADO.Models
{
    public class Employee
    {
        public int EmpID { get; set; }
        public string Name { get; set; }
        public string City { get; set; }
        public string Address { get; set; }
        
        public static List<Employee> GetAllEmployees()
        {
            var employees = new List<Employee>();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeesDB_ADO;Integrated Security=True";
            cn.Open();
            SqlCommand cmd = cn.CreateCommand();
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.CommandText = "SELECT * FROM Employees";
            SqlDataReader dr = cmd.ExecuteReader();
            while(dr.Read())
            {
                Employee emp = new Employee();
                emp.EmpID = dr.GetInt32("EmpID");
                emp.Name = dr.GetString("Name");
                emp.City = dr.GetString("City");
                emp.Address = dr.GetString("Address");
                employees.Add(emp);
            }
            cn.Close(); 
            return employees;
        }

        public static Employee GetEmployee(int empID)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeesDB_ADO;Integrated Security=True";
            cn.Open();
            SqlCommand cmd = cn.CreateCommand();
            cmd.CommandType =System.Data.CommandType.Text;
            cmd.CommandText = "SELECT * FROM Employees where EmpID = @id";
            cmd.Parameters.AddWithValue("id", empID);
            SqlDataReader dr = cmd.ExecuteReader();
            Employee emp = new Employee();
            if (dr.Read())
            {
                emp.EmpID = empID;
                emp.Name = dr.GetString("Name");
                emp.City = dr.GetString("City");
                emp.Address = dr.GetString("Address");
            }
            cn.Close();
            return emp;
        }

        public static void DeleteEmployee(int id)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeesDB_ADO;Integrated Security=True";
            cn.Open();
            SqlCommand cmd = cn.CreateCommand();
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.CommandText= "DELETE FROM Employees WHERE EmpId = @id";
            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();
            cn.Close();

        }

        public static void InsertEmployee(Employee emp)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeesDB_ADO;Integrated Security=True";
            cn.Open();
            SqlCommand cmd = cn.CreateCommand();
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.CommandText = "INSERT INTO Employees VALUES(@Name,@City,@Address)";
            cmd.Parameters.AddWithValue("@City", emp.City);
            cmd.Parameters.AddWithValue ("@Name", emp.Name);
            cmd.Parameters.AddWithValue("@Address", emp.Address);
            cmd.ExecuteNonQuery ();
            cn.Close();
        }

        public static void UpdateEmployee(Employee emp)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=EmployeesDB_ADO;Integrated Security=True";
            cn.Open();
            SqlCommand cmd = cn.CreateCommand();
            cmd.CommandType = System.Data.CommandType.Text;
            cmd.CommandText = "UPDATE Employees SET Name = @Name, City=@City,Address=@Address WHERE EmpID = @EmpID";
            cmd.Parameters.AddWithValue("@EmpID",emp.EmpID);
            cmd.Parameters.AddWithValue("@Name", emp.Name);
            cmd.Parameters.AddWithValue("@City", emp.City);
            cmd.Parameters.AddWithValue("@Address", emp.Address);
            cmd.ExecuteNonQuery (); 
            cn.Close(); 
        }
    }
}
