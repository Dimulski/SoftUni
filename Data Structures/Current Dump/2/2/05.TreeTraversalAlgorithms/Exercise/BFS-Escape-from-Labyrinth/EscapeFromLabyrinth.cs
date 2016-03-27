using System;
using System.Collections.Generic;
using Escape_from_Labyrinth;

public class EscapeFromLabyrinth
{
    private const char VisitedCell = 's';

    private static int width;
    private static int height;
    private static char[,] labyrinth;

    public static void Main()
    {
        ReadLabyrinth();
        string shortestPathToExit = FindShortestPathToExit();
        if (shortestPathToExit == null)
        {
            Console.WriteLine("No exit!");
        }
        else if (shortestPathToExit == string.Empty)
        {
            Console.WriteLine("Start is at the exit.");
        }
        else
        {
            Console.WriteLine("Shortest exit: " + shortestPathToExit);
        }
    }

    private static string FindShortestPathToExit()
    {
        var queue = new Queue<Point>();
        var startPoint = FindStartPoint();
        if (startPoint == null)
        {
            return null;
        }

        queue.Enqueue(startPoint);
        while (queue.Count > 0)
        {
            var currPoint = queue.Dequeue();
            if (IsExit(currPoint))
            {
                return TracePathBack(currPoint);
            }

            TryDirection(queue, currPoint, "U", 0, -1);
            TryDirection(queue, currPoint, "D", 0, 1);
            TryDirection(queue, currPoint, "R", 1, 0);
            TryDirection(queue, currPoint, "L", -1, 0);
        }

        return null;
    }

    private static string TracePathBack(Point exitPoint)
    {
        string path = string.Empty;
        var currPoint = exitPoint;
        while (currPoint != null)
        {
            path = currPoint.Direction + path;
            currPoint = currPoint.Previous;
        }

        return path;
    }

    private static void TryDirection(Queue<Point> queue, Point currPoint, string direction, int deltaX, int deltaY)
    {
        int newX = currPoint.X + deltaX;
        int newY = currPoint.Y + deltaY;
        bool isNewXInRange = newX >= 0 && newX < width;
        bool isNewYInRange = newY >= 0 && newY < height;
        if (isNewXInRange && isNewYInRange && labyrinth[newY, newX] == '-')
        {
            labyrinth[newY, newX] = VisitedCell;
             var newPoint = new Point()
             {
                 X = newX,
                 Y = newY,
                 Direction = direction,
                 Previous = currPoint
             };

             queue.Enqueue(newPoint);
        }
    }

    private static bool IsExit(Point point)
    {
        bool isOnBorderX = point.X == 0 || point.X == width - 1;
        bool isOnBorderY = point.Y == 0 || point.Y == height - 1;

        return isOnBorderY || isOnBorderX;
    }

    private static Point FindStartPoint()
    {
        for (int row = 0; row < labyrinth.GetLength(0); row++)
        {
            for (int col = 0; col < labyrinth.GetLength(1); col++)
            {
                if (labyrinth[row, col] == VisitedCell)
                {
                    return new Point() { X = col, Y = row };
                }
            }
        }

        return null;
    }

    private static void ReadLabyrinth()
    {
        int inputWidth = int.Parse(Console.ReadLine());
        int inputHeight = int.Parse(Console.ReadLine());
        char[,] inputlabyrinth = new char[inputHeight, inputWidth];
        for (int row = 0; row < inputHeight; row++)
        {
            string inputRow = Console.ReadLine();
            for (int col = 0; col < inputWidth; col++)
            {
                inputlabyrinth[row, col] = inputRow[col];
            }
        }

        width = inputWidth;
        height = inputHeight;
        labyrinth = inputlabyrinth;
    }
}
