using System;

namespace Day_8_Lab_Assignment
{
    internal class Program
    {
        
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Thread even = new Thread(new ParameterizedThreadStart(EvenPrinter) );
            Thread odd = new Thread(new ParameterizedThreadStart(OddPrinter));
            int[] i = { 0};
            even.Start(i);
            odd.Start(i);

        }
        static void EvenPrinter(Object obj)
        {
            int[] i = (int[]) obj;
            for (int j = 0; j < 50; j++)
            {
                Console.WriteLine("Even " + (++i[0]));
            }
        }
        static void OddPrinter(Object obj)
        {
            int[] i = (int[])obj;
            for (int j = 0; j < 50; j++)
            {
                Console.WriteLine("Odd " + (++i[0]));
            }

        }
    }
}