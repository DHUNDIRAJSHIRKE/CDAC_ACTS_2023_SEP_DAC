﻿namespace Arrays
{
    internal class Program
    {
        static void Main1()
        {
            int[] arr = new int[5];
            //0...4
            //arr[0] ... arr[4]
            for (int i = 0; i < arr.Length; i++)
            {
                //Console.Write("Enter value for arr[" + i + "]");  //string concatenation
                //Console.Write("Enter value for arr[{0} ]", i);  //placeholder
                Console.Write($"Enter value for arr[{i}]");  //string interpolation
                //arr[i] = int.Parse(Console.ReadLine());
                arr[i] = Convert.ToInt32(Console.ReadLine());
            }
            Console.WriteLine();
            for (int i = 0;i < arr.Length;i++)
            {
                Console.WriteLine($"The value of arr[{i}] is {arr[i]}");
            }

            //foreach (int item in arr)
            //{
            //    Console.WriteLine(item);
            //}
        }

















        static void Main2()
        {
            int[] arr = new int[5] {20,40,10,30,50};
            int[] arr2 = { 1, 2, 3, 4, 5, 6 , 7, 8};


            int pos = Array.IndexOf(arr, 80);
            Console.WriteLine(pos);
            //if(pos == -1) //not found
            pos = Array.LastIndexOf(arr, 80);
            Console.WriteLine(pos);
            Array.Sort(arr);    
            pos = Array.BinarySearch(arr, 20);
            Console.WriteLine(pos);
            //if(pos < 0) //not found

            //Array.Clear(arr)
            //Array.Copy(arr, arr2, arr.Length);
            Array.ConstrainedCopy(arr, 0, arr2, 0, arr.Length);
            //Array.Reverse(arr);
            //Array.Sort(arr);

            for (int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine($"The value of arr[{i}] is {arr[i]}");
            }

            
        }
























        static void Main4()
        {
            int[,] arr = new int[3, 5];
            //arr[0,0] arr[0,1] arr [0,2] arr[0,3] arr[0,4]
            //arr[1,0] arr[1,1] arr [1,2] arr[1,3] arr[1,4]
            //arr[2,0] arr[2,1] arr [2,2] arr[2,3] arr[2,4]



            Console.WriteLine(arr.Length);
            Console.WriteLine(arr.Rank);  //no of dimensions
            Console.WriteLine(arr.GetLength(0));  //length of 1st dimension
            Console.WriteLine(arr.GetLength(1));  //length of 2nd dimension
            Console.WriteLine(arr.GetUpperBound(0));  //upper bound of 1st dimension
            Console.WriteLine(arr.GetUpperBound(1));
            Console.WriteLine(arr.GetLowerBound(0));  //upper bound of 1st dimension
            Console.WriteLine(arr.GetLowerBound(1));
            Console.WriteLine();
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.Write($"Enter value for arr[{i},{j}]");  //string interpolation
                    arr[i,j] = Convert.ToInt32(Console.ReadLine());
                }
            }
            Console.WriteLine();
            for (int i = 0; i < arr.GetLength(0); i++)
            {
                for (int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.WriteLine($"The value of arr[{i},{j}] is {arr[i,j]}");
                }
            }
        }


















        static void Main5()
        {
            //jagged
            int[][] arr = new int[4][];

            //for (int i = 0; i < arr.Length; i++)
            //{
            //    arr[i] = new int[x]
            //}

            arr[0] = new int[3]; // arr[0][0] arr[0][1] arr[0][2]
            arr[1] = new int[4]; // arr[1][0] arr[1][1] arr[1][2] arr[1][3]
            arr[2] = new int[2];//  arr[2][0] - arr [2][1]
            arr[3] = new int[3];//  arr[3][0] arr[3][1] arr[3][2]

            /*for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr[i].Length; j++)
                {
                    Console.Write("enter value for subscript [{0}][{1}] : ", i, j);
                    arr[i][j] = Convert.ToInt32(Console.ReadLine());
                }
                Console.WriteLine();
                Console.WriteLine();
            }*/

         
            Console.WriteLine();
            Console.WriteLine();
            for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr[i].Length; j++)
                {
                    Console.WriteLine("value for subscript {0},{1} is {2}  ", i, j, arr[i][j]);

                }
                Console.WriteLine() ;
            }
            Console.ReadLine();
        }


















        static void Main()
        {
            Employee[] arrEmps = new Employee[5];

            //arrEmps[0] = new Employee();
            //arrEmps[1] = new Employee();
            //arrEmps[2] = new Employee();
            //arrEmps[3] = new Employee();
            //arrEmps[4] = new Employee();

            for (int i = 0; i < arrEmps.Length; i++)
            {
                arrEmps[i] = new Employee();
                //arrEmps[i].Name
                //arrEmps[i].EmpNo
            }
            foreach (Employee item in arrEmps)
            {
                //item = new Employee();  //will not work -- item is readonly
                //item.EmpNo = 10;  //will work
                Console.WriteLine(item.ToString());
            }

        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public override string ToString()
        {
            return $"EmpNo : {EmpNo} Name : {Name}";
        }

    }
}