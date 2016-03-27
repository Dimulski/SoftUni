namespace _05.LinkedStack
{
    using System;

    public class LinkedStack<T>
    {
        private Node<T> head;

        public int Count { get; private set; }

        public void Push(T element)
        {
            this.head = new Node<T>(element, this.head);

            this.Count++;
        }

        public T Pop()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The stack is empty!");
            }

            var element = this.head.Value;
            this.head = this.head.Next;
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
