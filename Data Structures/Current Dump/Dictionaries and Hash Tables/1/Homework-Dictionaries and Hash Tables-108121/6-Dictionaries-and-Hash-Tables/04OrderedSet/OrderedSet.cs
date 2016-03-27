namespace _04OrderedSet
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    public class OrderedSet<T> : IEnumerable<T> where T : IComparable<T>
    {
        private class Node : IEnumerable<T>
        {
            public Node(T value)
            {
                this.Value = value;
            }

            public T Value { get; set; }

            public Node LeftChild { get; set; }

            public Node RightChild { get; set; }

            public IEnumerator<T> GetEnumerator()
            {
                if (this.LeftChild != null)
                {
                    foreach (var child in this.LeftChild)
                    {
                        yield return child;
                    }
                }

                yield return this.Value;

                if (this.RightChild != null)
                {
                    foreach (var child in this.RightChild)
                    {
                        yield return child;
                    }
                }
            }

            IEnumerator IEnumerable.GetEnumerator()
            {
                return GetEnumerator();
            }
        }

        private Node root;

        public int Count { get; set; }

        public bool Contains(T value)
        {
            var currNode = this.root;
            while (currNode != null)
            {
                if (currNode.Value.Equals(value))
                {
                    return true;
                }

                if (value.CompareTo(currNode.Value) < 0)
                {
                    currNode = currNode.LeftChild;
                }
                else
                {
                    currNode = currNode.RightChild;
                }
            }

            return false;
        }

        public void Add(T value)
        {
            if (this.root == null)
            {
                this.root = new Node(value);
                return;
            }

            if (!this.Contains(value))
            {
                var newNode = new Node(value);
                this.Insert(newNode);
            }
        }

        private void Insert(Node node)
        {
            if (node != null)
            {
                var currNode = this.root;
                Node parent = null;
                bool isInLeft = false;
                while (true)
                {
                    if (currNode == null)
                    {
                        var insertedNode = isInLeft ? parent.LeftChild = node : parent.RightChild = node;
                        this.Count++;
                        break;
                    }

                    parent = currNode;
                    if (node.Value.CompareTo(currNode.Value) < 0)
                    {
                        currNode = currNode.LeftChild;
                        isInLeft = true;
                    }
                    else
                    {
                        currNode = currNode.RightChild;
                        isInLeft = false;
                    }
                }
            }
        }

        public void Remove(T value)
        {
            var currNode = this.root;
            Node parent = null;
            bool isInLeft = false;
            while (currNode != null)
            {
                if (currNode.Value.Equals(value))
                {
                    var leftCuld = currNode.LeftChild;
                    var rightChild = currNode.RightChild;
                    if (parent != null)
                    {
                        var node = isInLeft ? parent.LeftChild = null : parent.RightChild = null;        
                        this.Insert(leftCuld);            
                    }
                    else
                    {
                        this.root = leftCuld;
                    }

                    this.Insert(rightChild);
                    this.Count--;
                    break;
                }

                parent = currNode;
                if (value.CompareTo(currNode.Value) < 0)
                {
                    currNode = currNode.LeftChild;
                    isInLeft = true;
                }
                else
                {
                    currNode = currNode.RightChild;
                    isInLeft = false;
                }
            }
        }


        public IEnumerator<T> GetEnumerator()
        {
            return this.root.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
