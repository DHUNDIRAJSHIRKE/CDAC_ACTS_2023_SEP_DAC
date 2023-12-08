namespace StaticMembers
{
    internal class Program
    {
        static void Main(string[] args)
        {
           Class1 O= new Class1();
            O.i = 100;
            O.display();
            Class1.s_i = 200;
            Class1.s_display();
            O.Prop1 = 300;
            Console.WriteLine("prop1="+O.Prop1);
            Class1.Prop2 = 400;
            Console.WriteLine(Class1.Prop2);

        }
    }
    public class Class1
    {
        public  int i;
        public static int s_i;
        public void display()
        {
            Console.WriteLine("in dislay");
            Console.WriteLine(i);
            Console.WriteLine(s_i);
        }
        public static void s_display()
        {  Console.WriteLine("in static display");
            //Console.WriteLine(i);
            //u cant access mom static data members within static methods
            Console.WriteLine(s_i);
        }
        private int prop1;
        public int Prop1
        {
            set
            {
                if(value>=10) 
                {
                prop1 = value;
                }
            }
            get
            {
                return prop1;
            }
        }
        private static int prop2;
        public static int Prop2
        {
            set
            {
                if (value>100)
                    prop2 = value;
            }
            get 
            {
                return prop2;
            }
        }
        public Class1()
        {
            Console.WriteLine("in  constr");
            i = 600;
        }

        static Class1()
        {
            Console.WriteLine("in static constr");
            s_i = 500;
        }


    }
}