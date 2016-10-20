using System;
using System.Linq;

class VariationsGeneratorRecursive
{
    const int k = 3;
    const int n = 10;
	static string[] objects = new string[n] 
	{
		"banana", "apple", "orange", "strawberry", "raspberry",
		"apricot", "cherry", "lemon", "grapes", "melon"
	};
	static int[] arr = new int[k];

	static void Main()
	{
		GenerateVariationsWithRepetitions(0);
	}

	static void GenerateVariationsWithRepetitions(int index)
	{
		if (index >= k)
		{
			PrintVariations();
		}
		else
		{
			for (int i = 0; i < n; i++)
			{
				arr[index] = i;
				GenerateVariationsWithRepetitions(index + 1);
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
