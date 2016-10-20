namespace Minesweeper.Core
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using Contracts;
    using Models;

    public class GameDb : IGameDb
    {
        private const int NumberOfRows = 5;
        private const int NumberOfCols = 10;

        private char[,] publicGameBoard;
        private char[,] privateGameBoard;
        private IList<Player> topPlayers = new List<Player>(6);

        public GameDb()
        {
            this.publicGameBoard = this.InitiatePublicGameBoard();
            this.privateGameBoard = this.InitiatePrivateGameBoard();
        }

        public char[,] PublicGameBoard
        {
            get
            {
                return this.publicGameBoard;
            }
        }

        public char[,] PrivateGameBoard
        {
            get
            {
                return this.privateGameBoard;
            }
        }

        public IList<Player> TopPlayers
        {
            get
            {
                return this.topPlayers;
            }
        }

        public void ResetBoards()
        {
            this.publicGameBoard = this.InitiatePublicGameBoard();
            this.privateGameBoard = this.InitiatePrivateGameBoard();
        }

        public string RenderScoreBoard()
        {
            var result = new StringBuilder();

            this.topPlayers = this.SortHighScores();

            result.AppendLine(Environment.NewLine + "+------Top players------+");
            if (this.topPlayers.Count > 0)
            {
                for (int i = 0; i < this.topPlayers.Count; i++)
                {
                    result.AppendLine(
                        $"{i + 1}. ({this.topPlayers[i].Points:00}) {this.topPlayers[i].Name.ToUpper()}");
                }
            }
            else
            {
                result.AppendLine("------No Scores yet------");
            }

            return result.ToString();
        }

        public char CountNeighboringMines(int rowIndex, int colIndex)
        {
            int neighboringMines = 0;

            if (this.ValidateCellPosition(rowIndex, colIndex))
            {
                for (int row = rowIndex - 1; row <= rowIndex + 1; row++)
                {
                    for (int col = colIndex - 1; col <= colIndex + 1; col++)
                    {
                        if (this.ValidateCellPosition(row, col) &&
                            this.privateGameBoard[row, col] == '*')
                        {
                            neighboringMines++;
                        }
                    }
                }
            }

            return char.Parse(neighboringMines.ToString());
        }

        private char[,] InitiatePublicGameBoard()
        {
            char[,] gameBoard = new char[NumberOfRows, NumberOfCols];

            for (int row = 0; row < NumberOfRows; row++)
            {
                for (int col = 0; col < NumberOfCols; col++)
                {
                    gameBoard[row, col] = '?';
                }
            }

            return gameBoard;
        }

        private char[,] InitiatePrivateGameBoard()
        {
            char[,] gameBoard = new char[NumberOfRows, NumberOfCols];

            for (int row = 0; row < NumberOfRows; row++)
            {
                for (int col = 0; col < NumberOfCols; col++)
                {
                    gameBoard[row, col] = '-';
                }
            }

            List<int> bombs = new List<int>();
            while (bombs.Count < 15)
            {
                Random rand = new Random();
                int bombNumber = rand.Next(50);
                if (!bombs.Contains(bombNumber))
                {
                    bombs.Add(bombNumber);
                }
            }

            foreach (int bomb in bombs)
            {
                int col = bomb / NumberOfCols;
                int row = bomb % NumberOfCols;
                if (row == 0 && bomb != 0)
                {
                    col--;
                    row = NumberOfCols;
                }
                else
                {
                    row++;
                }

                gameBoard[col, row - 1] = '*';
            }

            return gameBoard;
        }

        private bool ValidateCellPosition(int row, int col)
        {
            bool result = row >= 0 &&
                          row < NumberOfRows &&
                          col >= 0 &&
                          col < NumberOfCols;

            return result;
        }

        private List<Player> SortHighScores()
        {
            var sortedPlayers = this.topPlayers
                .OrderByDescending(p => p.Points)
                .ThenByDescending(p => p.Name)
                .ToList();

            return sortedPlayers;
        }
    }
}