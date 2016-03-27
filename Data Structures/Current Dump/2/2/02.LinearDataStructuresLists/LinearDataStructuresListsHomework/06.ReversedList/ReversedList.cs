namespace _06.ReversedList
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    public class ReversedList<T> : IEnumerable<T>
    {
        private T[] array;

        public ReversedList(uint capacity = 16)
        {
            this.array = new T[capacity];
        }

        public int Count { get; private set; }

        public int Capacity
        {
            get
            {
                return this.array.Length;
            }
        }

        public T this[int index]
        {
            get 
            {
                this.CheckIfIndexIsInRange(index);
                return this.array[this.Count - 1 - index];
            }
        }

        public void Add(T item)
        {
            if (this.Count == this.Capacity)
            {
                this.Resize();
            }

            this.array[this.Count] = item;
            this.Count++;
        }

        public T Remove(int index)
        {
            this.CheckIfIndexIsInRange(index);

            int normalIndex = this.Count - 1 - index;
            T removedElement = this.array[normalIndex];

            for (int i = normalIndex; i < this.Count - 1; i++)
            {
                this.array[i] = this.array[i + 1];
            }

            this.Count--;
            return removedElement;
        }

        public IEnumerator<T> GetEnumerator()
        {
            for (int i = this.Count - 1; i >= 0; i--)
            {
                yield return this.array[i];
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }

        private void Resize()
        {
            var newArray = new T[this.Capacity * 2];
            for (int i = 0; i < this.Count; i++)
            {
                newArray[i] = this.array[i];
            }

            this.array = newArray;
        }

        private void CheckIfIndexIsInRange(int index)
        {
            if (index < 0 || index >= this.Count)
            {
                throw new IndexOutOfRangeException();
            }
        }
    }
}
