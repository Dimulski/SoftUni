namespace Problem1BunkerBuster
{
    using System;
    using System.Linq;

    class BunkerBusterMain
    {
        static void Main()
        {
            var dimensions = Console.ReadLine().Split();
            int rows = int.Parse(dimensions[0]);
            int cols = int.Parse(dimensions[1]);
            int[,] field = new int[rows, cols];

            InitField(rows, cols, field);

            string command = Console.ReadLine();
            while (command != "cease fire!")
            {
                var commandParams = command.Split();
                int row = int.Parse(commandParams[0]);
                int col = int.Parse(commandParams[1]);
                string bombString = commandParams[2];
                char bombChar = bombString[0];

                DoTheDamage(field, row, col, bombChar);

                command = Console.ReadLine();
            }

            int destroyedCells = CountDestroyedCells(field);
            int totalCells = rows * cols;
            double percentage = destroyedCells / (double)totalCells * 100;

            Console.WriteLine("Destroyed bunkers: {0}", destroyedCells);
            Console.WriteLine("Damage done: {0:F1} %", percentage);

        }

        private static void DoTheDamage(int[,] field, int row, int col, char bombChar)
        {
            int fullDamage = bombChar;
            int halfDamage = (int)Math.Ceiling(fullDamage / (double)2);

            int startRow = Math.Max(0, row - 1);
            int endRow = Math.Min(field.GetLength(0) - 1, row + 1);
            int startCol = Math.Max(0, col - 1);
            int endCol = Math.Min(field.GetLength(1) - 1, col + 1);

            for (int i = startRow; i <= endRow; i++)
            {
                for (int j = startCol; j <= endCol; j++)
                {
                    if (row == i && col == j)
                    {
                        field[i, j] -= fullDamage;
                    }
                    else
                    {
                        field[i, j] -= halfDamage;
                    }
                }
            }
        }

        private static int CountDestroyedCells(int[,] field)
        {
            int counter = 0;
            for (int i = 0; i < field.GetLength(0); i++)
            {
                for (int j = 0; j < field.GetLength(1); j++)
                {
                    if (field[i, j] <= 0)
                    {
                        counter++;
                    }
                }
            }
            return counter;
        }

        private static void InitField(int numberOfRows, int numberOfColumns, int[,] field)
        {
            for (int i = 0; i < numberOfRows; i++)
            {
                string[] cellInfo = Console.ReadLine().Split();

                for (int j = 0; j < numberOfColumns; j++)
                {
                    field[i, j] = int.Parse(cellInfo[j]);
                }
            }
        }
    }
}
