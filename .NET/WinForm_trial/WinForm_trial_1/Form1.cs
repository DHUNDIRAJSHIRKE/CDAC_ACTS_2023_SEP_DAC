using System.Data;
using Microsoft.Data.SqlClient;
namespace WinForm_trial_1
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
            //MessageBox.Show("Button Works!!");
            ds = new DataSet();
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True;";
                try
                {
                    cn.Open();
                    Console.WriteLine("success");
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = CommandType.Text;
                    cmd.CommandText = "select * from Employees";

                    SqlDataAdapter da = new SqlDataAdapter();
                    da.SelectCommand = cmd;

                    da.Fill(ds, "emps");
                    cmd.CommandText = "select * from Departments";
                    da.Fill(ds, "Depts");

                    dataGridView1.DataSource = ds.Tables["emps"];




                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }

            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Don't look at this
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023_lab_Batch_1;Integrated Security=True;";
                try
                {
                    cn.Open();
                    Console.WriteLine("success");
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = CommandType.Text;
                    cmd.CommandText = "insert into Employees values(@EmpNo,@EmpName,@Basic,@DeptNo)";
                    cmd.Parameters.Add(new SqlParameter { ParameterName = "@EmpNo", SourceColumn = "EmpNo", SourceVersion = DataRowVersion.Original });
                    cmd.Parameters.Add(new SqlParameter { ParameterName = "@EmpName", SourceColumn = "Name", SourceVersion = DataRowVersion.Current });
                    cmd.Parameters.Add(new SqlParameter { ParameterName = "@Basic", SourceColumn = "Basic", SourceVersion = DataRowVersion.Current });
                    cmd.Parameters.Add(new SqlParameter { ParameterName = "@Deptno", SourceColumn = "Deptno", SourceVersion = DataRowVersion.Current });


                    SqlDataAdapter da = new SqlDataAdapter();

                    da.InsertCommand = cmd;
                    da.Update(ds, "emps");

                    MessageBox.Show("Dhundiraj Updated Successfully");
                    /*
                     * 
                     * 
                                        [EmpNo] INT NOT NULL,
                        [Name] VARCHAR(50)    NOT NULL,
                        [Basic]  DECIMAL(18, 2) NOT NULL,
                        [DeptNo] INT NOT NULL,*/



                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            ds.WriteXmlSchema("EmpData.xsd");
            ds.WriteXml("EmpsData.xml", XmlWriteMode.DiffGram);
        }

        private void button4_Click(object sender, EventArgs e)
        {

        }
    }
}