// Write two programs that fill and print a matrix of size N x N. Filling a matrix in the regular pattern (top to bottom and
// left to right) is boring. Fill the matrix as described in both patterns below: ...

using System;

namespace P1_Fill_the_Matrix
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int[,] matrix = new int[n, n];
            int number = 1;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++, number++)
                {
                    matrix[j, i] = number;
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.Write("{0} ", matrix[i, j]);
                }
                Console.WriteLine();
            }

            Console.WriteLine();
            Array.Clear(matrix, 0, matrix.Length);
            number = 1;

            for (int i = 0; i < n; i++)
            {
                if (i % 2 == 0)
                {
                    for (int j = 0; j < n; j++, number++)
                    {
                        matrix[j, i] = number;
                    }
                }
                else
                {
                    for (int j = n - 1; j >= 0; j--, number++)
                    {
                        matrix[j, i] = number;
                    }
                }
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.Write("{0} ", matrix[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}
