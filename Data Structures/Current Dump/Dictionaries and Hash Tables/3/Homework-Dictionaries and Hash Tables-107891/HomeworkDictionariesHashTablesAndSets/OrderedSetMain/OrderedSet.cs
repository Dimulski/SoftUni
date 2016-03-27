using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OrderedSetMain
{
    class OrderedSet<T> : IEnumerable<T> where T : IComparable<T>
    {
        private Node<T> root;

        public OrderedSet()
        {
            this.Count = 0;
        }

        public int Count { get; set; }

        public void Add(T value)
        {
            Node<T> node = new Node<T>(value);

            if (this.root == null)
            {
                this.root = node;
                this.Count++;
            }
            else if (!this.Contains(value))
            {
                Insert(node, this.root, null);
                this.Count++;
            }
        }

        public bool Contains(T value)
        {
            return CheckIfTreeContainsElement(value, this.root);
        }

        public void Remove(T value)
        {
            Node<T> nodeToRemove = FindNode(value, this.root, null);

            if (nodeToRemove == null)
            {
                throw new ArgumentException("The node you want to remove doesn't exist!");
            }
            else
            {
                if (!nodeToRemove.Value.Equals(this.root.Value))
                {
                    if (nodeToRemove.Value.CompareTo(nodeToRemove.Parent.Value) > 0)
                    {
                        nodeToRemove.Parent.BigChild = null;
                    }
                    else
                    {
                        nodeToRemove.Parent.SmallChild = null;
                    }

                    nodeToRemove.Parent = null;
                }

                List<T> children = new List<T>();
                children = GetChildrenValues(nodeToRemove, children);
                this.Count -= children.Count;

                if (nodeToRemove.Value.Equals(this.root.Value))
                {
                    this.root = null;
                }

                foreach (var child in children)
                {
                    this.Add(child);
                }

                this.Count--;
            }
        }

        private List<T> GetChildrenValues(Node<T> current, List<T> list)
        {
            if (current.SmallChild != null)
            {
                list.Add(current.SmallChild.Value);
                list = GetChildrenValues(current.SmallChild, list);
            }

            if (current.BigChild != null)
            {
                list.Add(current.BigChild.Value);
                list = GetChildrenValues(current.BigChild, list);
            }

            return list;
        }

        private Node<T> FindNode(T value, Node<T> current, Node<T> found)
        {
            if (current == null)
            {
                return null;
            }
            else if (current.Value.Equals(value))
            {
                return current;
            }
            else
            {
                if (value.CompareTo(current.Value) > 0)
                {
                    found = FindNode(value, current.BigChild, found);
                }
                else
                {
                    found = FindNode(value, current.SmallChild, found);
                }
            }

            return found;
        }

        private bool CheckIfTreeContainsElement(T value, Node<T> current)
        {
            if (current == null)
            {
                return false;
            }
            else if (current.Value.Equals(value))
            {
                return true;
            }
            else
            {
                if (value.CompareTo(current.Value) > 0)
                {
                    CheckIfTreeContainsElement(value, current.BigChild);
                }
                else
                {
                    CheckIfTreeContainsElement(value, current.SmallChild);
                }
            }

            return false;
        }

        private void Insert(Node<T> node, Node<T> current, Node<T> parent)
        {
            if (current == null)
            {
                if (node.Value.CompareTo(parent.Value) > 0)
                {
                    parent.BigChild = node;
                    parent.BigChild.Parent = parent;
                }
                else
                {
                    parent.SmallChild = node;
                    parent.SmallChild.Parent = parent;
                }

                return;
            }
            else
            {
                if (node.Value.CompareTo(current.Value) > 0)
                {
                    Insert(node, current.BigChild, current);
                }
                else
                {
                    Insert(node, current.SmallChild, current);
                }
            }
        }

        public IEnumerator<T> GetEnumerator()
        {
            return this.root.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
