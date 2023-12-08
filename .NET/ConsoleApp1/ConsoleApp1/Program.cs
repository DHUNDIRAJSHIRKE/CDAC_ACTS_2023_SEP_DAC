namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            N1.c1.F2(10);
            N2.c1.F2(55);
            N2.c1.F2(55);




            Console.WriteLine("Method OverLoading with no args passed : " + N3.arithmetic1.add());
            Console.WriteLine("Method OverLoading with single(25) arg passed : " + N3.arithmetic1.add(25));
            Console.WriteLine("Method OverLoading with 2 args(34,90) passed : " + N3.arithmetic1.add(34, 90));
            Console.WriteLine("Method OverLoading with 3 args(1,2,3) passed : " + N3.arithmetic1.add(1, 2, 3));
        }
    }



    namespace N1
    {
        class c1
        {
            public static void F2(int x)
            {
                Console.WriteLine("the pass number is:" + x);
            }

        }
    }

    namespace N2
    {
        class c1
        {
            public static void F2(int y)
            {
                Console.WriteLine("function call to the F2 function from class C2 from namespace N2. The passed Argument is : " + y);
            }
        }
    }
    namespace N3
    {
    }


}

