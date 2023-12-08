namespace Day3Assignment_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter No Of Batches : ");
            int batches = Convert.ToInt32(Console.ReadLine());
            Student[][] students = new Student[batches][];
            int temp = 0;

            for( int i = 0;i < students.Length; i++ )
            {
                Console.WriteLine("Enter No of Students in Batch"+ (i + 1));
                temp = Convert.ToInt32(Console.ReadLine());
                students[i]=new Student[temp] ;
                for(int j = 0;j < students[i].Length; j++)
                {
                    Console.WriteLine($"ENter Marks of Batch{i+1} Student{j+1} : ");
                    temp = Convert.ToInt32(Console.ReadLine());
                    Student NewStudent = new Student(temp);
                    students[i][j] = NewStudent;
                        
                }
                
            }
            for(int i = 0; i < students.Length; i++ ) 
            {
                Console.WriteLine($"Batch {(i + 1)}'s ");
                for(int j = 0;j < students[i].Length; j++)
                {
                    Console.WriteLine($"             Student {(j+1)}'s marks are :{students[i][j].marks} .");
                }
                Console.WriteLine();
            }
        }
        public class Student
        {
            public int marks ;
            public Student(int marks)
            {
                this.marks = marks;
            }
        }

    }
}