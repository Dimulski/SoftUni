namespace _07.LinkedQueue
{
    using System;

    public class LinkedQueue<T>
    {
        private QueueNode<T> head;
        private QueueNode<T> tail;

        public int Count { get; set; }

        public void Enqueue(T element)
        {
            var newNode = new QueueNode<T>(element);
            if (this.Count == 0)
            {
                this.head = newNode;
                this.tail = newNode;
            }
            else
            {
                this.tail.Next = newNode;
                newNode.Previous = this.tail;
                this.tail = newNode;
            }

            this.Count++;
        }

        public T Dequeue()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The queue is empty!");
            }

            var element = this.head.Value;
            this.head = this.head.Next;
            if (this.head == null)
            {
                this.tail = null;
            }
            else
            {
                this.head.Previous = null;
            } 

            this.Count--;

            return element;
        }

        public T[] ToArray()
        {
            var array = new T[this.Count];
            var currNode = this.head;
            for (int i = 0; i < this.Count; i++)
            {
                array[i] = currNode.Value;
                currNode = currNode.Next;
            }

            return array;
        }
    }
}
