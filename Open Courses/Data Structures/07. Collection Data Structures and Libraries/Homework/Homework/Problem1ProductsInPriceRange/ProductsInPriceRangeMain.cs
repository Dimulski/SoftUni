namespace Problem1ProductsInPriceRange
{
    using System;

    using Wintellect.PowerCollections;

    public class ProductsInPriceRangeMain
    {
        public static void Main()
        {
            var bag = new OrderedBag<Product>();

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var lineParams = Console.ReadLine().Split(' ');
                var name = lineParams[0];
                var price = float.Parse(lineParams[1]);
                bag.Add(new Product(name, price));
            }

            var priceRange = Console.ReadLine().Split(' ');
            var lowerPrice = float.Parse(priceRange[0]);
            var upperPrice = float.Parse(priceRange[1]);

            var range = bag.Range(new Product(lowerPrice), true, new Product(upperPrice), true);

            foreach (var product in range)
            {
                Console.WriteLine(product);
            }

            Console.WriteLine();
        }
    }

    public class Product : IComparable
    {
        private float price;

        public Product(string name, float price)
        {
            this.Name = name;
            this.Price = price;
        }

        public Product(float price)
        {
            this.Name = null;
            this.Price = price;
        }

        public string Name { get; set; }

        public float Price
        {
            get
            {
                return this.price;
            }
            set
            {
                this.price = value;
            }
            
        }
        
        public int CompareTo(object obj)
        {
            if (obj == null)
            {
                return 1;
            }

            Product otherProduct = obj as Product;

            if (otherProduct != null)
            {
                return this.price.CompareTo(otherProduct.price);
            }
            else
            {
                throw new ArgumentException("Object is not a Temperature");
            } 
        }

        public override string ToString()
        {
            return string.Format("{0} {1}", this.Price, this.Name);
        }
    }
}
