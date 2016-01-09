namespace Minesweeper.Contracts
{
    public interface IOutputWriter
    {
        void Print(string msg, params object[] args);

        void PrintLine(string msg, params object[] args);
    }
}