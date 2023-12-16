using System.Runtime.Serialization;
using System.Runtime.Serialization.DataContracts;
using System.Runtime.Serialization.Json;
using System.Xml.Serialization;

namespace Json_Ser_deser
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
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Employee));
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj3.json", FileMode.Create);
            js.WriteObject(s, employee);
            s.Close();
        }
        public static void deser()
        {
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Employee));
            Stream s = new FileStream("D:\\CDAC_ACTS_2023_SEP_DAC\\.NET\\Day_9_Lab\\proj3.json", FileMode.Open);
            Employee e2 = (Employee)js.ReadObject(s);
            s.Close();
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