using System.Xml.Serialization;
using System.Runtime.Serialization.Formatters.Soap;
using System.Runtime.Serialization;
namespace XML_Serialization
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
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj2.txt", FileMode.Create);
            sf.Serialize(s, employee);
            s.Close();
        }
        public static void deser()
        {
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj2.txt", FileMode.Open);
            Employee e2 = (Employee)sf.Deserialize(s);
            s.Close ();
            Console.WriteLine(e2.Name);
            Console.WriteLine(e2.Id);
            Console.WriteLine(e2.Salary);
        }
    }



    [Serializable]
    public class Employee : ISerializable
    {
        public int Id { get; set; }
        [XmlAttribute]
        public string Name { get; set; }
        [XmlAttribute]
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