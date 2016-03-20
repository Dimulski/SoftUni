namespace Problem4OrderedSet
{
    using System;
    using System.Collections;
    using System.Text;

    public class BinarySearchTree : ICloneable, IEnumerable
    {
        private Node root = null;

        private int count = 0;

        public BinarySearchTree()
        {
        }

        public int Count
        {
            get
            {
                return this.count;
            }

            set
            {
                this.count = value;
            }
        }

        public virtual void Add(IComparable value)
        {
            Node n = new Node(value);
            int result;

            Node current = this.root;
            Node parent = null;

            while (current != null)
            {
                result = current.Value.CompareTo(n.Value);
                if (result == 0)
                {
                    return;
                }
                else if (result > 0)
                {
                    parent = current;
                    current = current.Left;
                }
                else if (result < 0)
                {
                    parent = current;
                    current = current.Right;
                }
            }

            this.Count++;

            if (parent == null)
            {
                this.root = n;
            }
            else
            {
                result = parent.Value.CompareTo(n.Value);
                if (result > 0)
                {
                    parent.Left = n;
                }
                else if (result < 0)
                {
                    parent.Right = n;
                }
            }
        }

        public virtual bool Contains(IComparable value)
        {
            return this.Search(value) != null;
        }

        public virtual Node Search(IComparable value)
        {
            return this.SearchHelper(this.root, value);
        }

        public void Delete(IComparable value)
        {
            Node current = this.root;
            Node parent = null;
            int result = current.Value.CompareTo(value);
            while (result != 0 && current != null)
            {
                if (result > 0)
                {
                    parent = current;
                    current = current.Left;
                }
                else if (result < 0)
                {
                    parent = current;
                    current = current.Right;
                }

                result = current.Value.CompareTo(value);
            }

            if (current == null)
            {
                throw new Exception("Item to be deleted does not exist in the BST.");
            }
            
            this.Count--;

            // CASE 1: If current has no right child, then current's left child becomes the
            // node pointed to by the parent
            if (current.Right == null)
            {
                if (parent == null)
                {
                    this.root = current.Left;
                }
                else
                {
                    result = parent.Value.CompareTo(current.Value);
                    if (result > 0)
                    {
                        parent.Left = current.Left;
                    }
                    else if (result < 0)
                    {
                        parent.Right = current.Left;
                    }
                }
            }

            // CASE 2: If current's right child has no left child, then current's right child replaces
            // current in the tree
            else if (current.Right.Left == null)
            {
                if (parent == null)
                {
                    this.root = current.Right;
                }
                else
                {
                    result = parent.Value.CompareTo(current.Value);
                    if (result > 0)
                    {
                        parent.Left = current.Right;
                    }
                    else if (result < 0)
                    {
                        parent.Right = current.Right;
                    }
                }
            }

            // right child's left-most node.
            // CASE 3: If current's right child has a left child, replace current with current's
            else
            {
                // we need to find the right node's left-most child
                Node leftmost = current.Right.Left;
                Node leftmostParent = current.Right;

                while (leftmost.Left != null)
                {
                    leftmostParent = leftmost;
                    leftmost = leftmost.Left;
                }

                // the parent's left subtree becomes the leftmost's right subtree
                leftmostParent.Left = leftmost.Right;

                // assign leftmost's left and right to current's left and right
                leftmost.Left = current.Left;
                leftmost.Right = current.Right;

                if (parent == null)
                {
                    this.root = leftmost;
                }
                else
                {
                    result = parent.Value.CompareTo(current.Value);
                    if (result > 0)
                    {
                        parent.Left = leftmost;
                    }
                    else if (result < 0)
                    {
                        parent.Right = leftmost;
                    }
                }
            }
        }

        public override string ToString()
        {
            return this.ToString(TraversalMethods.Inorder);
        }

        public virtual string ToString(TraversalMethods traversalMethod)
        {
            return this.ToString(traversalMethod, " ");
        }

        public virtual string ToString(TraversalMethods traversalMethod, string separator)
        {
            string results = string.Empty;
            switch (traversalMethod)
            {
                case TraversalMethods.Preorder:
                    results = this.PreorderTraversal(this.root, separator);
                    break;

                case TraversalMethods.Inorder:
                    results = this.InorderTraversal(this.root, separator);
                    break;

                case TraversalMethods.Postorder:
                    results = this.PostorderTraversal(this.root, separator);
                    break;
            }

            // finally, hack off the last separator
            if (results.Length == 0)
            {
                return string.Empty;
            }
            else
            {
                return results.Substring(0, results.Length - separator.Length);
            }
        }

        public void Clear()
        {
            this.root = null;
            this.count = 0;
        }

        public object Clone()
        {
            BinarySearchTree clone = new BinarySearchTree();
            clone.root = (Node)this.root.Clone();
            clone.count = this.count;

            return clone;
        }

        public IEnumerator GetEnumerator()
        {
            ArrayList contents = new ArrayList(this.count);
            this.InorderTraversalBuildup(this.root, contents);

            return contents.GetEnumerator();
        }

        protected virtual Node SearchHelper(Node current, IComparable data)
        {
            if (current == null)
            {
                return null; // node was not found
            }
            else
            {
                int result = current.Value.CompareTo(data);
                if (result == 0)
                {
                    // they are equal - we found the value
                    return current;
                }
                else if (result > 0)
                {
                    // current.Value > n.Value
                    // therefore, if the value exists it is in current's left subtree
                    return this.SearchHelper(current.Left, data);
                }
                else
                {
                    // result < 0
                    // current.Value < n.Value
                    // therefore, if the value exists it is in current's right subtree
                    return this.SearchHelper(current.Right, data);
                }
            }
        }

        protected virtual string PreorderTraversal(Node current, string separator)
        {
            if (current != null)
            {
                StringBuilder sb = new StringBuilder();
                sb.Append(current.Value.ToString());
                sb.Append(separator);

                sb.Append(this.PreorderTraversal(current.Left, separator));
                sb.Append(this.PreorderTraversal(current.Right, separator));
                return sb.ToString();
            }
            else
            {
                return string.Empty;
            }
        }

        protected virtual string InorderTraversal(Node current, string separator)
        {
            if (current != null)
            {
                StringBuilder sb = new StringBuilder();
                sb.Append(this.InorderTraversal(current.Left, separator));
                sb.Append(current.Value.ToString());
                sb.Append(separator);
                sb.Append(this.InorderTraversal(current.Right, separator));
                return sb.ToString();
            }
            else
            {
                return string.Empty;
            }
        }

        protected virtual string PostorderTraversal(Node current, string separator)
        {
            if (current != null)
            {
                StringBuilder sb = new StringBuilder();
                sb.Append(this.PostorderTraversal(current.Left, separator));
                sb.Append(this.PostorderTraversal(current.Right, separator));

                sb.Append(current.Value.ToString());
                sb.Append(separator);
                return sb.ToString();
            }
            else
            {
                return string.Empty;
            }
        }

        private void InorderTraversalBuildup(Node current, ArrayList contents)
        {
            if (current != null)
            {
                this.InorderTraversalBuildup(current.Left, contents);
                contents.Add(current);
                this.InorderTraversalBuildup(current.Right, contents);
            }
        }
    }
}
