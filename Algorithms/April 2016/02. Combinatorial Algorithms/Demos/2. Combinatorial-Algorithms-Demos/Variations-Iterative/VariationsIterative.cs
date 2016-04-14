
using System;

class VariationsIterative
{
    static void Main()
    {
        int n = 5;
        int k = 3;
        int[] arr = new int[k];

        while (true)
        {
            Print(arr);
            int digitIndex = k - 1;
            while (digitIndex >= 0 && arr[digitIndex] == n-1)
            {
                digitIndex--;
            }
            if (digitIndex < 0)
            {
                break;
            }
            arr[digitIndex]++;
            for (int i = digitIndex + 1; i < k; i++)
            {
                arr[i] = 0;
            }
        }
    }

    static void Print(int[] arr)
    {
        Console.WriteLine("(" + string.Join(", ", arr) + ")");
    }
}
