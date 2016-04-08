using System;

namespace RecursionAndThe8QueensPuzzle
{
    public class EightQueens
    {
        const int Size = 8;
        const int NumberOfDiagonals = 15;

        static bool[,] chessboard = new bool[Size, Size];
        static int[] reversedCol = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
        public static int solutionsFound = 0;

        static bool[] attackedColumns = new bool[Size];
        static bool[] attackedLeftDiagonals = new bool[NumberOfDiagonals];
        static bool[] attackedRightDiagonals = new bool[NumberOfDiagonals];
        
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
                    if (CanPlaceQueen(row,col))
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
            attackedColumns[col] = false;
            attackedLeftDiagonals[row + reversedCol[col]] = false;
            attackedRightDiagonals[row + col] = false;
            chessboard[row, col] = false;
        }

        private static void MarkAllAttackedPositions(int row, int col)
        {
            attackedColumns[col] = true;
            attackedLeftDiagonals[row + reversedCol[col]] = true;
            attackedRightDiagonals[row + col] = true;
            chessboard[row, col] = true;
        }

        private static bool CanPlaceQueen(int row, int col)
        {
            var positionOccupied =
                attackedColumns[col] ||
                attackedRightDiagonals[row + col] ||
                attackedLeftDiagonals[row + reversedCol[col]];
            return !positionOccupied;
        }

        private static void PrintSolution()
        {
            for (int row = 0; row < Size; row++)
            {
                for (int col = 0; col < Size; col++)
                {
                    if (chessboard[row, col] == true)
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

            solutionsFound++;
        }
    }
}
