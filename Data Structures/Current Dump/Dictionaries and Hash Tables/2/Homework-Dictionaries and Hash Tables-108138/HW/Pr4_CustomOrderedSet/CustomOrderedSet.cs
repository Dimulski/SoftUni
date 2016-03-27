namespace Pr4_CustomOrderedSet
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Runtime.InteropServices;

    public class CustomOrderedSet<T> : IEnumerable<T> where T : IComparable<T>
    {
        private SetNode<T> nodes;
        

        public CustomOrderedSet()
        {
            this.Count = 0;
        }


        public int Count { get; private set; }
    

        public void Add(T element)
        {
            var newNode = new SetNode<T>(element);
            if (this.nodes == null)
            {
                this.nodes = newNode;
                this.Count++;
                return;
            }
            
            this.FindPositionAndInsert(this.nodes, newNode);
        }

        public bool Contains(T element)
        {
            var node = this.FindElement(element);
            if (node == null)
            {
                return false;
            }
            
            return true;
        }

        public bool Remove(T element)
        {
            var elementToDelete = this.FindElement(element);
            if (element == null)
            {
                return false;
            }
            this.DeleteElement(elementToDelete);
            this.Count--;
            return true;
        }

        private void DeleteElement(SetNode<T> elementToDelete)
        {
            // case 1: element has no child
            if (elementToDelete.LeftNode == null && elementToDelete.RightNode == null)
            {
                //var parent = elementToDelete.Parent;
                //if (elementToDelete.Value.CompareTo(parent.Value) > 0)
                //{
                //    parent.RightNode = null;
                //}
                //else
                //{
                //    parent.LeftNode = null;
                //}
                this.HookElement(elementToDelete, null);
                return;
            }
            
            // case 2: element has 1 child
            if (elementToDelete.LeftNode != null || elementToDelete.RightNode != null)
            {
                SetNode<T> elementToHook  = elementToDelete.LeftNode ?? elementToDelete.RightNode;
                this.HookElement(elementToDelete, elementToHook);

                return;
            }

            // case 3: element has 2 childred
            // 3.1. find min.element in right tree
            SetNode<T> minValue = this.FindMinElement(elementToDelete.RightNode);
            T newValue = minValue.Value;
            
            // 3.2. set value to element to be deleted
            this.DeleteElement(minValue);
            
            // 3.3. remove found minimum element
            elementToDelete.Value = newValue;
        }

        private void HookElement(SetNode<T> elementToDelete, SetNode<T> elementToHook)
        {
            var parent = elementToDelete.Parent;
            if (elementToDelete.Value.CompareTo(parent.Value) > 0)
            {
                parent.RightNode = elementToHook;
            }
            else
            {
                parent.LeftNode = null;
            }
        }

        private SetNode<T> FindMinElement(SetNode<T> currentNode)
        {
            while (currentNode.LeftNode != null)
            {
                currentNode = currentNode.LeftNode;
            }
            return currentNode;
        }

        public IEnumerator<T> GetEnumerator()
        {
           return this.nodes.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }


        private void FindPositionAndInsert(SetNode<T> currentNode, SetNode<T> newNode)
        {
            if (currentNode.Value.Equals(newNode.Value))
            {
                throw new ArgumentException("Element exists:" + newNode.Value);
            }
            var compareValue = newNode.Value.CompareTo(currentNode.Value);
            if (compareValue > 0)
            {
                if (currentNode.RightNode != null)
                {
                    this.FindPositionAndInsert(currentNode.RightNode, newNode);
                }
                else
                {
                    currentNode.RightNode = newNode;
                    this.Count++;
                }
            }
            if (compareValue < 0)
            {
                if (currentNode.LeftNode != null)
                {
                    this.FindPositionAndInsert(currentNode.LeftNode, newNode);
                }
                else
                {
                    currentNode.LeftNode = newNode;
                    this.Count++;
                }
            }

        }


        private SetNode<T> FindElement(T element)
        {
            SetNode<T> foundNode = null;
            var currentNode = this.nodes;
            while (currentNode != null)
            {
                var compareValue = element.CompareTo(currentNode.Value);
                if (compareValue == 0)
                {
                    foundNode = currentNode;
                }

                if (compareValue > 0)
                {
                    currentNode = currentNode.RightNode;
                }
                else if (compareValue < 0)
                {
                    currentNode = currentNode.LeftNode;
                }
                else
                {
                    break;
                }
            }
            return foundNode;
        }

    }
}
