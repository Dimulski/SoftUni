using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Wintellect.PowerCollections;

public class ShoppingCenterOrderedBag
{
    private const string PRODUCT_ADDED = "Product added";
    private const string X_PRODUCTS_DELETED = " products deleted";
    private const string NO_PRODUCTS_FOUND = "No products found";
    private const string INCORRECT_COMMAND = "Incorrect command";

    private readonly Dictionary<string, OrderedBag<Product>> productsByName =
        new Dictionary<string, OrderedBag<Product>>();
    private readonly Dictionary<string, OrderedBag<Product>> productsByProducer =
        new Dictionary<string, OrderedBag<Product>>();
    private readonly Dictionary<string, OrderedBag<Product>> productsByNameAndProducer =
        new Dictionary<string, OrderedBag<Product>>();
    private readonly OrderedDictionary<decimal, OrderedBag<Product>> productsByPrice =
        new OrderedDictionary<decimal, OrderedBag<Product>>();

    private string AddProduct(string name, string price, string producer)
    {
        Product product = new Product()
        {
            Name = name,
            Price = decimal.Parse(price),
            Producer = producer
        };

        this.productsByName.AppendValueToKey(name, product);
        this.productsByProducer.AppendValueToKey(producer, product);
        string nameAndProducerKey = this.CombineKeys(name, producer);
        this.productsByNameAndProducer.AppendValueToKey(nameAndProducerKey, product);
        this.productsByPrice.AppendValueToKey(product.Price, product);

        return PRODUCT_ADDED;
    }

    private string CombineKeys(string name, string producer)
    {
        string key = name + ";" + producer;
        return key;
    }

    private string FindProductsByName(string name)
    {
        var productsFound = this.productsByName.GetValuesForKey(name);
        if (productsFound.Any())
        {
            string formattedProducts = PrintProducts(productsFound);
            return formattedProducts;
        }

        return NO_PRODUCTS_FOUND;
    }

    private string FindProductsByProducer(string producer)
    {
        var productsFound = this.productsByProducer.GetValuesForKey(producer);
        if (productsFound.Any())
        {
            string formattedProducts = PrintProducts(productsFound);
            return formattedProducts;
        }

        return NO_PRODUCTS_FOUND;
    }

    private string FindProductsByPriceRange(string from, string to)
    {
        decimal rangeStart = decimal.Parse(from);
        decimal rangeEnd = decimal.Parse(to);
        var productGroups = productsByPrice.Range(rangeStart, true, rangeEnd, true).Values;
        var products = new List<Product>();
        foreach (var productGroup in productGroups)
        {
            products.AddRange(productGroup);
        }
        if (products.Any())
        {
            products.Sort();
            string formattedProducts = PrintProducts(products);
            return formattedProducts;
        }

        return NO_PRODUCTS_FOUND;
    }

    private string PrintProducts(IEnumerable<Product> products)
    {
        var builder = new StringBuilder();
        foreach (var product in products)
        {
            builder.AppendLine(product.ToString());
        }
        builder.Length -= Environment.NewLine.Length; // Remove the undneeded last "new line"
        string formattedProducts = builder.ToString();
        return formattedProducts;
    }

    private string DeleteProductsByNameAndProducer(string name, string producer)
    {
        string nameAndProducerKey = name + ";" + producer;
        var productsToBeRemoved =
            this.productsByNameAndProducer.GetValuesForKey(nameAndProducerKey);
        if (productsToBeRemoved.Any())
        {
            int countOfRemovedProducts = 0;
            foreach (var product in productsToBeRemoved)
            {
                this.productsByName[product.Name].Remove(product);
                this.productsByProducer[product.Producer].Remove(product);
                this.productsByPrice[product.Price].Remove(product);
                countOfRemovedProducts++;
            }
            this.productsByNameAndProducer.Remove(nameAndProducerKey);
            return countOfRemovedProducts + X_PRODUCTS_DELETED;
        }

        return NO_PRODUCTS_FOUND;
    }

    private string DeleteProductsByProducer(string producer)
    {
        var productsToBeRemoved = this.productsByProducer.GetValuesForKey(producer);
        if (productsToBeRemoved.Any())
        {
            int countOfRemovedProducts = 0;
            foreach (var product in productsToBeRemoved)
            {
                this.productsByName[product.Name].Remove(product);
                string nameAndProducerKey = this.CombineKeys(product.Name, producer);
                this.productsByNameAndProducer[nameAndProducerKey].Remove(product);
                this.productsByPrice[product.Price].Remove(product);
                countOfRemovedProducts++;
            }
            this.productsByProducer.Remove(producer);
            return countOfRemovedProducts + X_PRODUCTS_DELETED;
        }

        return NO_PRODUCTS_FOUND;
    }

    public string ProcessCommand(string command)
    {
        int indexOfFirstSpace = command.IndexOf(' ');
        string method = command.Substring(0, indexOfFirstSpace);
        string parameterValues = command.Substring(indexOfFirstSpace + 1);
        string[] parameters = parameterValues.Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries);
        switch (method)
        {
            case "AddProduct":
                return AddProduct(parameters[0], parameters[1], parameters[2]);
            case "DeleteProducts":
                if (parameters.Length == 1)
                {
                    return DeleteProductsByProducer(parameters[0]);
                }
                else
                {
                    return DeleteProductsByNameAndProducer(parameters[0], parameters[1]);
                }
            case "FindProductsByName":
                return FindProductsByName(parameters[0]);
            case "FindProductsByPriceRange":
                return FindProductsByPriceRange(parameters[0], parameters[1]);
            case "FindProductsByProducer":
                return FindProductsByProducer(parameters[0]);
            default:
                return INCORRECT_COMMAND;
        }
    }
}
