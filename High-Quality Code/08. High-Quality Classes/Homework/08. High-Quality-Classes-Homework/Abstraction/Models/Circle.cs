using System;

namespace Abstraction.Models
{
    class Circle : Figure
    {
        private double _radius;

        public Circle(double radius)
        {
            this.Radius = radius;
        }

        public double Radius
        {
            get { return this._radius; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Circle Radius can not be negatice number or zero!");
                }
                this._radius = value;
            }
        }

        public override double CalculatePerimeter()
        {
            double perimeter = 2 * Math.PI * this.Radius;
            return perimeter;
        }

        public override double CalculateSurface()
        {
            double surface = Math.PI * this.Radius * this.Radius;
            return surface;
        }

        public override string ToString()
        {
            string stringOutput = string.Format("Cicle with radius {0} and ", this.Radius) + base.ToString();
            return stringOutput;
        }
    }
}