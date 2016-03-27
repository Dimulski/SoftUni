namespace _03.CollectionOfProducts
{
    using System.Collections.Generic;
    using Wintellect.PowerCollections;

    public class ProductCollection
    {
        private Dictionary<string, Product> productsById = new Dictionary<string, Product>();
        private OrderedDictionary<decimal, OrderedSet<Product>> productsByPrice =
            new OrderedDictionary<decimal, OrderedSet<Product>>();
        private Dictionary<string, OrderedSet<Product>> productsByTitle = new Dictionary<string, OrderedSet<Product>>();
        private Dictionary<string, OrderedDictionary<decimal, OrderedSet<Product>>> productsByTitleAndPrice =
            new Dictionary<string, OrderedDictionary<decimal, OrderedSet<Product>>>();
        private Dictionary<string, OrderedDictionary<decimal, SortedSet<Product>>> productsBySupplierAndPrice =
            new Dictionary<string, OrderedDictionary<decimal, SortedSet<Product>>>();


        public void Add(Product product)
        {
            if (this.productsById.ContainsKey(product.ID))
            {
                this.Remove(product.ID);
            }

            this.productsById[product.ID] = product;

            if (!productsByPrice.ContainsKey(product.Price))
            {
                productsByPrice.Add(product.Price, new OrderedSet<Product>());
            }

            productsByPrice[product.Price].Add(product);

            if (!productsByTitle.ContainsKey(product.Title))
            {
                productsByTitle.Add(product.Title, new OrderedSet<Product>());
            }

            productsByTitle[product.Title].Add(product);

            if (!productsByTitleAndPrice.ContainsKey(product.Title))
            {
                productsByTitleAndPrice.Add(product.Title, new OrderedDictionary<decimal, OrderedSet<Product>>());
            }

            if (!productsByTitleAndPrice[product.Title].ContainsKey(product.Price))
            {
                productsByTitleAndPrice[product.Title].Add(product.Price, new OrderedSet<Product>());
            }

            productsByTitleAndPrice[product.Title][product.Price].Add(product);

            if (!productsBySupplierAndPrice.ContainsKey(product.Supplier))
            {
                productsBySupplierAndPrice.Add(product.Supplier, new OrderedDictionary<decimal, SortedSet<Product>>());
            }

            if (!productsBySupplierAndPrice[product.Supplier].ContainsKey(product.Price))
            {
                productsBySupplierAndPrice[product.Supplier].Add(product.Price, new SortedSet<Product>());
            }

            productsBySupplierAndPrice[product.Supplier][product.Price].Add(product);
        }

        public bool Remove(string id)
        {
            var productToRemove = this.FindByID(id);
            if (productToRemove == null)
            {
                return false;
            }

            this.productsById.Remove(id);
            this.productsByPrice[productToRemove.Price].Remove(productToRemove);
            this.productsByTitle[productToRemove.Title].Remove(productToRemove);
            this.productsByTitleAndPrice[productToRemove.Title][productToRemove.Price].Remove(productToRemove);
            this.productsBySupplierAndPrice[productToRemove.Supplier][productToRemove.Price].Remove(productToRemove);

            return true;
        }

        public Product FindByID(string id)
        {
            if (this.productsById.ContainsKey(id))
            {
                return this.productsById[id];
            }

            return null;
        }

        public IEnumerable<Product> FindByPriceRange(decimal startPrice, decimal endPrice)
        {
            var range = this.productsByPrice.Range(startPrice, true, endPrice, true);
            foreach (var priceProductPair in range)
            {
                foreach (var product in priceProductPair.Value)
                {
                    yield return product;
                }
            }
        }

        public IEnumerable<Product> FindByTitle(string title)
        {
            foreach (var product in productsByTitle[title])
            {
                yield return product;
            }
        }

        public IEnumerable<Product> FindByTitleAndPrice(string title, decimal price)
        {
            foreach (var product in this.productsByTitleAndPrice[title][price])
            {
                yield return product;
            }
        }

        public IEnumerable<Product> FindByTitleAndPriceRange(string title, decimal startPrice, decimal endPrice)
        {
            var range = this.productsByTitleAndPrice[title].Range(startPrice, true, endPrice, true);
            foreach (var priceProductPair in range)
            {
                foreach (var product in priceProductPair.Value)
                {
                    yield return product;
                }
            }
        }

        public IEnumerable<Product> FindBySupplierAndPrice(string supplier, decimal price)
        {
            foreach (var product in this.productsBySupplierAndPrice[supplier][price])
            {
                yield return product;
            }
        }

        public IEnumerable<Product> FindBySupplierAndPriceRange(
            string supplier,
            decimal startPrice,
            decimal endPrice)
        {
            var range = this.productsBySupplierAndPrice[supplier].Range(startPrice, true, endPrice, true);
            foreach (var priceProductPair in range)
            {
                foreach (var product in priceProductPair.Value)
                {
                    yield return product;
                }
            }
        }
    }
}
