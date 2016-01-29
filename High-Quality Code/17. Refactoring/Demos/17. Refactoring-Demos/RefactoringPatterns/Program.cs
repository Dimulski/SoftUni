namespace RefactoringPatterns
{
    using System;

    class Program
    {
        static void Main(string[] args)
        {
            // 1
            var daysOfWeek = new[] 
            { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

            // 2
            FindPointInCircle();

            // 3
            IsPrime(11);

            // 4
            string type = Console.ReadLine();
            Student student = null;
            if (type == "Online")
            {
                student = new Student(StudentType.Online);
            }
            else
            {
                student = new Student(StudentType.Onsite);
            }
        }

        private static bool IsPrime(int num)
        {
            bool isPrime = true;
            for (int i = 0; i < Math.Sqrt(num); i++)
            {
                if (num % i == 0)
                {
                    isPrime = true;
                    break;
                }
            }

            if (isPrime)
                return true;
            else
                return false;
        }

        private static void FindPointInCircle()
        {
            float rectX = 0, rectY = 0, rectWidth = 0, rectHeight = 0;
            float circleX = 0, circleY = 0, radius = 0;
            float pointX = 0, pointY = 0;

            if (pointX >= rectX && pointX <= rectX + rectWidth &&
                pointY <= rectY && pointY >= rectY + rectHeight &&
                Math.Abs((circleX - pointX) * (circleX - pointX)
                         + (circleY - pointY) * (circleY - pointY)) <= radius)
            {
                Console.WriteLine("Point is inside circle and rectangle.");
            }
        }
    }
}
