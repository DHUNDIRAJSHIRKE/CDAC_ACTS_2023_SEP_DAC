using Microsoft.Data.SqlClient;
using System.Data;

namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
        DataSet ds;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\ProjectModels;Initial Catalog=ActsDec2023_2;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT * FROM Employees";
                ds = new DataSet();
                SqlDataAdapter da = new SqlDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(ds, "Emps");
                dataGridView1.DataSource = ds.Tables["Emps"];
            }
            catch (Exception rgr)
            {
                MessageBox.Show(rgr.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\ProjectModels;Initial Catalog=ActsDec2023_2;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "update Employees set Name=@Name,Basic=@Basic,DeptNo=@DeptNo where Empno=@EmpNo";

                cmd.Parameters.Add(new SqlParameter { ParameterName = "@Name", SourceColumn =})
            }
        }
    }
}