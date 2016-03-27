namespace P03_CalculateArithmeticExpression.Operations
{
    public class DivisionO : Operation
    {
        private static int precedence = 1;
        private static int operandsCount = 2;

        public DivisionO()
            : base()
        {
        }

        public override double Calculate(params double[] p)
        {
            double result = p[0] / p[1];

            return result;
        }
    }
}