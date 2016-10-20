using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

public class ShoppingCenterFast
{
    private const string PRODUCT_ADDED = "Product added";
    private const string X_PRODUCTS_DELETED = " products deleted";
    private const string NO_PRODUCTS_FOUND = "No products found";
    private const string INCORRECT_COMMAND = "Incorrect command";

    private readonly MultiDictionary<string, Product> productsByName =
        new MultiDictionary<string, Product>(true);
    private readonly MultiDictionary<string, Product> productsByNameAndProducer =
        new MultiDictionary<string, Product>(true);
    private readonly OrderedMultiDictionary<decimal, Product> productsByPrice =
        new OrderedMultiDictionary<decimal, Product>(true);
    private readonly MultiDictionary<string, Product> productsByProducer =
        new MultiDictionary<string, Product>(true);

    private string AddProduct(string name, string price, string producer)
    {
        Product product = new Product()
        {
            Name = name,
            Price = decimal.Parse(price),
            Producer = producer
        };

        this.productsByName.Add(name, product);
        string nameAndProducerKey = this.CombineKeys(name, producer);
        this.productsByNameAndProducer.Add(nameAndProducerKey, product);
        this.productsByPrice.Add(product.Price, product);
        this.productsByProducer.Add(producer, product);

        return PRODUCT_ADDED;
    }

    private string CombineKeys(string name, string producer)
    {
        string key = name + ";" + producer;
        return key;
    }

    private string FindProductsByName(string name)
    {
        var productsFound = this.productsByName[name];
        return SortAndPrintProducts(productsFound);
    }

    private string SortAndPrintProducts(IEnumerable<Product> products)
    {
        if (products.Any())
        {
            var sortedProducts = products.OrderBy(p => p);
            return string.Join(Environment.NewLine, sortedProducts);
        }

        return NO_PRODUCTS_FOUND;
    }

    private string FindProductsByProducer(string producer)
    {
        var productsFound = this.productsByProducer[producer];
        return SortAndPrintProducts(productsFound);
    }

    private string FindProductsByPriceRange(string from, string to)
    {
        decimal rangeStart = decimal.Parse(from);
        decimal rangeEnd = decimal.Parse(to);
        var productsFound = productsByPrice.Range(rangeStart, true, rangeEnd, true).Values;
        return SortAndPrintProducts(productsFound);
    }

    private string DeleteProductsByNameAndProducer(string name, string producer)
    {
        string nameAndProducerKey = name + ";" + producer;
        var productsToBeRemoved = productsByNameAndProducer[nameAndProducerKey];
        if (productsToBeRemoved.Any())
        { 
            int countOfRemovedProducts = productsToBeRemoved.Count;
            foreach (var product in productsToBeRemoved)
            {
                productsByName.Remove(product.Name, product);
                productsByProducer.Remove(product.Producer, product);
                productsByPrice.Remove(product.Price, product);
            }
            productsByNameAndProducer.Remove(nameAndProducerKey);
            return countOfRemovedProducts + X_PRODUCTS_DELETED;
        }

        return NO_PRODUCTS_FOUND;
    }

    private string DeleteProductsByProducer(string producer)
    {
        var productsToBeRemoved = productsByProducer[producer];
        if (productsToBeRemoved.Any())
        {
            foreach (var product in productsToBeRemoved)
            {
                productsByName.Remove(product.Name, product);
                string nameAndProducerKey = this.CombineKeys(product.Name, producer);
                productsByNameAndProducer.Remove(nameAndProducerKey, product);
                productsByPrice.Remove(product.Price, product);
            }
            int countOfRemovedProducts = productsByProducer[producer].Count;
            productsByProducer.Remove(producer);
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
