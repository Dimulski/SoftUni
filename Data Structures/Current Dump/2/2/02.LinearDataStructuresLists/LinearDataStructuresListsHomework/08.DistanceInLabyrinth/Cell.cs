namespace _08.DistanceInLabyrinth
{
    public class Cell
    {
        public Cell(int row, int col, int step)
        {
            this.Row = row;
            this.Column = col;
            this.Step = step;
        }

        public int Row { get; set; }

        public int Column { get; set; }

        public int Step { get; set; }
    }
}
