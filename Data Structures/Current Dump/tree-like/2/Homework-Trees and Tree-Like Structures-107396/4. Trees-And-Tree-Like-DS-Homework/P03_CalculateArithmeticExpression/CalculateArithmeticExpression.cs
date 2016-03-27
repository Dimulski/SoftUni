namespace P03_CalculateArithmeticExpression
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;

    using P03_CalculateArithmeticExpression.Operations;

    public class CalculateArithmeticExpression
    {
        private static readonly Dictionary<string, IOperation> Operations = new Dictionary<string, IOperation>();
        private static readonly Dictionary<string, int> Precedence = new Dictionary<string, int>();
        private static readonly Dictionary<string, int> OperandsCount = new Dictionary<string, int>();

        public static void Main()
        {
            DeclareOperations();
            DeclarePrecedences();
            DeclareOperandsCount();

            string input = Console.ReadLine();
            string[] rowExpression = ProcessInput(input);     

            try
            {
                double result = CalculateExpression(ShuntExression(rowExpression));

                Console.WriteLine(result);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        public static string[] ProcessInput(string input)
        {
            StringBuilder inputProcessed = new StringBuilder();
            for (int i = 0; i < input.Length - 1; i++)
            {
                char current = input[i];
                char next = input[i + 1];
                inputProcessed.Append(current);
                if ((char.IsDigit(current) && char.IsPunctuation(next) && !next.Equals('.'))
                    || (char.IsPunctuation(current) && char.IsDigit(next) && !current.Equals('.') && !current.Equals('-'))
                    || (char.IsPunctuation(current) && char.IsPunctuation(next) && !current.Equals('-')))
                {
                    inputProcessed.Append(" ");
                }
            }

            inputProcessed.Append(input[input.Length - 1]);

            string[] rowExpression =
                inputProcessed.ToString()
                .Split(
                new[] { ' ', '\t', '\n' },
                StringSplitOptions.RemoveEmptyEntries);

            return rowExpression;
        }

        public static Queue<string> ShuntExression(string[] input)
        {
            Queue<string> expression = new Queue<string>();
            Stack<string> operators = new Stack<string>();

            for (int index = 0; index < input.Length; index++)
            {
                double current;
                if (double.TryParse(input[index], out current))
                {
                    expression.Enqueue(input[index]);
                }
                else if (Operations.ContainsKey(input[index]))
                {
                    while (operators.Any()
                        && !operators.Peek().Equals("(")
                        && Precedence[input[index]] <= Precedence[operators.Peek()])
                    {
                        if (Precedence[input[index]] <= Precedence[operators.Peek()])
                        {
                            expression.Enqueue(operators.Pop());
                        }
                    }

                    operators.Push(input[index]);
                }
                else if (input[index].Equals("("))
                {
                    operators.Push(input[index]);
                }
                else if (input[index].Equals(")"))
                {
                    while (!operators.Peek().Equals("("))
                    {
                        if (!operators.Any())
                        {
                            throw new ArgumentException("error");
                        }

                        expression.Enqueue(operators.Pop());
                    }

                    operators.Pop();
                }

                if (index == input.Length - 1)
                {
                    while (operators.Any())
                    {
                        if (operators.Peek().Equals("(") || operators.Peek().Equals(")"))
                        {
                            throw new ArgumentException("error");
                        }

                        expression.Enqueue(operators.Pop());
                    }
                }
            }

            return expression;
        }

        public static double CalculateExpression(Queue<string> expression)
        {
            Stack<double> operands = new Stack<double>();

            while (expression.Any())
            {
                string current = expression.Dequeue();
                double operand;
                if (double.TryParse(current, out operand))
                {
                    operands.Push(operand);
                }
                else
                {
                    if (!Operations.ContainsKey(current) || operands.Count < OperandsCount[current])
                    {
                        throw new ArgumentException("error");
                    }

                    double[] currentOperands = new double[OperandsCount[current]];
                    for (int i = OperandsCount[current] - 1; i >= 0; i--)
                    {
                        currentOperands[i] = operands.Pop();
                    }

                    IOperation operation = Operations[current];
                    double newOperand = operation.Calculate(currentOperands);
                    operands.Push(newOperand);
                }
            }

            if (operands.Count != 1)
            {
                throw new ArgumentException("error");
            }

            return operands.Pop();
        }
        
        private static void DeclareOperations()
        {
            Operations.Add("+", new AdditionO());
            Operations.Add("-", new SubstractionO());
            Operations.Add("*", new MultiplicationO());
            Operations.Add("/", new DivisionO());
        }

        private static void DeclarePrecedences()
        {
            Precedence.Add("+", 0);
            Precedence.Add("-", 0);
            Precedence.Add("*", 1);
            Precedence.Add("/", 1);
            Precedence.Add("(", 0);
        }

        private static void DeclareOperandsCount()
        {
            OperandsCount.Add("+", 2);
            OperandsCount.Add("-", 2);
            OperandsCount.Add("*", 2);
            OperandsCount.Add("/", 2);
        }
    }
}

/*
            string pattern = @"(-?\d+\.\d*)|(-?\d+)";
            Regex regex = new Regex(pattern);

            Match match = regex.Match(input);
            while (match.Success)
            {
                string replacement = " " + match.ToString() + " ";
                input = input.Replace(match.ToString(), replacement);
                match = match.NextMatch();
            }
            */