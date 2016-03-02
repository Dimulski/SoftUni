namespace Problem3ArrayBasedStack
{
    using System;
    using System.Linq;

    public class ArrayStack<T>
    {
        private const int InitialCapacity = 16;
        private T[] elements;

        public ArrayStack(int capacity = InitialCapacity)
        {
            this.elements = new T[capacity];
        }

        public int Count { get; private set; }
        
        public void Push(T element)
        {
            if (this.Count >= this.elements.Length)
            {
                this.Resize();
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

            var result = this.elements[this.Count - 1];
            this.Count--;
            return result;
        }
        
        public T[] ToArray()
        {
            T[] result = new T[this.Count];

            int resultIndex = 0;
            for (int index = this.Count - 1; index >= 0; index--)
            {
                result[resultIndex] = this.elements[index];
                resultIndex++;
            }

            return result;
        }

        private void Resize()
        {
            var newElements = new T[this.elements.Length * 2];
            this.CopyAllElementsTo(newElements);
            this.elements = newElements;
        }

        private void CopyAllElementsTo(T[] resultArray)
        {
            for (int i = 0; i < this.Count; i++)
            {
                resultArray[i] = this.elements[i];
            }
        }
    }
}
