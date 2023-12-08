using TestAccessSpecifiers.lab2;

namespace TestAccessSpecifiers
{
    public class BaseClass
    {
        static void Main()
        {
            Class1 o = new Class1();
            o.Prop1 = 100;
            Console.WriteLine(o.Prop1);
            Console.WriteLine(o.Prop2);
            o.Prop2 = 11;
            Console.WriteLine(o.Prop2);
            Console.WriteLine(o.Prop3);
            o.Prop3 = 12;
            Console.WriteLine(o.Prop3);
            o.Prop4 = "yug";
        }
    }
    namespace lab2
    {
        public class Class1
        {
            private int prop1;
            public int Prop1  //no need to define value nd other fields it would recognise auto
            {
                set
                {
                    prop1 = value;
                }
                get
                {
                    return prop1;
                }
            }
            private int prop2;
            public int Prop2    //validation given
            {
                set
                {
                    if (value > 10)
                        prop2 = value;
                }
                get
                {
                    return prop2;
                }
            }

            public int Prop3 { set; get; } //auto generated property-->when no validation required
            public string Prop4;

        }
    }
}