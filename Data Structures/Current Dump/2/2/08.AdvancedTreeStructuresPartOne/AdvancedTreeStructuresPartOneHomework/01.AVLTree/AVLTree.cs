using System.Runtime.InteropServices;

namespace _01.AVLTree
{
    using System;
    using System.Collections.Generic;

    public class AVLTree<T> where T : IComparable<T>
    {
        private Node<T> root;

        public int Count { get; private set; }

        public void Add(T item)
        {
            bool inserted = true;
            if (this.root == null)
            {
                this.root = new Node<T>(item);
            }
            else
            {
                inserted = this.InsertInternal(this.root, item);
            }

            if (inserted)
            {
                this.Count++;
            }
        }

        public bool Contains(T item)
        {
            var node = this.root;
            while (node != null)
            {
                if (node.Value.CompareTo(item) > 0)
                {
                    node = node.LeftChild;
                }
                else if (node.Value.CompareTo(item) < 0)
                {
                    node = node.RightChild;
                }
                else
                {
                    return true;
                }
            }

            return false;
        }

        public void ForeachDfs(Action<int, T> action)
        {
            if (this.Count == 0)
            {
                return;
            }

            this.InOrderDfs(this.root, 1, action);
        }

        public IEnumerable<T> Range(T from, T to)
        {
            return GetRange(this.root, from, to, new List<T>());
        }

        private IList<T> GetRange(Node<T> node, T from, T to, IList<T> elements)
        {
            if (node.LeftChild != null && 
                node.LeftChild.Value.CompareTo(from) >= 0 && 
                node.LeftChild.Value.CompareTo(to) <= 0)
            {
                this.GetRange(node.LeftChild, from, to, elements);
            }

            if (node.Value.CompareTo(from) >= 0 && node.Value.CompareTo(to) <= 0)
            {
                elements.Add(node.Value);
            }


            if (node.RightChild != null &&
                node.RightChild.Value.CompareTo(from) >= 0 &&
                node.RightChild.Value.CompareTo(to) <= 0)
            {
                this.GetRange(node.RightChild, from, to, elements);
            }

            return elements;
        }

        private void InOrderDfs(Node<T> node, int depth, Action<int, T> action)
        {
            if (node.LeftChild != null)
            {
                this.InOrderDfs(node.LeftChild, depth + 1, action);
            }

            action(depth, node.Value);

            if (node.RightChild != null)
            {
                this.InOrderDfs(node.RightChild, depth + 1, action);
            }
        }

        private bool InsertInternal(Node<T> node, T value)
        {
            var currNode = node;
            var newNode = new Node<T>(value);
            while (true)
            {
                if (currNode.Value.CompareTo(newNode.Value) < 0)
                {
                    if (currNode.RightChild == null)
                    {
                        currNode.RightChild = newNode;
                        currNode.BalanceFactor--;
                        break;
                    }

                    currNode = currNode.RightChild;
                }
                else if (currNode.Value.CompareTo(newNode.Value) > 0)
                {
                    if (currNode.LeftChild == null)
                    {
                        currNode.LeftChild = newNode;
                        currNode.BalanceFactor++;
                        break;
                    }

                    currNode = currNode.LeftChild;
                }
                else
                {
                    return false;
                }
            }

            this.RetraceInsert(currNode);

            return true;
        }

        private void RetraceInsert(Node<T> node)
        {
            var parent = node.Parent;
            while (parent != null)
            {
                if (node.IsLeftChild)
                {
                    if (parent.BalanceFactor == 1)
                    {
                        parent.BalanceFactor++;
                        if (node.BalanceFactor == -1)
                        {
                            this.RotateLeft(node);
                        }

                        this.RotateRight(parent);
                        break;
                    }
                    else if (parent.BalanceFactor == -1)
                    {
                        parent.BalanceFactor = 0;
                        break;
                    }
                    else
                    {
                        parent.BalanceFactor = 1;
                    }
                }

                if (node.IsRightChild)
                {
                    if (parent.BalanceFactor == -1)
                    {
                        parent.BalanceFactor--;
                        if (node.BalanceFactor == 1)
                        {
                            this.RotateRight(node);
                        }

                        this.RotateLeft(parent);
                        break;
                    }
                    else if (parent.BalanceFactor == 1)
                    {
                        parent.BalanceFactor = 0;
                        break;
                    }
                    else
                    {
                        parent.BalanceFactor = -1;
                    }
                }

                node = parent;
                parent = node.Parent;
            }
        }

        private void RotateRight(Node<T> node)
        {
            var parent = node.Parent;
            var child = node.LeftChild;

            if (parent != null)
            {
                if (node.IsLeftChild)
                {
                    parent.LeftChild = child;
                }
                else
                {
                    parent.RightChild = child;
                }
            }
            else
            {
                this.root = child;
                this.root.Parent = null;
            }

            node.LeftChild = child.RightChild;
            child.RightChild = node;

            node.BalanceFactor -= 1 + Math.Max(child.BalanceFactor, 0);
            child.BalanceFactor -= 1 - Math.Min(node.BalanceFactor, 0);
        }

        private void RotateLeft(Node<T> node)
        {
            var parent = node.Parent;
            var child = node.RightChild;
            if (parent != null)
            {
                if (node.IsLeftChild)
                {
                    parent.LeftChild = child;
                }
                else
                {
                    parent.RightChild = child;
                }
            }
            else
            {
                this.root = child;
                this.root.Parent = null;
            }

            node.RightChild = child.LeftChild;
            child.LeftChild = node;

            node.BalanceFactor += 1 - Math.Min(child.BalanceFactor, 0);
            child.BalanceFactor += 1 + Math.Max(node.BalanceFactor, 0);
        }
    }
}
