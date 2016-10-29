// Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has maximal sum of its elements. 
// On the first line, you will receive the rows N and columns M. On the next N lines you will receive each row with its columns.
// Print the elements of the 3 x 3 square as a matrix, along with their sum.

using System;
using System.Linq;

namespace P2_Maximal_Sum
{
    class Program
    {
        static void Main()
        {
            int[] dimentions = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int rows = dimentions[0];
            int cols = dimentions[1];

            int[,] matrix = new int[rows, cols];
            for (int i = 0; i < rows; i++)
            {
                int[] row = Console.ReadLine().Trim().Split().Select(p => int.Parse(p)).ToArray();
                for (int j = 0; j < cols; j++)
                {
                    matrix[i, j] = row[j];
                }
            }
            int maxSum = int.MinValue, maxSumRow = 0, maxSumCol = 0;
            for (int row = 0; row < rows - 2; row++)
            {
                for (int col = 0; col < cols - 2; col++)
                {
                    int currentSum = 0;
                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            currentSum += matrix[row + i, col + j];
                        }
                    }
                    if (currentSum > maxSum)
                    {
                        maxSum = currentSum;
                        maxSumRow = row;
                        maxSumCol = col;
                    }
                }
            }
            Console.WriteLine("Sum: {0}", maxSum);
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Console.Write("{0}\t", matrix[maxSumRow + i, maxSumCol + j]);
                }
                Console.WriteLine();
            }
        }
    }
}
