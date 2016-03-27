namespace _03.ImplementAnArrayBasedStack
{
    using System;

    public class ArrayStack<T>
    {
        private const int InitialCapacity = 16;

        private T[] elements;

        public ArrayStack(int capacity = InitialCapacity)
        {
            this.elements = new T[capacity];
        }

        public int Capacity
        {
            get
            {
                return this.elements.Length;
            }
        }

        public int Count { get; private set; }

        public void Push(T element)
        {
            if (this.Count >= this.Capacity)
            {
                this.Grow();
            }

            this.elements[this.Count] = element;
            this.Count++;
        }

        public T Pop()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The stack is empty!");
            }

            this.Count--;
            var element = this.elements[this.Count];
            this.elements[this.Count] = default(T);

            return element;
        }

        public T[] ToArray()
        {
            var array = new T[this.Count];
            for (int i = 0; i < this.Count; i++)
            {
                array[i] = this.elements[this.Count - 1 - i];
            }

            return array;
        }

        private void Grow()
        {
            var newArr = new T[2 * this.Capacity];
            for (int i = 0; i < this.Count; i++)
            {
                newArr[i] = this.elements[i];
            }

            this.elements = newArr;
        }
    }
}
