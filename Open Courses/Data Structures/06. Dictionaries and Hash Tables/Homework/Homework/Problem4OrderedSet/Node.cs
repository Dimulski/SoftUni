namespace Problem4OrderedSet
{
    using System;

    public class Node : ICloneable
    {
        private IComparable value;

        private Node left, right;

        public Node()
            : this(null)
        {
        }

        public Node(IComparable value)
            : this(value, null, null)
        {
        }

        public Node(IComparable value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public IComparable Value
        {
            get { return this.value; }
            set { this.value = value; }
        }

        public Node Left
        {
            get { return this.left; }
            set { this.left = value; }
        }

        public Node Right
        {
            get { return this.right; }
            set { this.right = value; }
        }

        public object Clone()
        {
            Node clone = new Node();
            if (this.value is ICloneable)
            {
                clone.Value = (IComparable)((ICloneable)this.value).Clone();
            }
            else
            {
                clone.Value = this.value;
            }

            if (this.left != null)
            {
                clone.Left = (Node)this.left.Clone();
            }

            if (this.right != null)
            {
                clone.Right = (Node)this.right.Clone();
            }

            return clone;
        }
    }
}
