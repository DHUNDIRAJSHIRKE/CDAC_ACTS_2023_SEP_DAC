using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace Day_9_Lab_Assignment_persist_Object
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            ser();
            deser();
        }
        public static void ser()
        {
            Employee employee = new Employee();
            employee.Name = "Nitin";
            employee.Salary = 10500;
            employee.Id = 1;
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj1.txt",FileMode.Create);
#pragma warning disable SYSLIB0011 // Type or member is obsolete
            bf.Serialize(s, employee);
#pragma warning restore SYSLIB0011

            s.Close();

        }
        public static void deser()
        {
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj1.txt", FileMode.Open);
#pragma warning disable SYSLIB0011
            Employee e2 = (Employee)bf.Deserialize(s);
#pragma warning restore SYSLIB0011
            Console.WriteLine(e2.Name);
            Console.WriteLine(e2.Salary);
            Console.WriteLine(e2.Id);
            s.Close();
        }
    }

    [Serializable]
    public class Employee :ISerializable
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public double Salary { get; set; }

        public void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            info.AddValue("id", Id);
            info.AddValue("sal", Salary);
            info.AddValue("name", Name);
        }
        public Employee()
        {

        }
        public Employee(SerializationInfo info, StreamingContext context) 
        {
            Id = info.GetInt32("id");
            Name = info.GetString("name");
            Salary = info.GetDouble("sal");
        }
    }

}