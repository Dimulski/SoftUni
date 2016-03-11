namespace Problem1PlayWithTrees
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class PlayWithTrees
    {
        private static Dictionary<int, Tree<int>> nodeByValue = new Dictionary<int, Tree<int>>();

        public static void Main()
        {
            int nodesCount = int.Parse(Console.ReadLine());

            for (int i = 1; i < nodesCount; i++)
            {
                string[] edge = Console.ReadLine().Split(' ');
                int parentValue = int.Parse(edge[0]);
                Tree<int> parentNode = GetTreeNodeByValue(parentValue);
                int childValue = int.Parse(edge[1]);
                Tree<int> childNode = GetTreeNodeByValue(childValue);
                parentNode.Children.Add(childNode);
                childNode.Parent = parentNode;
            }
            int pathSum = int.Parse(Console.ReadLine());
            int subtreeSum = int.Parse(Console.ReadLine());

            Console.WriteLine("Root node: {0}{1}", FindRootNode().Value, Environment.NewLine);

            var leafNodesValues = FindLeafNodes().OrderBy(node => node.Value).Select(node => node.Value);
            Console.WriteLine("Leaf nodes: {0}{1}", string.Join(", ",leafNodesValues), Environment.NewLine);

            var middleNodesValues = FindMiddleNodes().OrderBy(node => node.Value).Select(node => node.Value);
            Console.WriteLine("Middle nodes: {0}{1}", string.Join(", ", middleNodesValues), Environment.NewLine);

            var deepestTree = FindLongestPath();
            var stack = new Stack<int>();
            while (deepestTree != null)
            {
                stack.Push(deepestTree.Value);
                deepestTree = deepestTree.Parent;
            }
            Console.WriteLine("Longest path:");
            var longestPathLength = stack.Count;
            while (stack.Count > 0)
            {
                Console.Write("{0} -> ", stack.Pop());
                if (stack.Count == 1)
                {
                    Console.Write(stack.Pop());
                }
            }
            Console.WriteLine(" (length = {0}){1}", longestPathLength, Environment.NewLine);

            Console.WriteLine("Path of sum {0}:", pathSum);
            var pathsWithCorrectLength = FindPathsWithSum(pathSum);
            foreach (string path in pathsWithCorrectLength)
            {
                Console.WriteLine(path);
            }
        }

        private static List<string> FindPathsWithSum(int targetSum) // Relies on FindLeafNodes()
        {
            var leafNodesList = FindLeafNodes();
            var result = new List<string>();
            foreach (var tree in leafNodesList)
            {
                var sum = 0;
                var leafNode = tree;
                while (leafNode != null)
                {
                    sum += leafNode.Value;
                    leafNode = leafNode.Parent; // not sure if root node has parent/null. Might cause error.
                }
                if (sum == targetSum)
                {
                    result.Add(string.Join(" -> ", GetTreePath(tree)));
                }
            }
            return result;
        }

        private static List<int> GetTreePath(Tree<int> tree)
        {
            var leafNode = tree;
            var stack = new Stack<int>();
            while (leafNode != null)
            {
                stack.Push(leafNode.Value);
                leafNode = leafNode.Parent;
            }
            var result = new List<int>();
            while (stack.Count > 0)
            {
                result.Add(stack.Pop());
            }

            return result;
        }

        private static Tree<int> FindLongestPath() // Relies on FindLeafNodes()
        {
            var best = 0;
            Tree<int> deepestTree = null;
            var leafNodesList = FindLeafNodes();
                        
            foreach (var tree in leafNodesList)
            {
                var counter = 0;
                var leafNode = tree;
                while (leafNode != null)
                {
                    counter++;
                    leafNode = leafNode.Parent; // not sure if root node has parent/null. Might cause error.
                }
                if (counter > best)
                {
                    best = counter;
                    deepestTree = tree;
                }
            }

            return deepestTree;
        }

        private static Tree<int> GetTreeNodeByValue(int value)
        {
            if (!nodeByValue.ContainsKey(value))
            {
                nodeByValue[value] = new Tree<int>(value);
            }
            return nodeByValue[value];
        }

        private static Tree<int> FindRootNode()
        {
            var rootNode = nodeByValue.Values.FirstOrDefault(node => node.Parent == null);
            return rootNode;
        }

        private static IEnumerable<Tree<int>> FindMiddleNodes()
        {
            var middleNodes = nodeByValue.Values.Where(node => node.Children.Count > 0 && node.Parent != null).ToList();
            return middleNodes;
        }

        private static IEnumerable<Tree<int>> FindLeafNodes()
        {
            var leafNodes = nodeByValue.Values.Where(node => node.Children.Count == 0).ToList(); // don't know if necessary - && node.Parent != null
            return leafNodes;
        } 
    }
}
