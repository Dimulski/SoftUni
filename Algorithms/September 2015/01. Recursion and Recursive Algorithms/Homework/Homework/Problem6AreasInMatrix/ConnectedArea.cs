using System;

namespace Problem6AreasInMatrix
{
    public class ConnectedArea : IComparable<ConnectedArea>
    {
        public ConnectedArea(int size, int row, int col)
        {
            this.Size = size;
            this.Row = row;
            this.Col = col;
        }

        int Size { get; set; }

        int Row { get; set; }

        int Col { get; set; }

        public int CompareTo(ConnectedArea other)
        {
            var firstCompResult = other.Size.CompareTo(this.Size);
            if (firstCompResult != 0) return firstCompResult;

            var secondCompResult = this.Col.CompareTo(other.Col);
            if (secondCompResult != 0) return secondCompResult;

            return this.Row.CompareTo(other.Row);

        }

        public override string ToString()
        {
            return string.Format("({0}, {1}), size: {2}", Row, Col, Size);
        }
    }
}
