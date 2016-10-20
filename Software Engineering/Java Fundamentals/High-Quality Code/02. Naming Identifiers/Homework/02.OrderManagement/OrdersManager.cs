namespace Orders
{
    using System;
    using System.Globalization;
    using System.Linq;
    using System.Threading;

    public static class OrdersManager
    {
        public static void Main()
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;

            var dataMapper = new DataMapper();
            var allCategories = dataMapper.GetAllCategories();
            var allProducts = dataMapper.GetAllProducts();
            var allOrders = dataMapper.GetAllOrders();

            var fiveMostExpensiveProducts = allProducts
                .OrderByDescending(p => p.UnitPrice)
                .Take(5)
                .Select(p => p.Name);

            Console.WriteLine(string.Join(Environment.NewLine, fiveMostExpensiveProducts));
            Console.WriteLine(new string('-', 10));

            var numberOfProductsPerCat = allProducts
                .GroupBy(p => p.CateoryId)
                .Select(grp => new
                {
                    Category = allCategories
                        .First(c => c.Id == grp.Key)
                        .Name,
                    Count = grp.Count()
                })
                .ToList();

            foreach (var item in numberOfProductsPerCat)
            {
                Console.WriteLine("{0}: {1}", item.Category, item.Count);
            }

            Console.WriteLine(new string('-', 10));
            
            var mostQuantityProducts = allOrders
                .GroupBy(order => order.ProductId)
                .Select(group => new
                {
                    Product = allProducts
                        .First(product => product.Id == group.Key)
                        .Name,
                    Quantities = group.Sum(order => order.Quantity)
                })
                .OrderByDescending(products => products.Quantities)
                .Take(5);

            foreach (var item in mostQuantityProducts)
            {
                Console.WriteLine("{0}: {1}", item.Product, item.Quantities);
            }

            Console.WriteLine(new string('-', 10));

            var mostProfitableCategory = allOrders
                .GroupBy(order => order.ProductId)
                .Select(group => new
                {
                    CatId = allProducts
                        .First(product => product.Id == group.Key)
                        .CateoryId,
                    Price = allProducts
                        .First(product => product.Id == group.Key)
                        .UnitPrice,
                    Quantity = group.Sum(order => order.Quantity)
                })
                .GroupBy(group => group.CatId)
                .Select(group => new
                {
                    CategoryName = allCategories
                        .First(category => category.Id == group.Key)
                        .Name,
                    TotalQuantity = group
                        .Sum(g => g.Quantity * g.Price)
                })
                .OrderByDescending(group => group.TotalQuantity)
                .First();

            Console.WriteLine(
                "{0}: {1}", mostProfitableCategory.CategoryName, mostProfitableCategory.TotalQuantity);
        }
    }
}
