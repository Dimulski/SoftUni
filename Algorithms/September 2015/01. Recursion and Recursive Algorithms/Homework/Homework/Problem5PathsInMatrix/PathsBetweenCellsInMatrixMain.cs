using System;
using System.Collections.Generic;

namespace Problem5PathsInMatrix
{
    class PathsBetweenCellsInMatrixMain
    {
        static List<char> path = new List<char>();

        //static char[,] labyrinth =
        //{
        //    {' ', ' ', ' ', ' ',},
        //    {' ', '*', '*', ' ',},
        //    {' ', '*', '*', ' ',},
        //    {' ', '*', 'e', ' ',},
        //    {' ', ' ', ' ', ' ',},
        //};

        static char[,] labyrinth =
        {
            {' ', ' ', ' ', ' ',' ',' '},
            {' ', '*', '*', ' ','*',' '},
            {' ', '*', '*', ' ','*',' '},
            {' ', '*', 'e', ' ',' ',' '},
            {' ', ' ', ' ', '*',' ',' '}
        };

        static void Main()
        {
            FindExit(0, 0, 'S');
        }

        private static void FindExit(int row, int col, char direction)
        {
            if ((col < 0) || (row < 0) || (col >= labyrinth.GetLength(1)) || (row >= labyrinth.GetLength(0))) 
            {
                return;
            }

            if (labyrinth[row, col] == 'e')
            {
                PrintExitPath(direction);
            }

            if (labyrinth[row, col] != ' ')
            {
                return;
            }

            labyrinth[row, col] = 'S';
            path.Add(direction);
            
            FindExit(row - 1, col, 'U'); // Up
            FindExit(row + 1, col, 'D'); // Down
            FindExit(row, col - 1, 'L'); // Left
            FindExit(row, col + 1, 'R'); // Right

            labyrinth[row, col] = ' ';
            path.RemoveAt(path.Count - 1);
        }

        private static void PrintExitPath(char lastDir)
        {
            var result = string.Join("", path) + lastDir;
            Console.WriteLine(result.Substring(1));
        }
    }
}
