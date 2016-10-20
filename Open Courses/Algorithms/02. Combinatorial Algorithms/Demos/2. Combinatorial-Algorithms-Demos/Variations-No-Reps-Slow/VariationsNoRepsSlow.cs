using System;
using System.Linq;

class VariationsNoRepsSlow
{
    const int k = 2;
    const int n = 10;
	static string[] objects = new string[n] 
	{
		"banana", "apple", "orange", "strawberry", "raspberry",
		"apricot", "cherry", "lemon", "grapes", "melon"
	};
	static int[] arr = new int[k];
	static bool[] used = new bool[n];

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
			for (int i = 0; i < n; i++)
			{
				if (!used[i])
				{
					used[i] = true;
					arr[index] = i;
					GenerateVariationsNoRepetitions(index + 1);
					used[i] = false;
				}
			}
		}
	}

    static void PrintVariations()
    {
        Console.WriteLine("({0}) --> ({1})",
            string.Join(", ", arr),
            string.Join(", ", arr.Select(i => objects[i])));
    }
}
