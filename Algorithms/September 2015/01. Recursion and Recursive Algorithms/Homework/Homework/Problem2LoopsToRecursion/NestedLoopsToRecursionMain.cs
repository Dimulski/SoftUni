using System;

namespace Problem2LoopsToRecursion
{
    class NestedLoopsToRecursionMain
    {
        private static int[] numbers;

        static void Main()
        {
            Setup();
            SimulateNestedLoop(0,numbers.Length);
        }

        private static void SimulateNestedLoop(int currentNumber, int arrayLength)
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
                    SimulateNestedLoop(currentNumber + 1, arrayLength);
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
