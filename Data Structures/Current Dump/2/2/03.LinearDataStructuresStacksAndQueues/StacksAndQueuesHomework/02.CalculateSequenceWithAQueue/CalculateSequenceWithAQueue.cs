namespace _02.CalculateSequenceWithAQueue
{
    using System;
    using System.Collections.Generic;

    public class CalculateSequenceWithAQueue
    {
        public static void Main()
        {
            int firstNumber = int.Parse(Console.ReadLine());
            var sequenceOfNumbers = new Queue<int>();
            int[] first50Elements = new int[50];
            sequenceOfNumbers.Enqueue(firstNumber);

            for (int i = 0; i < 50; i++)
            {
                var currElement = sequenceOfNumbers.Dequeue();
                sequenceOfNumbers.Enqueue(currElement + 1);
                sequenceOfNumbers.Enqueue(currElement * 2 + 1);
                sequenceOfNumbers.Enqueue(currElement + 2);

                first50Elements[i] = currElement;
            }

            Console.WriteLine(string.Join(", ", first50Elements));
        }
    }
}
