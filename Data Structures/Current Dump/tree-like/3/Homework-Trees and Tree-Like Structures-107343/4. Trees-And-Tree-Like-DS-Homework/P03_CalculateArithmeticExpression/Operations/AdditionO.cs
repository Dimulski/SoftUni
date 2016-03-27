namespace P03_CalculateArithmeticExpression.Operations
{
    public class AdditionO : Operation
    {
        private static int precedence = 0;
        private static int operandsCount = 2;

        public AdditionO()
            : base()
        {
        }

        public override double Calculate(params double[] p)
        {
            double result = p[0] + p[1];

            return result;
        }
    }
}

/*
public AdditionO(double x, double y)
        {
            this.X = x;
            this.Y = y;
        }

        public double X { get; set; }

        public double Y { get; set; }
*/