namespace _01.ImplementBinaryHeap
{
    using System;
    using System.Collections.Generic;

    public class BinaryHeap<T> where T : IComparable<T>
    {
        private List<T> heap;

        public BinaryHeap()
        {
            this.heap = new List<T>();
        }

        public BinaryHeap(T[] elements)
        {
            this.heap = new List<T>(elements);
            for (int i = this.heap.Count / 2; i >= 0; i--)
            {
                this.HeapifyDown(i);
            }
        }

        public int Count
        {
            get
            {
                return this.heap.Count;
            }
        }

        public void Insert(T node)
        {
            this.heap.Add(node);
            this.HeapifyUp(this.Count - 1);
        }

        public T ExtractMax()
        {
            T max = this.heap[0];
            this.heap[0] = this.heap[this.Count - 1];
            this.heap.RemoveAt(this.Count - 1);
            if (this.Count > 0)
            {
                this.HeapifyDown(0);
            }

            return max;
        }

        public T PeekMax()
        {
            T max = this.heap[0];

            return max;
        }

        private void HeapifyDown(int index)
        {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            var largest = index;
            if (left < this.Count && this.heap[left].CompareTo(this.heap[largest]) > 0)
            {
                largest = left;
            }

            if (right < this.Count && this.heap[right].CompareTo(this.heap[largest]) > 0)
            {
                largest = right;
            }

            if (largest != index)
            {
                T oldValue = this.heap[index];
                this.heap[index] = this.heap[largest];
                this.heap[largest] = oldValue;
                this.HeapifyDown(largest);
            }
        }

        private void HeapifyUp(int index)
        {
            int parent = (index - 1) / 2;
            while (index > 0 && this.heap[index].CompareTo(this.heap[parent]) > 0)
            {
                T old = this.heap[index];
                this.heap[index] = this.heap[parent];
                this.heap[parent] = old;

                index = parent;
                parent = (index - 1) / 2;
            }
        }
    }
}