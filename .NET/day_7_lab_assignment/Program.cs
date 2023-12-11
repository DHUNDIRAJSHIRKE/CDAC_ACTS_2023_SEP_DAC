namespace day_7_lab_assignment
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a String: ");
            string? str = Console.ReadLine();
            Console.WriteLine(str.CountVowel());

        }
        
    }
    public static class StringExt {
        public static int CountVowel(this string ob)
        {
            int count = 0;
            char[] chars = ob.ToCharArray();
            foreach (var item in chars)
            {
                if (item == 'a' || item == 'e' || item == 'i' || item == 'o' || item == 'u' || item == 'A' || item == 'E' || item == 'I' || item == 'O' || item == 'U')
                {
                    count++;
                }
            }
            return count;
        }
    }
}