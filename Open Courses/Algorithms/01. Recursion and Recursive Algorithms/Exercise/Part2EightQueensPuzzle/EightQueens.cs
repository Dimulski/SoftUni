namespace Part2EightQueensPuzzle
{
    using System;

    public class EightQueens
    {
        public const int Size = 8;

        public static readonly bool[,] Chessboard = new bool[Size, Size];

        public static int SolutionsFound = 0;

        private const int NumberOfDiagonals = 15;

        private static readonly int[] ReversedCol = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };

        private static readonly bool[] AttackedColumns = new bool[Size];

        private static readonly bool[] AttackedLeftDiagonals = new bool[NumberOfDiagonals];

        private static readonly bool[] AttackedRightDiagonals = new bool[NumberOfDiagonals];

        public static void PutQueens(int row)
        {
            if (row == Size)
            {
                PrintSolution();
            }
            else
            {
                for (int col = 0; col < Size; col++)
                {
                    if (CanPlaceQueen(row, col))
                    {
                        MarkAllAttackedPositions(row, col);
                        PutQueens(row + 1);
                        UnmarkAllAttackedPositions(row, col);
                    }
                }
            }
        }

        private static void UnmarkAllAttackedPositions(int row, int col)
        {
            AttackedColumns[col] = false;
            AttackedLeftDiagonals[row + ReversedCol[col]] = false;
            AttackedRightDiagonals[row + col] = false;
            Chessboard[row, col] = false;
        }

        private static void MarkAllAttackedPositions(int row, int col)
        {
            AttackedColumns[col] = true;
            AttackedLeftDiagonals[row + ReversedCol[col]] = true;
            AttackedRightDiagonals[row + col] = true;
            Chessboard[row, col] = true;
        }

        private static bool CanPlaceQueen(int row, int col)
        {
            var positionOccupied = AttackedColumns[col] || AttackedRightDiagonals[row + col]
                                   || AttackedLeftDiagonals[row + ReversedCol[col]];
            return !positionOccupied;
        }

        private static void PrintSolution()
        {
            for (int row = 0; row < Size; row++)
            {
                for (int col = 0; col < Size; col++)
                {
                    if (Chessboard[row, col] == true)
                    {
                        Console.Write("* ");
                    }
                    else
                    {
                        Console.Write("- ");
                    }
                }
                Console.WriteLine();
            }
            Console.WriteLine();

            SolutionsFound++;
        }
    }
}
