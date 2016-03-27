namespace _01.PlayWithTrees
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public static class PlayWithTrees
    {
        private static int numberOfVertices;
        private static IDictionary<int, Tree> vertices;
        private static int longestPath;
        private static Tree longestPathLeaf;
        private static int pathSumWanted;
        private static int subTreeSumWanted;

        public static void Main()
        {
            ReadInput();
            
            var rootVertex = FindRoot();
            Console.WriteLine("Root node: {0}", rootVertex.Value);
            
            var allLeafVertices = FindLeafVertices();
            Console.WriteLine("Leaf nodes: {0}", string.Join(", ", allLeafVertices));
            
            var allMiddleVertices = FindMiddleVertices();
            Console.WriteLine("Middle nodes: {0}", string.Join(", ", allMiddleVertices));
            
            FindLongestPath(rootVertex);
            var longest = BackTrackPath(longestPathLeaf);
            Console.WriteLine("Longest path:\n{0} (length = {1})", longest, longestPath);

            Console.WriteLine("Paths of sum {0}:", pathSumWanted);
            FindAllPathsWithSum(rootVertex, rootVertex.Value);

            Console.WriteLine("Subtrees of sum {0}:", subTreeSumWanted);
            FindAllSubTreesOfSum(rootVertex);
        }

        private static Tree GetTree(int value)
        {
            if (!vertices.ContainsKey(value))
            {
                vertices[value] = new Tree(value);
            }

            return vertices[value];
        }

        private static IEnumerable<int> FindMiddleVertices()
        {
            return vertices.Values
                .Where(v => v.Parent != null && v.Children.Count > 0)
                .OrderBy(v => v.Value)
                .Select(v => v.Value);
        }

        private static IEnumerable<int> FindLeafVertices()
        {
            return vertices.Values
                .Where(v => v.Parent != null && v.Children.Count == 0)
                .OrderBy(v => v.Value)
                .Select(v => v.Value);
        }

        private static Tree FindRoot()
        {
            return vertices.Values.FirstOrDefault(v => v.Parent == null);
        }

        private static void FindLongestPath(Tree tree, int depth = 1)
        {
            if (depth > longestPath)
            {
                longestPath = depth;
                longestPathLeaf = tree;
            }

            foreach (var child in tree.Children)
            {
                FindLongestPath(child, depth + 1);
            }
        }

        private static void FindAllPathsWithSum(Tree tree, int sum)
        {
            if (sum == pathSumWanted)
            {
                Console.WriteLine(BackTrackPath(tree));
            }

            foreach (var child in tree.Children)
            {
                FindAllPathsWithSum(child, sum + child.Value);
            }
        }

        private static string BackTrackPath(Tree tree, string separator = " -> ")
        {
            var result = new LinkedList<int>();
            while (tree != null)
            {
                result.AddFirst(tree.Value);
                tree = tree.Parent;
            }

            return string.Join(separator, result);
        }

        private static void DfsTravers(Tree tree, IList<int> subTree)
        {
            subTree.Add(tree.Value);

            foreach (var child in tree.Children)
            {
                DfsTravers(child, subTree);
            }
        }

        private static void FindAllSubTreesOfSum(Tree tree)
        {
            if (tree.SubTreeSum == subTreeSumWanted)
            {
                var subTree = new List<int>();
                DfsTravers(tree, subTree);
                Console.WriteLine(string.Join(" + ", subTree));
            }

            foreach (var child in tree.Children)
            {
                FindAllSubTreesOfSum(child);
            }
        }

        private static void ReadInput()
        {
            numberOfVertices = int.Parse(Console.ReadLine());
            vertices = new Dictionary<int, Tree>(numberOfVertices);

            for (int i = 1; i < numberOfVertices; i++)
            {
                var parentChildPair = Console.ReadLine()
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();

                var parentVertex = GetTree(parentChildPair[0]);
                var childVertex = GetTree(parentChildPair[1]);

                parentVertex.Children.Add(childVertex);
                childVertex.Parent = parentVertex;
            }

            pathSumWanted = int.Parse(Console.ReadLine());
            subTreeSumWanted = int.Parse(Console.ReadLine());
        }
    }
}
