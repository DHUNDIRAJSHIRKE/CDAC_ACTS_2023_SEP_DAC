namespace ConstrNInit2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class2 o1= new Class2();
            o1.i = 1;
            o1.j = 2;
            o1.k = 3;
            Console.WriteLine(o1.i);
            Console.WriteLine(o1.j);
            Console.WriteLine(o1.k);
            Console.WriteLine("Hello, constr");
            Class2 o2 = new Class2 { i = 1, j=10,k=5 };
            Console.WriteLine(o2.i);
            Console.WriteLine(o2.j);
            Console.WriteLine(o2.k);
           // Class2 o3 = new Class2(10, 20, 30);
           // no defined contr in clss so we cant use so
           
        }
    }
    public class Class2
    {
        public int i, j, k;
    }
}