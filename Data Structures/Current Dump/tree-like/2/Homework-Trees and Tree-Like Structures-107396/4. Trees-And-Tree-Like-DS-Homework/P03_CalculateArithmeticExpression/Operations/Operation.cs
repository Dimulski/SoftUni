namespace P03_CalculateArithmeticExpression.Operations
{
    using System;

    public abstract class Operation : IOperation
    {
        private static int precedence;
        private static int operandsCount;

        protected Operation()
        {
            this.Precedence = precedence;
            this.OperandsCount = operandsCount;
        }

        public int Precedence { get; private set; }

        public int OperandsCount { get; private set; }

        public abstract double Calculate(params double[] p);
    }
}