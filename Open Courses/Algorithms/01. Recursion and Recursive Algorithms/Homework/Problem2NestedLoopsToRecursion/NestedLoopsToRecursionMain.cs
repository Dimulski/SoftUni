using System;

namespace Problem2NestedLoopsToRecursion
{
    class NestedLoopsToRecursionMain
    {
        static int[] numbers;

        static void Main()
        {
            Setup();
            SimulateNestedLoops(0, numbers.Length);
        }

        private static void SimulateNestedLoops(int currentNumber, int arrayLength)
        {
            if (currentNumber >= arrayLength)
            {
                Print();
                return;
            }
            else
            {
                for (int i = 0; i < arrayLength; i++)
                {
                    numbers[currentNumber] = i + 1;
                    SimulateNestedLoops(currentNumber + 1, arrayLength);
                }
            }
        }

        private static void Print()
        {
            Console.WriteLine(string.Join(" ", numbers));
        }

        private static void Setup()
        {
            int n = int.Parse(Console.ReadLine());
            numbers = new int[n];
        }
    }
}
