namespace _04.OrderedSet
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    public class OrderedSet<T> : IEnumerable<T> 
        where T : IComparable
    {
        private Node<T> root;

        public int Count { get; private set; }

        public void Add(T element)
        {
            if (this.root == null)
            {
                this.root = new Node<T>(element);
            }
            else
            {
                var currNode = this.root;
                while (true)
                {
                    int result = currNode.Value.CompareTo(element);
                    if (result == 0)
                    {
                        return;
                    }
                    else if (result < 0)
                    {
                        if (currNode.RightChild == null)
                        {
                            currNode.RightChild = new Node<T>(element, currNode);
                            this.Count++;
                            return;
                        }

                        currNode = currNode.RightChild;
                    }
                    else if (result > 0)
                    {
                        if (currNode.LeftChild == null)
                        {
                            currNode.LeftChild = new Node<T>(element, currNode);
                            this.Count++;
                            return;
                        }

                        currNode = currNode.LeftChild;
                    }
                }
            }
        }

        public bool Contains(T element)
        {
            var currNode = this.root;
            while (currNode != null)
            {
                int result = currNode.Value.CompareTo(element);
                if (result == 0)
                {
                    return true;
                }
                else if (result < 0)
                {
                    currNode = currNode.RightChild;
                }
                else if (result > 0)
                {
                    currNode = currNode.LeftChild;
                }
            }

            return false;
        }

        public void Remove(T element)
        {
            var nodeToRemove = this.GetNode(element);
            if (nodeToRemove == null)
            {
                throw new ArgumentException("Element is not contained!");
            }

            if (nodeToRemove.ChildrenCount == 0)
            {
                if (nodeToRemove.IsLeftChild)
                {
                    nodeToRemove.Parent.LeftChild = null;
                }
                else
                {
                    nodeToRemove.Parent.RightChild = null;
                }
            }
            else if (nodeToRemove.ChildrenCount == 1)
            {
                if (nodeToRemove.IsLeftChild)
                {
                    if (nodeToRemove.LeftChild != null)
                    {
                        nodeToRemove.Parent.LeftChild = nodeToRemove.LeftChild;
                    }
                    else
                    {
                        nodeToRemove.Parent.LeftChild = nodeToRemove.RightChild;
                    }
                }
                else
                {
                    if (nodeToRemove.LeftChild != null)
                    {
                        nodeToRemove.Parent.RightChild = nodeToRemove.LeftChild;
                    }
                    else
                    {
                        nodeToRemove.Parent.RightChild = nodeToRemove.RightChild;
                    }
                }
            }
            else
            {
                var noLeftChildNode = this.GetNodeWithNoLeftChild(nodeToRemove.RightChild);
                noLeftChildNode.LeftChild = nodeToRemove.LeftChild;
                if (nodeToRemove.IsLeftChild)
                {
                    nodeToRemove.Parent.LeftChild = nodeToRemove.RightChild;
                }
                else
                {
                    nodeToRemove.Parent.RightChild = nodeToRemove.RightChild;
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

        private Node<T> GetNode(T element)
        {
            var currNode = this.root;
            while (currNode != null)
            {
                if (currNode.Value.Equals(element))
                {
                    return currNode;
                }
                else if (currNode.Value.CompareTo(element) > 0)
                {
                    currNode = currNode.LeftChild;
                }
                else if (currNode.Value.CompareTo(element) < 0)
                {
                    currNode = currNode.RightChild;
                }
            }

            return null;
        }

        private Node<T> GetNodeWithNoLeftChild(Node<T> startNode)
        {
            if (startNode.LeftChild == null)
            {
                return startNode.LeftChild;
            }

            return this.GetNodeWithNoLeftChild(startNode.LeftChild);
        }
    }
}
