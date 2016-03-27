namespace _02.SweepAndPrune
{
    public class GameObject
    {
        private const int DefaultWidth = 10;
        private const int DefaultHeight = 10;

        public GameObject(string name, int x1, int y1, int width = DefaultWidth, int height = DefaultHeight)
        {
            this.Name = name;
            this.Width = width;
            this.Height = height;
            this.X1 = x1;
            this.Y1 = y1;
            this.X2 = this.X1 + this.Width;
            this.Y2 = this.Y1 + this.Height;
        }

        public string Name { get; set; }

        public int Y1 { get; set; }

        public int X1 { get; set; }

        public int Y2 { get; set; }

        public int X2 { get; set; }

        public int Width { get; set; }

        public int Height { get; set; }

        public bool Intersects(GameObject other)
        {
            return this.X1 <= other.X2 &&
                    other.X1 <= this.X2 &&
                    this.Y1 <= other.Y2 &&
                    other.Y1 <= this.Y2;
        }

        public override string ToString()
        {
            return string.Format("{0} ({1}, {2})...({3}, {4})", this.Name, this.X1, this.Y1, this.X2, this.Y2);
        }
    }
}
