namespace _01.PlayWithTrees
{
    using System.Collections.Generic;

    public class Tree
    {
        private long? subTreeSum;

        public Tree(
            int value,
            Tree parent = null)
        {
            this.Value = value;
            this.Parent = parent;
            this.Children = new List<Tree>();
        }

        public int Value { get; }

        public Tree Parent { get; set; }

        public IList<Tree> Children { get; }

        public long SubTreeSum
        {
            get
            {
                if (this.subTreeSum == null)
                {
                    this.CalculateSubTreeSum();
                }

                return this.subTreeSum.Value;
            }
        }

        private void CalculateSubTreeSum()
        {
            this.subTreeSum = 0L;
            this.subTreeSum += this.Value;

            foreach (var child in this.Children)
            {
                this.subTreeSum += child.SubTreeSum;
            }
        }
    }
}