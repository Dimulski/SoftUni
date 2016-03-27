namespace Pr4_CustomOrderedSet
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    public class SetNode<T> : IEnumerable<T>
    {
        private T value;
        private SetNode<T> leftNode;
        private SetNode<T> rightNode;
        
        public SetNode(T value, SetNode<T> leftNode = null, SetNode<T> rightNode = null )
        {
            this.Value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
        
        public T Value 
        {
            get
            {
                return this.value;
            }
            
            set 
            {
                if (value == null)
                {
                    throw new ArgumentNullException("value can not be null");
                }
                
                this.value = value;
            }
        }

        public SetNode<T> Parent { get; private set; }
        
        public SetNode<T> RightNode 
        {
            get
            {
                return this.rightNode;
            }
        
            set
            {
                if (value != null)
                {
                    this.rightNode = value;
                    this.rightNode.Parent = this;
                }
            }
        }

        public SetNode<T> LeftNode
        {
            get
            {
                return this.leftNode;
            }

            set
            {
                if (value != null)
                {
                    this.leftNode = value;
                    this.leftNode.Parent = this;
                }
            }
        }
        
        public IEnumerator<T> GetEnumerator()
        {
            if (this.LeftNode != null)
            {
                foreach (var element in this.LeftNode)
                {
                    yield return element;
                }
            }
            
            yield return this.Value;
            
            if (this.RightNode != null)
            {
                foreach (var element in this.RightNode)
                {
                    yield return element;
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
