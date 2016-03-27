namespace _01.AVLTree
{
    public class Node<T>
    {
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value)
        {
            this.Value = value;
            this.BalanceFactor = 0;
        }

        public T Value { get; set; }

        public int BalanceFactor { get; set; }

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
                if (this.LeftChild != null && this.RightChild != null)
                {
                    return 2;
                }
                else if (this.LeftChild != null || this.RightChild != null)
                {
                    return 1;
                }

                return 0;
            }
        }

        public override string ToString()
        {
            return this.Value.ToString();
        }
    }
}

