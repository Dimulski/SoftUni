namespace CohesionAndCoupling
{
    using System;
    using Utils;

    class Parallelepiped
    {
        private double width;
        private double height;
        private double depth;

        public Parallelepiped(double width, double height, double depth)
        {
            this.Width = width;
            this.Height = height;
            this.Depth = depth;
        }

        public double Width
        {
            get { return this.width; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Parallelepiped Width can not be negative number or zaro!");
                }
                this.width = value;
            }
        }

        public double Height
        {
            get { return this.height; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Parallelepiped Height can not be negative number or zaro!");
                }
                this.height = value;
            }
        }

        public double Depth
        {
            get { return this.depth; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Parallelepiped Depth can not be negative number or zaro!");
                }
                this.depth = value;
            }
        }

        public double CalculateVolume()
        {
            double volume = Width * Height * Depth;
            return volume;
        }

        public double CalculateDiagonalXyz()
        {
            double distance = PolygonUtil.CalculateDistanceIn3D(0, 0, 0, Width, Height, Depth);
            return distance;
        }

        public double CalculateDiagonalXy()
        {
            double distance = PolygonUtil.CalculateDistanceIn2D(0, 0, Width, Height);
            return distance;
        }

        public double CalculateDiagonalXz()
        {
            double distance = PolygonUtil.CalculateDistanceIn2D(0, 0, Width, Depth);
            return distance;
        }

        public double CalculateDiagonalYz()
        {
            double distance = PolygonUtil.CalculateDistanceIn2D(0, 0, Height, Depth);
            return distance;
        }
    }
}