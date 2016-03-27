namespace P03_CalculateArithmeticExpression.Operations
{
    public class SubstractionO : Operation
    {
        private static int precedence = 0;
        private static int operandsCount = 2;

        public SubstractionO()
            : base()
        {
        }

        public override double Calculate(params double[] p)
        {
            double result = p[0] - p[1];

            return result;
        }
    }
}