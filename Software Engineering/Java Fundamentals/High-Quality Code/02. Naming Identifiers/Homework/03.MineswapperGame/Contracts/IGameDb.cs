namespace Minesweeper.Contracts
{
    using System.Collections.Generic;
    using Models;

    public interface IGameDb
    {
        char[,] PublicGameBoard { get; }

        char[,] PrivateGameBoard { get; }

        IList<Player> TopPlayers { get; }

        char CountNeighboringMines(int rowIndex, int colIndex);

        string RenderScoreBoard();

        void ResetBoards();
    }
}