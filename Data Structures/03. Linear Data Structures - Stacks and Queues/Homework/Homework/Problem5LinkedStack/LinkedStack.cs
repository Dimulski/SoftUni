namespace Problem5LinkedStack
{
    using System;

    public class LinkedStack<T>
    {
        private Node<T> firstNode;

        public int Count { get; private set; }

        public void Push(T element)
        {
            if(this.firstNode == null)
            {
                this.firstNode = new Node<T>(element);
            }
            else
            {
                this.firstNode = new Node<T>(element, this.firstNode);
            }

            this.Count++;
        }

        public T Pop()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The stack is empty!");
            }
            else
            {
                var result = this.firstNode.Value;
                this.firstNode = this.firstNode.NextNode;
                this.Count--;
                return result;
            }
        }

        public T[] ToArray()
        {
            var resultArray = new T[this.Count];
            var currentNode = this.firstNode;
            int counter = 0;

            while (currentNode != null)
            {
                resultArray[counter] = currentNode.Value;
                counter++;
                currentNode = currentNode.NextNode;
            }
            return resultArray;
        }
    }
}
