using System;

class BinomialCoefficientsSlow
{
    static decimal Binom(int n, int k)
    {
        // Console.WriteLine("Calculating Binom({0}, {1})", n, k);
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
        return Binom(n - 1, k - 1) + Binom(n - 1, k);
    }

    static void Main()
    {
        Console.WriteLine("C(2, 4) = " + Binom(4, 2));
        Console.WriteLine("C(4, 10) = " + Binom(10, 4));
        Console.WriteLine("C(7, 13) = " + Binom(13, 7));
        Console.WriteLine("C(13, 26) = " + Binom(26, 13));
        Console.WriteLine("C(12, 30) = " + Binom(30, 12));
    }
}
