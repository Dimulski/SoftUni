using System;
using System.Collections.Generic;

public class DFSConnectedComponents
{
    static Dictionary<string, List<string>> graph =
        new Dictionary<string, List<string>>() {
            { "A", new List<string>() { "D", "F" } },
            { "B", new List<string>() { "P", "Q" } },
            { "C", new List<string>() { "G" } },
            { "D", new List<string>() { "A", "F" } },
            { "E", new List<string>() { "P", "Q" } },
            { "F", new List<string>() { "A", "D" } },
            { "G", new List<string>() { "C" } },
            { "H", new List<string>() { } },
            { "I", new List<string>() { "L", "M" } },
            { "J", new List<string>() { "K", "M", "N" } },
            { "K", new List<string>() { "J", "N" } },
            { "L", new List<string>() { "I", "N" } },
            { "M", new List<string>() { "I", "J", "N" } },
            { "N", new List<string>() { "J", "K", "L" } },
            { "O", new List<string>() { } },
            { "P", new List<string>() { "B", "E", "Q" } },
            { "Q", new List<string>() { "B", "E", "P" } },
        };

    static HashSet<string> visited;

    static void RecursiveDFS(string node)
    {
        visited.Add(node);
        Console.Write(" " + node);

        if (graph.ContainsKey(node))
        {
            foreach (var childNode in graph[node])
            {
                if (!visited.Contains(childNode))
                {
                    RecursiveDFS(childNode);
                }
            }
        }
    }

    public static void Main()
    {
        visited = new HashSet<string>();
        foreach (var node in graph.Keys)
        {
            if (! visited.Contains(node))
            {
                Console.Write("Connected component:");
                RecursiveDFS(node);
                Console.WriteLine();
            }
        }
    }
}
