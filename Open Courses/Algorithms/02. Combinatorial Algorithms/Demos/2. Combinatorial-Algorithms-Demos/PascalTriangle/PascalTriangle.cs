using System;

class PascalTriangle
{
    static void Main()
    {
        int n = 10;
        decimal[] pascal = new decimal[n + 1];

        for (int row = 0; row <= n; row++)
        {
            for (int col = row; col >= 0; col--)
            {
                if (col == 0 || col == row)
                {
                    pascal[col] = 1;
                }
                else
                {
                    pascal[col] = pascal[col] + pascal[col - 1];
                }
                Console.Write(pascal[col] + " ");
            }
            Console.WriteLine();
        }
    }
}
