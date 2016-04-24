namespace Problem8Needles
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class NeedlesMain
    {
        public static void Main()
        {
            Console.ReadLine();
            List<int> sequence = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> needles = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<int> result = new List<int>();

            for (int i = 0; i < needles.Count; i++)
            {
                int index = 0;
                while (index < sequence.Count && needles[i] > sequence[index])
                {
                    index++;
                }

                while (index > 0 && sequence[index - 1] == 0)
                {
                    index--;
                }

                if (index <= sequence.Count)
                {
                    result.Add(index);
                }
            }

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
