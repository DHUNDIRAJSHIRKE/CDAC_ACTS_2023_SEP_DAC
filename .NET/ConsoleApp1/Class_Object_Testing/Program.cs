using classes;

namespace Class_Object_Testing
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Let's test Class creation and Object creation Testing");
            Student s1 = new Student();
            Student s2 = new Student(2,"Ajinkya");
            s1.setName( "Dhundiraj");
            s1.setId(1);
            Console.WriteLine(s2.ToString());
            Console.WriteLine(s1.ToString());
            Teacher T1 = new Teacher();
            Teacher T2 = new Teacher(2, "Madhura");
            Teacher T3 = new Teacher(3, "Vikram");
            T1.setTeacherID(1);
            T1.setName("Kishori");
            Console.WriteLine(T1.ToString());
            Console.WriteLine(T2.ToString());
            Console.WriteLine(T3.ToString());
        }
    }
}
namespace classes
{
    public class Student
    {
        private int Id { get; set; }
        private string Name { get; set; }
        public Student() 
        {
            Name = "NA";
        }
        public int getId()
        {
            return this.Id;

        }
        public void setId(int Id)
        {
            this.Id = Id;
        }
        public string getName()
        {
            return this.Name;

        }
        public void setName(string Name)
        {
            this.Name = Name;
        }
        public Student(int id, string name)
        {
            Id = id;
            Name = name;
        }
        public override string ToString()
        {
            return " Student [ ID : "+Id+" Name : "+Name+"]";
        }
    }
    public class Teacher
    {
        private int TeacherID { get; set; }
        private string Name { get; set; }
        public Teacher() {
            Name = "NA";
        }
        public override string ToString()
        {
            return "Teacher [ID : " + TeacherID + " Name : " + Name + "]";
        }
        public Teacher(int teacherID, string name)
        {
            TeacherID = teacherID;
            Name = name;
        }
        public void setTeacherID(int TeacherID)
        {
            this.TeacherID = TeacherID;
        }
        public void setName(string Name)
        {
            this.Name = Name;
        }
        public int getTeacherID()
        {
            return this.TeacherID;
        }
        public string getName()
        {
            return this.Name;
        }
    }
}
