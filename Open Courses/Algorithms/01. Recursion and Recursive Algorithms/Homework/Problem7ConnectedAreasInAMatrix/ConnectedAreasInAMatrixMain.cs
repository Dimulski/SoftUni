using System;
using System.Collections.Generic;

namespace Problem7ConnectedAreasInAMatrix
{
    class ConnectedAreasInAMatrixMain
    {
        //static char[,] matrix =
        //{
        //    {' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' '},
        //    {' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' '},
        //    {' ', ' ', ' ', '*', ' ', ' ', ' ', '*', ' '},
        //    {' ', ' ', ' ', ' ', '*', ' ', '*', ' ', ' '},
        //};

        static char[,] matrix =
        {
            {'*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' '},
            {'*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' '},
            {'*', ' ', ' ', '*', '*', '*', '*', '*', ' ', ' '},
            {'*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' '},
            {'*', ' ', ' ', '*', ' ', ' ', ' ', '*', ' ', ' '},
        };

        static int matrixRows = matrix.GetLength(0);
        static int matrixCols = matrix.GetLength(1);

        static bool[,] visitedMatrix = new bool[matrixRows, matrixCols];

        static int freeRow;
        static int freeCol;

        static SortedSet<ConnectedArea> areas = new SortedSet<ConnectedArea>();

        static int cellCount = 0;

        static void Main()
        {
            while (FindFreeCell() == true)
            {
                FindArea(freeRow, freeCol);
                areas.Add(new ConnectedArea(cellCount, freeRow, freeCol));
                cellCount = 0;
            }
            var counter = 1;
            foreach (var area in areas)
            {
                Console.WriteLine("Area #{0} at {1}", counter++, area);
            }
        }

        private static bool FindFreeCell() // could be done a lot smarter
        {
            for (int i = 0; i < matrixRows; i++)
            {
                for (int j = 0; j < matrixCols; j++)
                {
                    if (matrix[i, j] == ' ' && visitedMatrix[i, j] == false)
                    {
                        freeRow = i;
                        freeCol = j;
                        return true;
                    }
                }
            }
            return false;
        }

        private static void FindArea(int row, int col)
        {
            if ((col < 0) || (row < 0) || (col >= matrix.GetLength(1)) || (row >= matrix.GetLength(0)))
            {
                return;
            }

            if (matrix[row, col] != ' ')
            {
                visitedMatrix[row, col] = true;
                return;
            }

            if (visitedMatrix[row, col] == false)
            {
                cellCount++;
                visitedMatrix[row, col] = true;
            }

            matrix[row, col] = 'v';

            FindArea(row, col + 1); // Right
            FindArea(row + 1, col); // Down
            FindArea(row, col - 1); // Left
            FindArea(row - 1, col); // Up

            matrix[row, col] = ' ';
        }
    }
}
