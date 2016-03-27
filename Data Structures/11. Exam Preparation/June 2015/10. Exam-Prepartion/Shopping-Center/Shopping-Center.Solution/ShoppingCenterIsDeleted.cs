using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

public class ShoppingCenterIsDeleted
{
    private Dictionary<string, MultiDictionary<string, Product>> productsByProducer =
        new Dictionary<string, MultiDictionary<string, Product>>();
    private Dictionary<string, MultiDictionary<string, Product>> productsByName =
        new Dictionary<string, MultiDictionary<string, Product>>();
    private OrderedMultiDictionary<decimal, Product> productsByPrice =
        new OrderedMultiDictionary<decimal, Product>(true);

    public string AddProduct(string name, decimal price, string producer)
    {
        var newProduct = new Product()
        {
            Name = name,
            Producer = producer,
            Price = price
        };

        if (!this.productsByProducer.ContainsKey(producer))
        {
            this.productsByProducer.Add(
                producer, new MultiDictionary<string, Product>(true));
        }
        this.productsByProducer[producer].Add(name, newProduct);

        if (!this.productsByName.ContainsKey(name))
        {
            this.productsByName.Add(
                name, new MultiDictionary<string, Product>(true));
        }
        this.productsByName[name].Add(producer, newProduct);

        this.productsByPrice.Add(price, newProduct);

        return "Product added";
    }

    public string ProcessCommand(string commandLine)
    {
        int spaceIndex = commandLine.IndexOf(' ');
        if (spaceIndex == -1)
        {
            return "Invalid command";
        }

        string command = commandLine.Substring(0, spaceIndex);
        string paramsStr = commandLine.Substring(spaceIndex + 1);
        string[] cmdParams = paramsStr.Split(';');
        switch (command)
        {
            case "AddProduct":
                return this.AddProduct(
                    cmdParams[0], decimal.Parse(cmdParams[1]), cmdParams[2]);
            case "DeleteProducts":
                if (cmdParams.Length == 1)
                    return this.DeleteProductsByProducer(
                        cmdParams[0]);
                else
                    return this.DeleteProductsByNameAndProducer(
                        cmdParams[0], cmdParams[1]);
            case "FindProductsByName":
                return this.FindProductsByName(cmdParams[0]);
            case "FindProductsByProducer":
                return this.FindProductsByProducer(cmdParams[0]);
            case "FindProductsByPriceRange":
                return this.FindProductsByPriceRange(
                    decimal.Parse(cmdParams[0]), decimal.Parse(cmdParams[1]));
            default:
                return "Invalid command";
        }
    }

    public string FindProductsByName(string name)
    {
        ICollection<Product> productsFound = new List<Product>();
        if (this.productsByName.ContainsKey(name))
        {
            productsFound = this.productsByName[name].Values;
        }
        return PrintProducts(productsFound);
    }

    private string PrintProducts(IEnumerable<Product> products)
    {
        var sortedProducts = products
            .Where(p => !p.IsDeleted)
            .OrderBy(p => p);
        if (sortedProducts.Any())
        {
            return string.Join(Environment.NewLine, sortedProducts);
        }

        return "No products found";
    }

    public string FindProductsByProducer(string producer)
    {
        ICollection<Product> productsFound = new List<Product>();
        if (this.productsByProducer.ContainsKey(producer))
        {
            productsFound = this.productsByProducer[producer].Values;
        }
        return PrintProducts(productsFound);
    }

    public string FindProductsByPriceRange(
        decimal startPrice, decimal endPrice)
    {
        var productsFound = this.productsByPrice
            .Range(startPrice, true, endPrice, true)
            .Values;
        return PrintProducts(productsFound);
    }

    public string DeleteProductsByProducer(string producer)
    {
        ICollection<Product> productsFound = new List<Product>();
        if (this.productsByProducer.ContainsKey(producer))
        {
            productsFound = this.productsByProducer[producer].Values;
        }
        return DeleteProducts(productsFound);
    }

    private string DeleteProducts(ICollection<Product> productsFound)
    {
        int productDeletedCount = productsFound.Where(p => !p.IsDeleted).Count();

        //this.productsByProducer.Remove(producer);
        foreach (var p in productsFound)
        {
            //this.productsByName[p.Name].Remove(producer);
            //this.productsByPrice[p.Price].Remove(p);
            p.IsDeleted = true;
        }

        if (productDeletedCount > 0)
        {
            return productDeletedCount + " products deleted";
        }

        return "No products found";
    }

    public string DeleteProductsByNameAndProducer(
        string name, string producer)
    {
        ICollection<Product> productsFound = new List<Product>();
        if (this.productsByProducer.ContainsKey(producer))
        {
            if (this.productsByProducer[producer].ContainsKey(name))
            {
                productsFound = this.productsByProducer[producer][name];
            }
        }
        return DeleteProducts(productsFound);
    }
}