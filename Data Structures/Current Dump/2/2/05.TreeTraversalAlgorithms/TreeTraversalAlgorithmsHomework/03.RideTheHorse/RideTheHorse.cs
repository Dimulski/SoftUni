namespace _03.RideTheHorse
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class RideTheHorse
    {
        public static void Main()
        {
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());
            int startRow = int.Parse(Console.ReadLine());
            int startCol = int.Parse(Console.ReadLine());
            int[,] matrix = new int[rows, cols];
            var queue = new Queue<string>();
            queue.Enqueue(startRow + "|" + startCol + "|1");
            TraverseMatrixWithHorse(queue, matrix);
            Console.WriteLine("Result:");
            PrintMiddleCol(matrix);
        }

        private static void TraverseMatrixWithHorse(Queue<string> queue, int[,] matrix)
        {
            while (queue.Count > 0)
            {
                var args = queue.Dequeue()
                .Split('|')
                .Select(int.Parse)
                .ToArray();
                int currRow = args[0];
                int currCol = args[1];
                int steps = args[2];

                bool isCurrRowInRange = currRow >= 0 && currRow < matrix.GetLength(0);
                bool isCurrColInRange = currCol >= 0 && currCol < matrix.GetLength(1);
                if (isCurrRowInRange && isCurrColInRange && matrix[currRow, currCol] == 0)
                {
                    matrix[currRow, currCol] = steps;

                    queue.Enqueue((currRow + 2) + "|" + (currCol - 1) + "|" + (steps + 1));
                    queue.Enqueue((currRow + 1) + "|" + (currCol - 2) + "|" + (steps + 1));
                    queue.Enqueue((currRow - 1) + "|" + (currCol - 2) + "|" + (steps + 1));
                    queue.Enqueue((currRow - 2) + "|" + (currCol - 1) + "|" + (steps + 1));
                    queue.Enqueue((currRow - 2) + "|" + (currCol + 1) + "|" + (steps + 1));
                    queue.Enqueue((currRow - 1) + "|" + (currCol + 2) + "|" + (steps + 1));
                    queue.Enqueue((currRow + 1) + "|" + (currCol + 2) + "|" + (steps + 1));
                    queue.Enqueue((currRow + 2) + "|" + (currCol + 1) + "|" + (steps + 1));
                }
            }
        }

        private static void PrintMiddleCol(int[,] matrix)
        {
            int middleCol = matrix.GetLength(1) / 2;
            for (int currRow = 0; currRow < matrix.GetLength(0); currRow++)
            {
                Console.WriteLine(matrix[currRow, middleCol]);
            }
        }
    }
}
