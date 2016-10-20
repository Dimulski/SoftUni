namespace Problem6ReversedList
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    class ReversedListMain
    {
        public class ReversedList<T> : IEnumerable<T>
        {
            private const int DefaultCapacity = 4;

            private T[] elements;

            public ReversedList(int capacity = DefaultCapacity)
            {
                this.elements = new T[capacity];
            }

            public int Count { get; private set; }

            public int Capacity
            {
                get
                {
                    return this.elements.Length;
                }
            }

            public T this[int index]
            {
                get
                {
                    return this.elements[this.Count - 1 - index];
                }
            }

            public void Add(T item)
            {
                if (this.Count >= this.Capacity)
                {
                    Array.Resize(ref this.elements, this.elements.Length * 2);
                }

                this.elements[this.Count] = item;
                this.Count++;
            }

            public void Remove(int index)
            {
                var newElements = new T[this.Capacity];

                for (int i = 0; i < this.Count - 1 - index; i++)
                {
                    newElements[i] = this.elements[i];
                }

                for (int i = this.Count - 1 - index; i < this.Count - 1; i++)
                {
                    newElements[i] = this.elements[i + 1];
                }

                this.elements = newElements;
                this.Count--;
            }

            public IEnumerator<T> GetEnumerator()
            {
                for (int i = this.Count - 1; i >= 0; i--)
                {
                    yield return this.elements[i];
                }
            }

            IEnumerator IEnumerable.GetEnumerator()
            {
                return this.GetEnumerator();
            }

        }

        static void Main()
        {
            var reversedList = new ReversedList<int>();

            reversedList.Add(0);
            reversedList.Add(1);

            Console.WriteLine("Number of elements: {0}", reversedList.Count);

            reversedList.Add(2);
            reversedList.Add(3);

            Console.WriteLine("Capacity before resizing: {0}", reversedList.Capacity);

            reversedList.Add(4);

            Console.WriteLine("Capacity after adding and resizing: {0}", reversedList.Capacity);

            Console.WriteLine("Iterating:");

            foreach (var element in reversedList)
            {
                Console.WriteLine(element);
            }

            reversedList.Remove(3);

            Console.WriteLine("Count after removing: {0}", reversedList.Count);

            Console.WriteLine("Iterating:");

            foreach (var element in reversedList)
            {
                Console.WriteLine(element);
            }
        }
    }
}
