namespace _04.OrderedSet
{
    using System.Collections;
    using System.Collections.Generic;

    public class Node<T> : IEnumerable<T>
    {
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value, Node<T> parent = null)
        {
            this.Value = value;
            this.Parent = null;
        }

        public T Value { get; set; }

        public Node<T> Parent { get; set; }

        public Node<T> LeftChild
        {
            get
            {
                return this.leftChild;
            }

            set
            {
                if (value != null)
                {
                    value.Parent = this;
                }

                this.leftChild = value;
            }
        }

        public Node<T> RightChild
        {
            get
            {
                return this.rightChild;
            }

            set
            {
                if (value != null)
                {
                    value.Parent = this;
                }

                this.rightChild = value;
            }
        }

        public bool IsLeftChild
        {
            get
            {
                return this.Parent != null && this.Parent.LeftChild != null && this.Parent.LeftChild.Equals(this);
            }
        }

        public bool IsRightChild
        {
            get
            {
                return this.Parent != null && this.Parent.RightChild != null && this.Parent.RightChild.Equals(this);
            }
        }

        public int ChildrenCount
        {
            get
            {
                int count = 0;
                if (this.LeftChild != null)
                {
                    count++;
                }

                if (this.RightChild != null)
                {
                    count++;
                }

                return count;
            }
        }

        public IEnumerator<T> GetEnumerator()
        {
            if (this.LeftChild != null)
            {
                foreach (var node in this.LeftChild)
                {
                    yield return node;
                }
            }

            yield return this.Value;

            if (this.RightChild != null)
            {
                foreach (var node in this.RightChild)
                {
                    yield return node;
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
