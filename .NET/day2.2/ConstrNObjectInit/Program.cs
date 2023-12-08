namespace ConstrNObjectInit
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Class1 o=new Class1();
            Console.WriteLine(o);
            Console.WriteLine(o.ToString());
            Console.WriteLine(o.i);
            Console.WriteLine("over");
        }
    }
    public class Class1
    {
         public int i;
        public Class1(int i=10) 
        {
            Console.WriteLine("constr called");
            this.i = i;
        }
    }
        

}