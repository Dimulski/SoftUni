namespace _08.DistanceInLabyrinth
{
    using System;
    using System.Collections.Generic;

    public class DistanceInLabyrinth
    {
        public static void Main()
        {
            Console.Write("Rows: ");
            int rows = int.Parse(Console.ReadLine());
            Console.Write("Cols: ");
            int cols = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter matrix:");
            string[,] matrix = new string[rows, cols];
            int startRow = 0;
            int startCol = 0;

            for (int row = 0; row < rows; row++)
            {
                string[] line = Console.ReadLine().Split();

                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = line[col];
                    if (line[col] == "*")
                    {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            var firstCell = new Cell(startRow, startCol, 0);
            var queue = new Queue<Cell>();
            queue.Enqueue(firstCell);

            while (queue.Count > 0)
            {
                var currCell = queue.Dequeue();

                if (currCell.Row > 0 &&
                    matrix[currCell.Row - 1, currCell.Column] == "0")
                {
                    queue.Enqueue(new Cell(currCell.Row - 1, currCell.Column, currCell.Step + 1));
                    matrix[currCell.Row - 1, currCell.Column] = (currCell.Step + 1).ToString();
                }

                if (currCell.Column > 0 &&
                    matrix[currCell.Row, currCell.Column - 1] == "0")
                {
                    queue.Enqueue(new Cell(currCell.Row, currCell.Column - 1, currCell.Step + 1));
                    matrix[currCell.Row, currCell.Column - 1] = (currCell.Step + 1).ToString();
                }

                if (currCell.Row < matrix.GetLength(0) - 1 &&
                    matrix[currCell.Row + 1, currCell.Column] == "0")
                {
                    queue.Enqueue(new Cell(currCell.Row + 1, currCell.Column, currCell.Step + 1));
                    matrix[currCell.Row + 1, currCell.Column] = (currCell.Step + 1).ToString();
                }

                if (currCell.Column < matrix.GetLength(1) - 1 &&
                    matrix[currCell.Row, currCell.Column + 1] == "0")
                {
                    queue.Enqueue(new Cell(currCell.Row, currCell.Column + 1, currCell.Step + 1));
                    matrix[currCell.Row, currCell.Column + 1] = (currCell.Step + 1).ToString();
                }
            }

            Console.WriteLine(new string('-', 20));

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    Console.Write("{0} ", matrix[row, col] == "0" ? "u" : matrix[row, col]);
                }

                Console.WriteLine();
            }
        }
    }
}
