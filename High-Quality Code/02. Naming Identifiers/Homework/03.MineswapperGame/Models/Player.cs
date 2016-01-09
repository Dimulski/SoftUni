namespace Minesweeper.Models
{
    public class Player
    {
        private string name;
        private int points;

        public Player(string name, int points = 0)
        {
            this.Name = name;
            this.Points = points;
        }

        public string Name
        {
            get
            {
                return this.name;
            }

            private set
            {
                this.name = value;
            }
        }

        public int Points
        {
            get
            {
                return this.points;
            }

            private set
            {
                this.points = value;
            }
        }
    }
}