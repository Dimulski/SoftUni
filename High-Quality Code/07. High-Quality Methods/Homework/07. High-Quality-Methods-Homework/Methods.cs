using System;

namespace Methods
{
    public class Methods
    {
        public static double CalcTriangleArea(float a, float b, float c)
        {
            if (a <= 0 || b <= 0 || c <= 0)
            {
                throw new ArgumentOutOfRangeException("The sides of the triangle must be positive!");
            }
            if (a >= b + c || b >= a + c || c >= a + b)
            {
                throw new ArgumentOutOfRangeException("Can not form a triangle, incorrect side sizes!");
            }

            double s = (a + b + c) / 2;
            double area = Math.Sqrt(s * (s - a) * (s - b) * (s - c));
            return area;
        }

        public static string NumberToDigit(int number)
        {
            if (!(number >= 0 && number <= 9))
            {
                throw new ArgumentOutOfRangeException("The number must be between 0 and 9.");
            }
            switch (number)
            {
                case 0: return "zero";
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                case 9: return "nine";
                default: return "Invalid number!";
            }
        }

        public static int FindMax(params int[] elements)
        {
            if (elements == null || elements.Length == 0)
            {
                throw new ArgumentNullException("The elements array cannot be null or empty!");
            }

            int maxElement = elements[0];
            for (int i = 1; i < elements.Length; i++)
            {
                if (elements[i] > maxElement)
                {
                    maxElement = elements[i];
                }
            }
            return maxElement;
        }

        public static void PrintAsNumber(object number, string format)
        {
            if (!Microsoft.VisualBasic.Information.IsNumeric(number))
            {
                throw new ArgumentException("The object is not a numeric type!");
            }

            switch (format)
            {
                case "f":
                    Console.WriteLine("{0:f2}", number);
                    break;
                case "%":
                    Console.WriteLine("{0:p0}", number);
                    break;
                case "r":
                    Console.WriteLine("{0,8}", number);
                    break;
                default:
                    Console.WriteLine("Incorrect format!");
                    break;
            }
        }

        public static double CalculatePointsDistance(double x1, double y1, double x2, double y2)
        {
            double distance = Math.Sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            return distance;
        }

        public static bool ArePointsHorizontal(double y1, double y2)
        {
            bool arePointsHorizontal = Math.Abs(y1 - y2) < Double.Epsilon;
            return arePointsHorizontal;
        }

        public static bool ArePointsVertical(double x1, double x2)
        {
            bool arePointsVertical = Math.Abs(x1 - x2) < Double.Epsilon;
            return arePointsVertical;
        }
    }
}