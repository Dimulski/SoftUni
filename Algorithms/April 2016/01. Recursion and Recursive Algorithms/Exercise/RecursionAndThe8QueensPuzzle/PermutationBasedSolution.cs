using System;

namespace RecursionAndThe8QueensPuzzle
{
    public class PermutationBasedSolution
    {
        private static bool isConsistent(int[] board, int n)
        {
            for (int i = 0; i < n; i++)
            {
                if (board[i] == board[n]) // same column
                {
                    return false;
                }
                if ((board[i]) - board[n] == (n - i)) // same major diagonal
                {
                    return false;
                }
                if ((board[n]) - board[i] == (n - i)) // same minor diagonal
                {
                    return false;
                }
            }
            return true;
        }

        private static void PrintQueens(int[] board)
        {
            int N = board.Length;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (board[i] == j)
                    {
                        Console.Write("Q ");
                    }
                    else
                    {
                        Console.Write("* ");
                    }
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }

        public static void enumerate(int N)
        {
            int[] a = new int[N];
            enumerate(a, 0);
        }

        public static void enumerate(int[] board, int n)
        {
            int N = board.Length;
            if (n == N)
            {
                PrintQueens(board);
            }
            else
            {
                for (int i = 0; i < N; i++)
                {
                    board[n] = i;
                    if (isConsistent(board, n))
                    {
                        enumerate(board, n + 1);
                    }
                }
            }
        }
        
        public static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            enumerate(N);
        }
    }
}
