using System;
using System.Linq;

class CombinationsGeneratorWithReps
{
    const int k = 3;
    const int n = 5;
	static string[] objects = new string[n] 
	{
		"banana", "apple", "orange", "strawberry", "raspberry"
	};
	static int[] arr = new int[k];

	static void Main()
	{
		GenerateCombinationsNoRepetitions(0, 0);
	}

	static void GenerateCombinationsNoRepetitions(int index, int start)
	{
		if (index >= k)
		{
			PrintCombinations();
		}
		else
		{
			for (int i = start; i < n; i++)
			{
				arr[index] = i;
				GenerateCombinationsNoRepetitions(index + 1, i);
			}
		}
	}

    static void PrintCombinations()
    {
        Console.WriteLine("({0}) --> ({1})",
            string.Join(", ", arr),
            string.Join(", ", arr.Select(i => objects[i])));
    }
}
