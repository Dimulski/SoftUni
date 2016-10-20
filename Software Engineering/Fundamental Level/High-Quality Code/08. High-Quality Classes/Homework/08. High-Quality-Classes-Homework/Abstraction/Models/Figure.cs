namespace Abstraction.Models
{
    internal abstract class Figure : IFigure
    {
        public abstract double CalculatePerimeter();

        public abstract double CalculateSurface();

        public override string ToString()
        {
            string stringOutput = string.Format("Perimeter: {0:f2}, Surface: {1:f2}",
                 this.CalculatePerimeter(), this.CalculateSurface());
            return stringOutput;
        }
    }
}