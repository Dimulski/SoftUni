namespace Abstraction.Models
{
    using System;

    internal class Rectangle : Figure
    {
        private double _width;
        private double _height;

        public Rectangle(double width, double height)
        {
            this.Width = width;
            this.Height = height;
        }

        public double Width
        {
            get { return this._width; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Rectangle Width can not be zero or negative number!");
                }
                this._width = value;
            }
        }

        public double Height
        {
            get { return this._height; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Rectangle Height can not be zero or negative number!");
                }
                this._height = value;
            }
        }

        public override double CalculatePerimeter()
        {
            double perimeter = 2 * (this.Width + this.Height);
            return perimeter;
        }

        public override double CalculateSurface()
        {
            double surface = this.Width * this.Height;
            return surface;
        }

        public override string ToString()
        {
            string stringOutput = string.Format("Rectangle with Width {0}, Height {1} and ", this.Width, this.Height) +
                                  base.ToString();
            return stringOutput;
        }
    }
}