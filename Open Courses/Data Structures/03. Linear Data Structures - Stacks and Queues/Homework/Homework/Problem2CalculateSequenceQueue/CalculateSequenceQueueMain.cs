namespace Problem2CalculateSequenceQueue
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;

    class CalculateSequenceQueueMain
    {
        static void Main()
        {
            Queue<int> numbers = new Queue<int>();

            var n = int.Parse(Console.ReadLine());

            numbers.Enqueue(n);

            StringBuilder stringBuilder = new StringBuilder();
            var counter = 1;
            
            while (counter <= 50)
            {
                var targetElement = numbers.First();
                numbers.Enqueue(targetElement + 1);
                numbers.Enqueue((targetElement * 2) + 1);
                numbers.Enqueue(targetElement + 2);

                stringBuilder.Append(numbers.Dequeue() + " ");
                counter++;
            }

            Console.WriteLine(string.Join(", ", stringBuilder.ToString().Trim().Split().ToArray()));
        }
    }
}
