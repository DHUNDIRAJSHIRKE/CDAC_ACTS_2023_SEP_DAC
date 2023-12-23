using Microsoft.Data.SqlClient;

namespace Book_ADO_2.Models
{
    public class Book
    {
        public int BookID { get; set; }
        public string BookName { get; set; }
        public decimal BookPrice { get; set; }
        public string BookAuthor { get; set; }



        public static void InsertBook(Book book)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                try
                {
                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Book_API;Integrated Security=True;";
                    cn.Open();
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.CommandText = "InsertBook";
                    cmd.Parameters.AddWithValue("@BookName", book.BookName);
                    cmd.Parameters.AddWithValue("@BookPrice", book.BookPrice);
                    cmd.Parameters.AddWithValue("@BookAuthor", book.BookAuthor);
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }




    

        
    }
}
