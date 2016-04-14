using System;

class VariationsNoRepetitionsFast
{
    const int k = 3;
    const int n = 4;

    static int[] arr = new int[k];
    static int[] free = new int[n] { 1, 2, 3, 4 };

    static void Main()
    {
        GenerateVariationsNoRepetitions(0);
    }

    static void GenerateVariationsNoRepetitions(int index)
    {
        if (index >= k)
        {
            PrintVariations();
        }
        else
        {
            for (int i = index; i < n; i++)
            {
                arr[index] = free[i];
                Swap(ref free[i], ref free[index]);
                GenerateVariationsNoRepetitions(index + 1);
                Swap(ref free[i], ref free[index]);
            }
        }
    }

    private static void Swap(ref int v1, ref int v2)
    {
        int old = v1;
        v1 = v2;
        v2 = old;
    }

    static void PrintVariations()
    {
        Console.WriteLine("(" + string.Join(", ", arr) + ")");
    }
}
