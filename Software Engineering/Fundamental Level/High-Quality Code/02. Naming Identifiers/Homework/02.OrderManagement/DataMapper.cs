namespace Orders
{
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;
    using Models;

    public class DataMapper
    {
        public DataMapper(
            string categoriesFileName, 
            string productsFileName, 
            string ordersFileName)
        {
            this.CategoriesFileName = categoriesFileName;
            this.ProductsFileName = productsFileName;
            this.OrdersFileName = ordersFileName;
        }

        public DataMapper()
            : this(
                  "../../Data/categories.txt", 
                  "../../Data/products.txt", 
                  "../../Data/orders.txt")
        {
        }

        public string CategoriesFileName { get; private set; }

        public string ProductsFileName { get; private set; }

        public string OrdersFileName { get; private set; }

        public IEnumerable<Category> GetAllCategories()
        {
            var cat = this.ReadFileLines(this.CategoriesFileName, true);
            return cat
                .Select(catogory => catogory.Split(','))
                .Select(catogory => new Category
                {
                    Id = int.Parse(catogory[0]),
                    Name = catogory[1],
                    Description = catogory[2]
                });
        }

        public IEnumerable<Product> GetAllProducts()
        {
            var prod = this.ReadFileLines(this.ProductsFileName, true);
            return prod
                .Select(product => product.Split(','))
                .Select(product => new Product
                {
                    Id = int.Parse(product[0]),
                    Name = product[1],
                    CateoryId = int.Parse(product[2]),
                    UnitPrice = decimal.Parse(product[3]),
                    UnitsInStock = int.Parse(product[4]),
                });
        }

        public IEnumerable<Order> GetAllOrders()
        {
            var ord = this.ReadFileLines(this.OrdersFileName, true);
            return ord
                .Select(product => product.Split(','))
                .Select(product => new Order
                {
                    Id = int.Parse(product[0]),
                    ProductId = int.Parse(product[1]),
                    Quantity = int.Parse(product[2]),
                    Discount = decimal.Parse(product[3]),
                });
        }

        private IEnumerable<string> ReadFileLines(string filename, bool hasHeader)
        {
            var allLines = new List<string>();
            using (var reader = new StreamReader(filename))
            {
                string currentLine;
                if (hasHeader)
                {
                    reader.ReadLine();
                }

                while ((currentLine = reader.ReadLine()) != null)
                {
                    allLines.Add(currentLine);
                }
            }

            return allLines;
        }
    }
}
