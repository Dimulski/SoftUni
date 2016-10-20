namespace Problem2ArraySlider
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Numerics;

    class ArraySliderMain
    {
        static void Main()
        {
            //List<BigInteger> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            BigInteger[] numbers = Console.ReadLine()
                .Split(new[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(BigInteger.Parse)
                .ToArray();

            int listLength = numbers.Length;
            int currentIndex = 0;
            string command = Console.ReadLine();
            while (command != "stop")
            {
                string[] commandParams = command.Split();
                int offset = int.Parse(commandParams[0]) % listLength;
                char operation = Char.Parse(commandParams[1]);
                int operand = int.Parse(commandParams[2]);

                if (offset < 0)
                {
                    offset += listLength;
                }

                currentIndex = (currentIndex + offset) % listLength;

                DoDatOperation(numbers, currentIndex, operation, operand);

                command = Console.ReadLine();
            }
            Console.WriteLine("[{0}]", string.Join(", ", numbers));
        }


        private static void DoDatOperation(BigInteger[] numbers, int offset, char operation, int operand)
        {
            switch (operation)
            {
                case '&':
                    numbers[offset] &= operand;
                    break;
                case '|':
                    numbers[offset] |= operand;
                    break;
                case '^':
                    numbers[offset] ^= operand;
                    break;
                case '+':
                    numbers[offset] += operand;
                    break;
                case '-':
                    numbers[offset] -= operand;
                    break;
                case '*':
                    numbers[offset] *= operand;
                    break;
                case '/':
                    numbers[offset] /= operand;
                    break;
            }

            if (numbers[offset] < 0)
            {
                numbers[offset] = 0;
            }
        }
    }
}
