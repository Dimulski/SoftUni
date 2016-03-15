namespace Problem4LongestPathInATree
{
    using System.Collections.Generic;

    public class Tree
    {
        private long? sumToRoot;

        public Tree(int value)
        {
            this.Value = value;
            this.sumToRoot = null;
            this.Children = new List<Tree>();
        }

        public int Value { get; }

        public Tree Parent { get; set; }

        public IList<Tree> Children { get; }

        public long SumToRoot
        {
            get
            {
                if (this.sumToRoot == null)
                {
                    this.CalculateSumToRoot();
                }

                return this.sumToRoot.GetValueOrDefault();
            }
        }

        private void CalculateSumToRoot()
        {
            this.sumToRoot = 0;
            this.sumToRoot += this.Value;

            if (this.Parent != null)
            {
                this.sumToRoot += this.Parent.SumToRoot;
            }
        }
    }
}
