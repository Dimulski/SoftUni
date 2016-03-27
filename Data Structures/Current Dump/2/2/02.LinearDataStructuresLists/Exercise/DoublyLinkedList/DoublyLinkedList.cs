using System;
using System.Collections;
using System.Collections.Generic;

public class DoublyLinkedList<T> : IEnumerable<T>
{
    private class ListNode<T>
    {
        public ListNode(T value)
        {
            this.Value = value;
        }

        public T Value { get; private set; }

        public ListNode<T> NextNode { get; set; }

        public ListNode<T> PreviousNode { get; set; }
    }

    private ListNode<T> head;
    private ListNode<T> tail; 

    public int Count { get; private set; }

    public void AddFirst(T element)
    {
        if (this.Count == 0)
        {
            this.head = this.tail = new ListNode<T>(element);
        }
        else
        {
            var newHead = new ListNode<T>(element);
            newHead.NextNode = this.head;
            this.head.PreviousNode = newHead;
            this.head = newHead;
        }

        this.Count++;
    }

    public void AddLast(T element)
    {
        if (this.Count == 0)
        {
            this.head = this.tail = new ListNode<T>(element);
        }
        else
        {
            var newTail = new ListNode<T>(element);
            this.tail.NextNode = newTail;
            newTail.PreviousNode = this.tail;
            this.tail = newTail;
        }

        this.Count++;
    }

    public T RemoveFirst()
    {
        ListNode<T> removedNode = null;

        if (this.Count == 0)
        {
            throw new InvalidOperationException("List empty");
        }
        else if (this.Count == 1)
        {
            removedNode = this.head;
            this.head = this.tail = null;
        }
        else
        {
            removedNode = this.head;
            this.head = this.head.NextNode;
        }

        this.Count--;

        return removedNode.Value;
    }

    public T RemoveLast()
    {
        if (this.Count == 0)
        {
            throw new InvalidOperationException("List empty");
        }

        var lastElement = this.tail.Value;
        this.tail = this.tail.PreviousNode;

        if (this.tail != null)
        {
            this.tail.NextNode = null;
        }
        else
        {
            this.head = null;
        }

        this.Count--;
        return lastElement;
    }

    public void ForEach(Action<T> action)
    {
        var currNode = this.head;
        while (currNode != null)
        {
            action(currNode.Value);
            currNode = currNode.NextNode;
        }
    }

    public IEnumerator<T> GetEnumerator()
    {
        var currNode = this.head;
        while (currNode != null)
        {
            yield return currNode.Value;
            currNode = currNode.NextNode;
        }
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return this.GetEnumerator();
    }

    public T[] ToArray()
    {
        var array = new T[this.Count];

        var currNode = this.head;
        for (int i = 0; i < this.Count; i++)
        {
            array[i] = currNode.Value;
            currNode = currNode.NextNode;
        }

        return array;
    }
}


class Example
{
    static void Main()
    {
        var list = new DoublyLinkedList<int>();

        list.ForEach(Console.WriteLine);
        Console.WriteLine("--------------------");

        list.AddLast(5);
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddLast(10);
        Console.WriteLine("Count = {0}", list.Count);

        list.ForEach(Console.WriteLine);
        Console.WriteLine("--------------------");

        list.RemoveFirst();
        list.RemoveLast();
        list.RemoveFirst();

        list.ForEach(Console.WriteLine);
        Console.WriteLine("--------------------");

        list.RemoveLast();

        list.ForEach(Console.WriteLine);
        Console.WriteLine("--------------------");
    }
}
