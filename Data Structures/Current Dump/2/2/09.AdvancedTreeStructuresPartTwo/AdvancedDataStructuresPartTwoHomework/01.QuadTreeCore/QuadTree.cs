namespace _01.QuadTreeCore
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class QuadTree<T> where T : IBoundable
    {
        public const int DefaultMaxDepth = 5;

        public readonly int MaxDepth;

        private Node<T> root;

        public QuadTree(int width, int height, int maxDepth = DefaultMaxDepth)
        {
            this.root = new Node<T>(0, 0, width, height);
            this.Bounds = this.root.Bounds;
            this.MaxDepth = maxDepth;
        }

        public int Count { get; private set; }

        public Rectangle Bounds { get; private set; }

        public bool Insert(T item)
        {
            if (!item.Bounds.IsInside(this.Bounds))
            {
                return false;
            }

            int depth = 1;
            var currNode = this.root;
            while (currNode.Children != null)
            {
                int quadrant = this.GetQuadrant(currNode, item.Bounds);
                if (quadrant == 0)
                {
                    currNode = currNode.Children[0];
                    depth++;
                }
                else if (quadrant == 1)
                {
                    currNode = currNode.Children[1];
                    depth++;
                }
                else if (quadrant == 2)
                {
                    currNode = currNode.Children[2];
                    depth++;
                }
                else if (quadrant == 3)
                {
                    currNode = currNode.Children[3];
                    depth++;
                }
                else
                {
                    break;
                }
            }

            currNode.Items.Add(item);
            this.Split(currNode, depth);
            this.Count++;

            return true;
        }

        public List<T> Report(Rectangle bounds)
        {
            var collisionCandidates = new List<T>();

            this.GetCollisionCandidates(this.root, bounds, collisionCandidates);

            return collisionCandidates;
        }

        public void ForEachDfs(Action<List<T>, int, int> action)
        {
            this.ForEachDfs(this.root, action);
        }

        private void GetCollisionCandidates(Node<T> node, Rectangle bounds, List<T> results)
        {
            int quadrant = this.GetQuadrant(node, bounds);
            if (quadrant == -1)
            {
                this.GetSubtreeContents(node, bounds, results);
            }
            else
            {
                if (node.Children != null)
                {
                    foreach (var child in node.Children)
                    {
                        if (bounds.IsInside(child.Bounds))
                        {
                            this.GetCollisionCandidates(child, bounds, results);
                        }
                    }
                }

                results.AddRange(node.Items);
            }
        }

        private void GetSubtreeContents(Node<T> node, Rectangle bounds, List<T> results)
        {
            if (node.Children != null)
            {
                foreach (var child in node.Children)
                {
                    if (child.Bounds.Intersects(bounds))
                    {
                        this.GetSubtreeContents(child, bounds, results);
                    }
                }
            }

            results.AddRange(node.Items);
        }

        private void ForEachDfs(Node<T> node, Action<List<T>, int, int> action, int depth = 1, int quadrant = 0)
        {
            if (node == null)
            {
                return;
            }

            if (node.Items.Any())
            {
                action(node.Items, depth, quadrant);
            }

            if (node.Children != null)
            {
                for (int i = 0; i < node.Children.Length; i++)
                {
                    this.ForEachDfs(node.Children[i], action, depth + 1, i);
                }
            }
        }

        private void Split(Node<T> node, int depth)
        {
            if (!(node.ShouldSplit && depth < MaxDepth))
            {
                return;
            }

            int leftWidth = node.Bounds.Width / 2;
            int rightWidth = node.Bounds.Width - leftWidth;
            int topHeight = node.Bounds.Height / 2;
            int bottomHeight = node.Bounds.Height - topHeight;

            node.Children = new Node<T>[4];
            node.Children[0] = new Node<T>(node.Bounds.MidX, node.Bounds.MidY, rightWidth, topHeight);
            node.Children[1] = new Node<T>(node.Bounds.X1, node.Bounds.MidY, leftWidth, topHeight);
            node.Children[2] = new Node<T>(node.Bounds.X1, node.Bounds.Y1, leftWidth, bottomHeight);
            node.Children[3] = new Node<T>(node.Bounds.MidX, node.Bounds.Y1, rightWidth, bottomHeight);

            for (int i = 0; i < node.Items.Count;)
            {
                var item = node.Items[i];
                int quadrant = this.GetQuadrant(node, item.Bounds);
                if (quadrant != -1)
                {
                    node.Items.Remove(item);
                    node.Children[quadrant].Items.Add(item);
                }
                else
                {
                    i++;
                }
            }

            foreach (var item in node.Children)
            {
                this.Split(item, depth + 1);
            }
        }

        private int GetQuadrant(Node<T> node, Rectangle bounds)
        {
            int horizontalMidpoint = node.Bounds.MidY;
            int verticalMidpoint = node.Bounds.MidX;

            bool isInTopQuadrant = bounds.Y2 <= node.Bounds.Y2 && bounds.Y1 >= horizontalMidpoint;
            bool isInBottomQuadrant = horizontalMidpoint >= bounds.Y2 && node.Bounds.Y1 <= bounds.Y1;
            bool isInRightQuadrant = verticalMidpoint <= bounds.X1 && bounds.X2 <= node.Bounds.X2;
            bool isInLeftQuadrant = node.Bounds.X1 <= bounds.X1 && bounds.X2 <= verticalMidpoint;

            if (isInTopQuadrant)
            {
                if (isInRightQuadrant)
                {
                    return 0;
                }
                else if (isInLeftQuadrant)
                {
                    return 1;
                }
            }
            else if (isInBottomQuadrant)
            {
                if (isInLeftQuadrant)
                {
                    return 2;
                }
                else if (isInRightQuadrant)
                {
                    return 3;
                }
            }

            return -1;
        }
    }
}
