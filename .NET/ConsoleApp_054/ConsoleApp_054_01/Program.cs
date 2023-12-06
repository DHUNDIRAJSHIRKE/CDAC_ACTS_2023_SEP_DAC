namespace N1 
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!!");
            N2.Program.F1();
        }
    }
    namespace N2
    {
        class Program
        {
            public static void F1()
            {
                Console.WriteLine("Hello from namespace N2's Program class!!");
            }
        }
    }
}
