namespace Minesweeper.Contracts
{
    public interface IEngine
    {
        bool IsRunning { get; set; }

        void Start();

        void Stop();
    }
}