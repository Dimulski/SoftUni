namespace Part2EightQueensPuzzle
{
    using System;

    public class PermutationBasedSolution
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            Enumerate(n);
        }

        private static bool IsConsistent(int[] board, int n)
        {
            for (int i = 0; i < n; i++)
            {
                if (board[i] == board[n]) // same column
                {
                    return false;
                }
                if (board[i] - board[n] == n - i) // same major diagonal
                {
                    return false;
                }
                if (board[n] - board[i] == n - i) // same minor diagonal
                {
                    return false;
                }
            }
            return true;
        }

        private static void PrintQueens(int[] board)
        {
            int n = board.Length;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
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

        private static void Enumerate(int n)
        {
            int[] a = new int[n];
            Enumerate(a, 0);
        }

        private static void Enumerate(int[] board, int n)
        {
            int j = board.Length;
            if (n == j)
            {
                PrintQueens(board);
            }
            else
            {
                for (int i = 0; i < j; i++)
                {
                    board[n] = i;
                    if (IsConsistent(board, n))
                    {
                        Enumerate(board, n + 1);
                    }
                }
            }
        }
    }
}
