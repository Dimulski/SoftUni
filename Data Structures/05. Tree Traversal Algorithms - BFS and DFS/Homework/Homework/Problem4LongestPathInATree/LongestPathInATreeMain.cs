namespace Problem4LongestPathInATree
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public static class LongestPathInATree
    {
        private static IDictionary<int, Tree> nodes;

        public static void Main()
        {
            GetNodes();
            var longestPath = FindLongestPath();

            Console.WriteLine(longestPath);
        }

        private static long FindLongestPath()
        {
            var longestPath = 0L;
            foreach (var nodeA in nodes.Values)
            {
                foreach (var nodeB in nodes.Values)
                {
                    if (nodeA.Value != nodeB.Value)
                    {
                        var currentPath = nodeA.SumToRoot - nodeB.SumToRoot + nodeB.Value;
                        if (currentPath > longestPath)
                        {
                            longestPath = currentPath;
                        }
                    }
                }
            }

            return longestPath;
        }

        private static void GetNodes()
        {
            var nodesCount = int.Parse(Console.ReadLine());
            var edgesCount = int.Parse(Console.ReadLine());

            nodes = new Dictionary<int, Tree>(nodesCount);

            for (int node = 0; node < edgesCount; node++)
            {
                var parentChildPair = Console.ReadLine()
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();

                var currentParent = GetTree(parentChildPair[0]);
                var currentChild = GetTree(parentChildPair[1]);

                currentParent.Children.Add(currentChild);
                currentChild.Parent = currentParent;
            }
        }

        private static Tree GetTree(int value)
        {
            if (!nodes.ContainsKey(value))
            {
                nodes[value] = new Tree(value);
            }

            return nodes[value];
        }
    }
}
