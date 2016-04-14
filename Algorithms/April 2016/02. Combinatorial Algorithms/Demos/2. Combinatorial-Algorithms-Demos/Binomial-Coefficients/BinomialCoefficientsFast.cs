using System;

class BinomialCoefficientsFast
{
    const int MAX = 100;
    static decimal[,] binomCoeff = new decimal[MAX, MAX];

    static decimal Binom(int n, int k)
    {
        if (k > n)
            return 0;
        if (0 == k || k == n)
            return 1;
        if (binomCoeff[n, k] == 0)
            binomCoeff[n, k] = Binom(n - 1, k - 1) + Binom(n - 1, k);
        return binomCoeff[n, k];
    }

    static void Main()
    {
        Console.WriteLine("C(2, 4) = " + Binom(4, 2));
        Console.WriteLine("C(4, 10) = " + Binom(10, 4));
        Console.WriteLine("C(7, 13) = " + Binom(13, 7));
        Console.WriteLine("C(13, 26) = " + Binom(26, 13));
        Console.WriteLine("C(12, 30) = " + Binom(30, 12));
        Console.WriteLine("C(22, 50) = " + Binom(50, 22));
        Console.WriteLine("C(25, 70) = " + Binom(70, 25));
    }
}
