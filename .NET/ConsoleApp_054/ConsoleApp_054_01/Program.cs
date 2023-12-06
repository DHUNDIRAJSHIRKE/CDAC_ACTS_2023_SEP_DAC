namespace N1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("Hello World!!");
            N2.Program.F1();
            int num = 0;
            System.Console.WriteLine();
        }
    }
    namespace N2
    {
        class Program
        {
            public static void F1()
            {
                System.Console.WriteLine("Hello from namespace N2's Program class!!");
            }
        }
    }
}
