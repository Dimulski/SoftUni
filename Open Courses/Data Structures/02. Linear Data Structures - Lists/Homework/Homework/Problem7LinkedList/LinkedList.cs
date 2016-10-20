namespace Problem7LinkedList
{
    using System.Collections;
    using System.Collections.Generic;

    class LinkedList<T> : IEnumerable<T>
    {
        private class ListNode<T>
        {
            public ListNode(T value)
            {
                this.Value = value;
            }

            public T Value { get; set; }

            public ListNode<T> NextNode { get; set; }
        }

        private ListNode<T> head;
        private ListNode<T> current;

        public int Count { get; set; }

        public void Add(T item)
        {
            var newNode = new ListNode<T>(item);

            if (this.head == null)
            {
                this.head = this.current = newNode;
            }
            else
            {
                this.current.NextNode = newNode;
            }

            this.current = newNode;

            this.Count++;
        }

        public void Remove(int index)
        {
            var currentNode = this.head;

            if (index == 0)
            {
                this.head = currentNode.NextNode;
            }
            else
            {
                for (int i = 0; i < index - 1; i++)
                {
                    currentNode = currentNode.NextNode;
                }

                currentNode.NextNode = currentNode.NextNode.NextNode;
            }

            this.Count--;
        }

        public int FirstIndexOf(T item)
        {
            var currentNode = this.head;

            for (int i = 0; i < this.Count; i++)
            {
                if (currentNode.Value.Equals(item))
                {
                    return i;
                }

                currentNode = currentNode.NextNode;
            }

            return -1;
        }

        public int LastIndexOf(T item)
        {
            var currentNode = this.head;
            int lastIndex = -1;

            for (int i = 0; i < this.Count; i++)
            {
                if (currentNode.Value.Equals(item))
                {
                    lastIndex = i;
                }

                currentNode = currentNode.NextNode;
            }

            return lastIndex;
        }

        public IEnumerator<T> GetEnumerator()
        {
            var currentNode = this.head;

            while (currentNode != null)
            {
                yield return currentNode.Value;

                currentNode = currentNode.NextNode;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
