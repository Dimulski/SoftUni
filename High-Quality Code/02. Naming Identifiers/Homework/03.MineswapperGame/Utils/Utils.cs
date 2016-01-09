namespace Minesweeper.Utils
{
    using System;
    using System.Text;

    public static class Utils
    {
        public static string RenderGameBoard(char[,] board)
        {
            var result = new StringBuilder();

            int numOfRows = board.GetLength(0);
            int numOfCols = board.GetLength(1);

            result.AppendLine();
            result.AppendLine("  +---------------------+");
            result.AppendLine("  | 0 1 2 3 4 5 6 7 8 9 |");
            result.AppendLine("+-+---------------------+");

            for (int row = 0; row < numOfRows; row++)
            {
                result.Append($"|{row}| ");
                for (int col = 0; col < numOfCols; col++)
                {
                    result.Append($"{board[row, col]} ");
                }

                result.AppendLine("|");
            }

            result.AppendLine("+-+---------------------+");

            return result.ToString();
        }
    }
}