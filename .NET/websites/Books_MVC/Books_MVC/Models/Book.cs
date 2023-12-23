using Microsoft.Data.SqlClient;
using System.Data;

namespace Books_MVC.Models
{
    public class Book
    {
        public int Id { get; set; }
        public string BookName { get; set; }
        public decimal BookPrice { get; set; }
        public string BookAuthor { get; set; }

        public static List<Book> getAllBooks()
        {
            var books = new List<Book>();
            using (SqlConnection cn = new SqlConnection())
            {
                try
                {


                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Books_MVC;Integrated Security=True";
                    cn.Open();
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = System.Data.CommandType.Text;
                    cmd.CommandText = "SELECT * FROM tbl_books";
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        Book book = new Book();
                        book.BookName = dr.GetString("BookName");
                        book.Id = dr.GetInt32("Id");
                        book.BookAuthor = dr.GetString("BookAuthor");
                        book.BookPrice = dr.GetDecimal("BookPrice");
                        books.Add(book);
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    throw ex;
                }


            }


            return books;
        }

        public static Book getBook(int id)
        {
            Book book = new Book();
            using (SqlConnection cn = new SqlConnection())
            {
                try
                {
                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Books_MVC;Integrated Security=True";
                    cn.Open();
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = System.Data.CommandType.Text;
                    cmd.CommandText = "SELECT * FROM tbl_books WHERE Id = @Id";
                    cmd.Parameters.AddWithValue("@Id", id);
                    SqlDataReader dr = cmd.ExecuteReader();
                    if (dr.Read())
                    {
                        book.BookName = dr.GetString("BookName");
                        book.BookPrice = dr.GetDecimal("BookPrice");
                        book.BookAuthor = dr.GetString("BookAuthor");
                        book.Id = dr.GetInt32("Id");
                    }

                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                    throw ex;
                }
            }

            return book;
        }

        public static void InsertBook(Book book)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                try
                {
                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Books_MVC;Integrated Security=True";
                    cn.Open();
                    SqlCommand cmd = cn.CreateCommand();
                    cmd.CommandType = System.Data.CommandType.Text;
                    cmd.CommandText = "INSERT INTO tbl_books VALUES(@BookName,@BookAuthor,@BookPrice)";
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

        public static void DeleteBook(int id)
        {
            using (SqlConnection cn = new SqlConnection())
            {
                try
                {
                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Books_MVC;Integrated Security=True";
                    cn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.Connection = cn;
                    cmd.CommandType = System.Data.CommandType.Text;
                    cmd.CommandText = "DELETE FROM tbl_books WHERE Id = @Id";
                    cmd.Parameters.AddWithValue("Id", id);
                    cmd.ExecuteNonQuery();

                }
                catch(Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
                
            
            
        }

        public static void UpdateBook(Book book)
        {
            using(SqlConnection cn = new SqlConnection())
            {
                try
                {

                    cn.ConnectionString = "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=Books_MVC;Integrated Security=True";
                    cn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.Connection = cn;
                    //cmd.CommandType = CommandType.Text;

                    //cmd.CommandText = "UPDATE tbl_books SET BookPrice= @BookPrice, BookName = @BookName, BookAuthor = @BookAuthor WHERE Id = @Id";

                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.CommandText = "UpdateBook";
                    cmd.Parameters.AddWithValue("@Id", book.Id);
                    cmd.Parameters.AddWithValue("@BookPrice", book.BookPrice);
                    cmd.Parameters.AddWithValue("@BookName", book.BookName);
                    cmd.Parameters.AddWithValue("@BookAuthor", book.BookAuthor);
                    cmd.ExecuteNonQuery();
                }
                catch(Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
            
            
        }
    }
}
