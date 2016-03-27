namespace _03.CollectionOfProducts
{
    using System;

    public class Product : IComparable<Product>
    {
        private decimal price;

        public Product(string id, string title, string supplier, decimal price)
        {
            this.ID = id;
            this.Title = title;
            this.Supplier = supplier;
            this.Price = price;
        }

        public string ID { get; set; }

        public string Title { get; set; }

        public string Supplier { get; set; }

        public decimal Price
        {
            get
            {
                return this.price;
            }

            set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Price connot be negative!");
                }

                this.price = value;
            }
        }

        public int CompareTo(Product other)
        {
            return this.ID.CompareTo(other.ID);
        }

        public override string ToString()
        {
            return string.Format(
                "{0} (ID: {1}; Supplier: {2}; Price: {3:F2})", 
                this.Title,
                this.ID,
                this.Supplier,
                this.Price);
        }
    }
}
