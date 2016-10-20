namespace Problem7LinkedQueue
{
    using System;

    public class LinkedQueue<T>
    {
        private Node<T> head;

        private Node<T> tail;

        public int Count { get; private set; }

        public void Enqueue(T element)
        {
            if (this.Count == 0)
            {
                this.head = this.tail = new Node<T>(element);
            }
            else
            {
                var newHead = new Node<T>(element);
                newHead.NextNode = this.head;
                this.head.PreviousNode = newHead;
                this.head = newHead;
            }
            this.Count++;
        }

        public T Dequeue()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The LinkedQueue is empty!");
            }
            if (this.Count == 1)
            {
                var lastElement = this.tail.Value;

                this.head = this.tail = null;
                this.Count--;

                return lastElement;
            }
            else
            {
                var lastElement = this.tail.Value;
                this.tail.PreviousNode.NextNode = null;
                this.tail = this.tail.PreviousNode;
                this.Count--;

                return lastElement;
            }
        }

        public T[] ToArray()
        {
            var resultArray = new T[this.Count];
            var currentElement = this.head;

            int counter = this.Count - 1;
            while (currentElement != null)
            {
                resultArray[counter] = currentElement.Value;
                counter--;
                currentElement = currentElement.NextNode;
            }
            
            return resultArray;
        }
    }
}
