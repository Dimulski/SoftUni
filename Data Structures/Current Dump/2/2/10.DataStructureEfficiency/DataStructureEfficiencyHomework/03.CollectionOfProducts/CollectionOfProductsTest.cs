namespace _03.CollectionOfProducts
{
    using System;

    public class CollectionOfProductsTest
    {
        public static void Main()
        {
            var productCollection = new ProductCollection();
            productCollection.Add(new Product("1", "Laptop", "Lenovo", 799.99m));
            productCollection.Add(new Product("2", "Car", "Mitsubishi", 49999.95m));
            productCollection.Add(new Product("3", "Picture Frame", "PicFrame Inc.", 17m));
            productCollection.Add(new Product("4", "Picture Frame", "NPFame", 12m));
            productCollection.Add(new Product("5", "Picture Frame", "DogHouse", 20m));
            productCollection.Add(new Product("6", "Laptop", "Acer", 699.99m));
            productCollection.Add(new Product("5", "Laptop", "Lenovo", 699.99m));
            productCollection.Add(new Product("8", "Sofa", "Sofa Company", 119.99m));
            productCollection.Add(new Product("10", "Car", "BMW", 49999.95m));
            productCollection.Add(new Product("11", "Car", "Trash", 1m));
            productCollection.Remove("11");

            var priceRange = productCollection.FindByPriceRange(100m, 10000m);
            Console.WriteLine("Price range [100, 10000]: {0}", string.Join(", ", priceRange));
            var picFrames = productCollection.FindByTitle("Picture Frame");
            Console.WriteLine("Picture frames: {0}", string.Join(", ", picFrames));
            var laptopsPriceRange = productCollection.FindByTitleAndPriceRange("Laptop", 100m, 700m);
            Console.WriteLine("Laptops [100, 700]: {0}", string.Join(", ", laptopsPriceRange));
            var supplierPrice = productCollection.FindBySupplierAndPrice("Lenovo", 699.99m);
            Console.WriteLine("Lenovo(699.99): {0}", string.Join(", ", supplierPrice));
        }
    }
}
