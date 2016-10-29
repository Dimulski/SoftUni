using System;

class Program
{
    static void Main()
    {
        int[] integerArray = new int[]
	{
	    4,
	    6,
	    8,
	    1,
	    3
	};
        //
        // Display the array
        //
        Console.WriteLine("--- Integer array before ---");
        foreach (int value in integerArray)
        {
            Console.WriteLine(value);
        }
        //
        // Clear all elements in the array.
        //
        Array.Clear(integerArray, 0, integerArray.Length);
        //
        // Display the array
        //
        Console.WriteLine("--- Integer array after ---");
        foreach (int value in integerArray)
        {
            Console.WriteLine(value);
        }
    }
}