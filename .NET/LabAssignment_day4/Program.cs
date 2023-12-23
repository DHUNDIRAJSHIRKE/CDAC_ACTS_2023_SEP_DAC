namespace LabAssignment_day4
{
    internal class Program
    {
        //Take length of array input from user, take each element from user, then display array,convert the array to list, then display the list        
        static void Main1(string[] args)

        {
            Console.WriteLine("Enter size of Array: ");
            int l = Convert.ToInt32(Console.ReadLine());
            int[] arr = new int[l];
            for (int i = 0; i < l; i++)
            {
                Console.WriteLine($"Enter element {(i + 1)}/{l}");
                arr[i] = Convert.ToInt32(Console.ReadLine());
            }
            Console.WriteLine("The Entered Array: ");
            foreach (int i in arr)
            {
                Console.Write(i + " ");
            }
            List<int> list = new List<int>(l);
            foreach (int i in arr)
            {
                list.Add(i);
            }
            Console.WriteLine();
            Console.WriteLine("List converted from Array :");
            foreach (int i in list)
            {
                Console.Write(i + " ");
            }
        }
        //Take length of list input from user, take each element from user, then display list,convert the list to array, then display the array
        static void Main()

        {
            Console.WriteLine("Enter size of Array: ");
            int l = Convert.ToInt32(Console.ReadLine());
            List<int> list = new List<int>(l);
            for (int i = 0; i < l; i++)
            {
                Console.Write($"Enter element {(i + 1)}/{l} into list  ");
                list.Add(Convert.ToInt32(Console.ReadLine()));
            }
            Console.WriteLine("Same elements from list: ");
            foreach (int i in list)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();
            Console.WriteLine("Same elements from array: ");
            int[] arr = list.ToArray();
            foreach (int i in arr)
            {
                Console.Write(i + " ");
            }
        }
    }
}