namespace Problem1FindTheRoot
{
    using System;

    public class FindTheRootMain
    {
        public static void Main()
        {
            int numberOfNodes = int.Parse(Console.ReadLine());
            int numberOfEdges = int.Parse(Console.ReadLine());

            var hasParent = new bool[numberOfNodes];
            for (int i = 0; i < numberOfEdges; i++)
            {
                var lineParams = Console.ReadLine().Split(' ');
                int toNode = int.Parse(lineParams[1]);
                hasParent[toNode] = true;
            }

            int rootsCount = 0;
            int rootValue = -1;

            for (int i = 0; i < hasParent.Length; i++)
            {
                if (!hasParent[i])
                {
                    rootsCount++;
                    rootValue = i;
                }
            }

            if (rootsCount == 0)
            {
                Console.WriteLine("No root!");
            }
            else if (rootsCount > 1)
            {
                Console.WriteLine("Multiple root nodes!");
            }
            else
            {
                Console.WriteLine(rootValue);
            }
        }
    }
}