namespace Methods
{
    using System;

    public class MethodsMain
    {
        static void Main()
        {
            Console.WriteLine(Methods.CalcTriangleArea(3, 4, 5));

            Console.WriteLine(Methods.NumberToDigit(5));

            Console.WriteLine(Methods.FindMax(5, -1, 3, 2, 14, 2, 3));

            Methods.PrintAsNumber(1.3, "f");
            Methods.PrintAsNumber(0.75, "%");
            Methods.PrintAsNumber(2.30, "r");

            Console.WriteLine(Methods.CalculatePointsDistance(3, -1, 3, 2.5));

            double pointX1 = 3;
            double pointY1 = -1;
            double pointX2 = 3;
            double pointY2 = 2.5;
            bool arePointsHorisontal = Methods.ArePointsHorizontal(pointY1, pointY2);
            bool arePointsVertical = Methods.ArePointsVertical(pointX1, pointX2);
            Console.WriteLine("Are points horizontal? - {0}", arePointsHorisontal);
            Console.WriteLine("Are points vertical? - {0}", arePointsVertical);
        }
    }
}