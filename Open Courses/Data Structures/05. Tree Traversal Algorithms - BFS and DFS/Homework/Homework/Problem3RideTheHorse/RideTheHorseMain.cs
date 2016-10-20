namespace Problem3RideTheHorse
{
    using System;
    using System.Collections.Generic;

    public class RideTheHorseMain
    {
        private const int StartValue = 1;

        private static int[,] matrix;
        private static Queue<Knight> possibleMoves;


        public static void Main()
        {
            int numberOfRows = int.Parse(Console.ReadLine());
            int numberOfCols = int.Parse(Console.ReadLine());
            int knightStartRow = int.Parse(Console.ReadLine());
            int knightStartCol = int.Parse(Console.ReadLine());

            matrix = new int[numberOfRows, numberOfCols];
            possibleMoves = new Queue<Knight>();

            var horse = new Knight(knightStartRow, knightStartCol, StartValue);
            possibleMoves.Enqueue(horse);
            MakeMove();

            var colToPrint = numberOfCols / 2;
            for (int row = 0; row < numberOfRows; row++)
            {
                for (int col = 0; col < numberOfCols; col++)
                {
                    if (col == colToPrint)
                    {
                        Console.Write(matrix[row, col]);
                    }
                }

                Console.WriteLine();
            }
        }

        private static void MakeMove()
        {
            while (possibleMoves.Count > 0)
            {
                var horse = possibleMoves.Dequeue();
                matrix[horse.X, horse.Y] = horse.Value;

                TryMove(horse, -2, 1);
                TryMove(horse, -1, 2);
                TryMove(horse, 1, 2);
                TryMove(horse, 2, 1);
                TryMove(horse, 2, -1);
                TryMove(horse, 1, -2);
                TryMove(horse, -1, -2);
                TryMove(horse, -2, -1);
            }
        }

        private static void TryMove(Knight knight, int deltaX, int deltaY)
        {
            var newX = knight.X + deltaX;
            var newY = knight.Y + deltaY;

            var isInsideMatrix = newX >= 0 && newX < matrix.GetLength(0) &&
                                 newY >= 0 && newY < matrix.GetLength(1);

            if (isInsideMatrix)
            {
                var isFreeCell = matrix[newX, newY] == 0;
                if (isFreeCell)
                {
                    possibleMoves.Enqueue(new Knight(newX, newY, knight.Value + 1));
                }
            }
        }
    }
}
