namespace Minesweeper
{
    using Contracts;
    using Core;
    using UI;

    public static class MinesweeperMain
    {
        public static void Main()
        {
            IGameDb gameDb = new GameDb();
            IInputReader reader = new ConsoleReader();
            IOutputWriter writer = new ConsoleWriter();

            var engine = new GameEngine(
                gameDb,
                reader,
                writer);

            engine.Start();
        }
    }
}