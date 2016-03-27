namespace _01.QuadTreeTests
{
    using System;
    using _01.QuadTreeCore;

    public class TestBox : IBoundable, IComparable<TestBox>
    {
        public const int Width = 10;
        public const int Height = 10;

        public static int id;

        public TestBox(int x, int y, int width = Width, int height = Height)
        {
            this.Id = id;
            id++;
            this.Bounds = new Rectangle(x, y, Width, Height);
        }

        public int Id { get; set; }

        public Rectangle Bounds { get; set; }

        public int CompareTo(TestBox other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}
