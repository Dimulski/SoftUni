namespace _01.FindTheRoot
{
    using System;
    using System.Linq;

    public class FindTheRoot
    {
        private const string MultipleRootsMessage = "Multiple root nodes!";
        private const string NoRootMessage = "No root!";

        private static Node<int>[] nodes; 

        public static void Main()
        {
            ReadNodes();
            var roots = GetRootNode();
            Console.WriteLine("Root: {0}", roots == null ? NoRootMessage : roots);
        }

        private static void ReadNodes()
        {
            int numberOfNodes = int.Parse(Console.ReadLine());
            int numberOfEdges = int.Parse(Console.ReadLine());
            nodes = new Node<int>[numberOfNodes];
            for (int nodeValue = 0; nodeValue < numberOfNodes; nodeValue++)
            {
                nodes[nodeValue] = new Node<int>(nodeValue);
            }

            for (int currEdge = 0; currEdge < numberOfEdges; currEdge++)
            {
                var args = Console.ReadLine()
                    .Split(new[] {' '}, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToList();
                int parent = args[0];
                int child = args[1];

                nodes[parent].Children.Add(nodes[child]);
                nodes[child].Parents.Add(nodes[parent]);
            }
        }

        private static string GetRootNode()
        {
            int numberOfRoots = 0;
            string root = string.Empty;
            foreach (var node in nodes)
            {
                if (node.Parents.Count == 0)
                {
                    numberOfRoots++;
                    root = node.Value.ToString();
                }
            }

            if (numberOfRoots == 1)
            {
                return root;
            }

            if (numberOfRoots > 1)
            {
                return MultipleRootsMessage;
            }

            return null;
        }
    }
}
