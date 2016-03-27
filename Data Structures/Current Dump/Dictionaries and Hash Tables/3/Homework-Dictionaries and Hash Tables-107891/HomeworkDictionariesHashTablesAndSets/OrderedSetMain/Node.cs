namespace OrderedSetMain
{
    using System;
    using System.Collections.Generic;
    using System.Collections;

    public class Node<T> : IEnumerable<T> where T : IComparable<T>
    {
        public T Value { get; set; }

        public Node<T> Parent { get; set; }

        public Node<T> SmallChild { get; set; }

        public Node<T> BigChild { get; set; }

        public Node(T value)
        {
            this.Value = value;
        }

        public IEnumerator<T> GetEnumerator()
        {
            if (this.SmallChild != null)
            {
                foreach (var v in SmallChild)
                {
                    yield return v;
                }
            }

            yield return Value;

            if (this.BigChild != null)
            {
                foreach (var v in this.BigChild)
                {
                    yield return v;
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
