namespace _07.LinkedList
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    public class LinkedList<T> : IEnumerable<T>
    {
        private ListNode<T> head;
        private ListNode<T> tail;

        public int Count { get; private set; }

        private ListNode<T> this[int index]
        {
            get
            {
                if (index < 0 || index >= this.Count)
                {
                    throw new IndexOutOfRangeException();
                }

                int currIndex = 0;
                var currNode = this.head;
                while (currIndex != index)
                {
                    currNode = currNode.NextNode;
                    currIndex++;
                }

                return currNode;
            }
        }

        public void Add(T element)
        {
            if (this.Count == 0)
            {
                this.head = this.tail = new ListNode<T>(element);
            }
            else
            {
                var newNode = new ListNode<T>(element);
                this.tail.NextNode = newNode;
                this.tail = newNode;
            }

            this.Count++;
        }

        public T Remove(int index)
        {
            if (index < 0 || index >= this.Count)
            {
                throw new IndexOutOfRangeException();
            }

            T elementToRemove = this[index].Value;

            if (this.Count == 1)
            {
                this.head = this.tail = null;
            }
            else 
            {
                this[index - 1].NextNode = this[index].NextNode;
            }

            this.Count--;

            return elementToRemove;
        }

        public int FirstIndexOf(T element)
        {
            int index = 0;
            foreach (var item in this)
            {
                if (item.Equals(element))
                {
                    return index;
                }

                index++;
            }

            return -1;
        }

        public int LastIndexOf(T element)
        {
            int index = 0;
            int lastIndex = -1;
            foreach (var item in this)
            {
                if (item.Equals(element))
                {
                    lastIndex = index;
                }

                index++;
            }

            return lastIndex;
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
    }
}
