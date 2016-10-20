using System;
using System.Linq;
using System.Numerics;
using System.Text.RegularExpressions;

namespace ArraySlider
{
    class ArraySliderMain
    {
        static void Main(string[] args)
        {
            var firstInputLine = Console.ReadLine();
            BigInteger[] inputSequence = Regex.Split(firstInputLine, "\\s+").Where(n => n != "").Select(n => BigInteger.Parse(n)).ToArray();
            var nextInputLine = Console.ReadLine();
            long index = 0;
            while (nextInputLine != "stop")
            {
                var nextInputArray = nextInputLine.Split(' ');
                var offset = long.Parse(nextInputArray[0]);
                var operation = nextInputArray[1];
                var operand = long.Parse(nextInputArray[2]);
                offset = offset % inputSequence.Length;
                index += offset;
                var position = index % inputSequence.Length;
                if (position < 0)
                {
                    position += inputSequence.Length;
                }
                else if (position >= inputSequence.Length)
                {
                    position -= inputSequence.Length;
                }
                ProcessOperation(inputSequence, operation, operand, position);
                nextInputLine = Console.ReadLine();
            }

            for (int i = 0; i < inputSequence.Length; i++)
            {
                if (inputSequence[i] < 0)
                {
                    inputSequence[i] = 0;
                }
            }

            Console.WriteLine("[" + string.Join(", ", inputSequence) + "]");
        }

        private static void ProcessOperation(BigInteger[] inputSequence, string operation, long operand, long position)
        {
            switch (operation)
            {
                case "+":
                    if ((inputSequence[position] + operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] + operand;
                    break;
                case "-":
                    if (inputSequence[position] < operand)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] - operand;
                    break;
                case "*":
                    if ((inputSequence[position] * operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] * operand;
                    break;
                case "/":
                    if ((inputSequence[position] / operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] / operand;
                    break;
                case "&":
                    if ((inputSequence[position] & operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] & operand;
                    break;
                case "|":
                    if ((inputSequence[position] | operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] | operand;
                    break;
                case "^":
                    if ((inputSequence[position] ^ operand) < 0)
                    {
                        inputSequence[position] = 0;
                    }
                    else inputSequence[position] = inputSequence[position] ^ operand;
                    break;
            }
        }
    }
}
