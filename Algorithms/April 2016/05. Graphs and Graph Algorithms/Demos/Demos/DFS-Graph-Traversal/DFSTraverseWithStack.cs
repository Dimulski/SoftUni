using System;
using System.Collections.Generic;

public class DFSTraverseWithStack
{
    private static Dictionary<string, List<string>> graph = 
        new Dictionary<string, List<string>> {
            { "Sofia", new List<string>() {
                "Plovdiv", "Varna", "Bourgas", "Pleven", "Stara Zagora" } },
            { "Plovdiv", new List<string>() {
                "Bourgas", "Ruse" } },
            { "Varna", new List<string>() {
                "Ruse", "Stara Zagora" } },
            { "Bourgas", new List<string>() {
                "Plovdiv", "Pleven" } },
            { "Ruse", new List<string>() {
                "Varna", "Plovdiv" } },
            { "Pleven", new List<string>() {
                "Bourgas", "Stara Zagora" } },
            { "Stara Zagora", new List<string>() {
                "Varna", "Pleven" } },
        };

    private static HashSet<string> visited;

    public static void Main()
    {
        visited = new HashSet<string>();
        DFS("Bourgas");
    }

    public static void DFS(string node)
    {
        var nodes = new Stack<string>();

        // Push the initial node to the stack
        nodes.Push(node);
        visited.Add(node);

        // Iterative Depth-First Search (DFS) with stack
        while (nodes.Count != 0)
        {
            string currentNode = nodes.Pop();
            Console.WriteLine(currentNode);

            var childNodes = graph[currentNode];
            foreach (var childNode in childNodes)
            {
                if (!visited.Contains(childNode))
                {
                    nodes.Push(childNode);
                    visited.Add(childNode);
                }
            }
        }
    }
}
