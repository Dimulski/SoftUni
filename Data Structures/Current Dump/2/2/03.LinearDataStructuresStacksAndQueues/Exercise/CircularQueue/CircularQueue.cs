using System;

public class CircularQueue<T>
{
    private const int InitialCapacity = 16;

    private T[] elements;
    private int startIndex = 0;
    private int endIndex = 0;

    public CircularQueue(int capacity = InitialCapacity)
    {
        this.elements = new T[capacity];
    }

    public int Count { get; private set; }

    public void Enqueue(T element)
    {
        if (this.Count >= this.elements.Length)
        {
            this.Grow();
        }

        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.Length;
        this.Count++;
    }

    public T Dequeue()
    {
        if (this.Count == 0)
        {
            throw new InvalidOperationException("The queue is empty!");
        }

        var result = this.elements[this.startIndex];
        this.elements[this.startIndex] = default(T);
        this.startIndex = (this.startIndex + 1) % this.elements.Length;

        this.Count--;

        return result;
    }

    public T[] ToArray()
    {
        var array = new T[this.Count];
        for (int i = 0; i < this.Count; i++)
        {
            int sourceIndex = (i + this.startIndex) % this.elements.Length;
            array[i] = this.elements[sourceIndex];
        }

        return array;
    }

    private void Grow()
    {
        var newArr = new T[this.elements.Length * 2];
        this.CopyAllElementsTo(newArr);
        this.startIndex = 0;
        this.endIndex = this.Count;
        this.elements = newArr;
    }

    private void CopyAllElementsTo(T[] array)
    {
        for (int i = 0; i < this.Count; i++)
        {
            int sourceIndex = (i + this.startIndex) % this.elements.Length;
            array[i] = this.elements[sourceIndex];
        }
    }
}

class Example
{
    static void Main()
    {
        var queue = new CircularQueue<int>();

        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(4);
        queue.Enqueue(5);
        queue.Enqueue(6);

        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");

        var first = queue.Dequeue();
        Console.WriteLine("First = {0}", first);
        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");

        queue.Enqueue(-7);
        queue.Enqueue(-8);
        queue.Enqueue(-9);
        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");

        first = queue.Dequeue();
        Console.WriteLine("First = {0}", first);
        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");

        queue.Enqueue(-10);
        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");

        first = queue.Dequeue();
        Console.WriteLine("First = {0}", first);
        Console.WriteLine("Count = {0}", queue.Count);
        Console.WriteLine(string.Join(", ", queue.ToArray()));
        Console.WriteLine("---------------------------");
    }
}
