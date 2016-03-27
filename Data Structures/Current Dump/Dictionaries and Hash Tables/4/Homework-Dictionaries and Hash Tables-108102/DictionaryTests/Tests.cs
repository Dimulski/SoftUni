using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DictionaryTests
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    namespace Hash_Table.Tests
    {
        using Dictionary;

        [TestClass]
        public class UnitTestsHashTable
        {
            [TestMethod]
            public void Add_EmptyHashTable_NoDuplicates_ShouldAddElement()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();

                // Act
                var elements = new KeyValue<string, int>[]
                {
                new KeyValue<string, int>("Peter", 5),
                new KeyValue<string, int>("Maria", 6),
                new KeyValue<string, int>("George", 4),
                new KeyValue<string, int>("Kiril", 5)
                };
                foreach (var element in elements)
                {
                    dictionary.Add(element.Key, element.Value);
                }

                // Assert
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(elements, actualElements);
            }

            [TestMethod]
            [ExpectedException(typeof(ArgumentException))]
            public void Add_EmptyHashTable_Duplicates_ShouldThrowException()
            {
                // Arrange
                var dictionary = new MyDictionary<string, string>();

                // Act
                dictionary.Add("Peter", "first");
                dictionary.Add("Peter", "second");
            }

            [TestMethod]
            public void Add_1000_Elements_Grow_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>(1);

                // Act
                var expectedElements = new List<KeyValue<string, int>>();
                for (int i = 0; i < 1000; i++)
                {
                    dictionary.Add("key" + i, i);
                    expectedElements.Add(new KeyValue<string, int>("key" + i, i));
                }

                // Assert
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(expectedElements, actualElements);
            }

            [TestMethod]
            public void AddOrReplace_WithDuplicates_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();

                // Act
                dictionary.AddOrReplace("Peter", 555);
                dictionary.AddOrReplace("Maria", 999);
                dictionary.AddOrReplace("Maria", 123);
                dictionary.AddOrReplace("Maria", 6);
                dictionary.AddOrReplace("Peter", 5);

                // Assert
                var expectedElements = new KeyValue<string, int>[]
                {
                new KeyValue<string, int>("Peter", 5),
                new KeyValue<string, int>("Maria", 6)
                };
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(expectedElements, actualElements);
            }

            [TestMethod]
            public void Count_Empty_Add_Remove_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();

                // Assert
                Assert.AreEqual(0, dictionary.Count);

                // Act & Assert
                dictionary.Add("Peter", 555);
                dictionary.AddOrReplace("Peter", 555);
                dictionary.AddOrReplace("Ivan", 555);
                Assert.AreEqual(2, dictionary.Count);

                // Act & Assert
                dictionary.Remove("Peter");
                Assert.AreEqual(1, dictionary.Count);

                // Act & Assert
                dictionary.Remove("Peter");
                Assert.AreEqual(1, dictionary.Count);

                // Act & Assert
                dictionary.Remove("Ivan");
                Assert.AreEqual(0, dictionary.Count);
            }

            [TestMethod]
            public void Get_ExistingElement_ShouldReturnTheValue()
            {
                // Arrange
                var hashTable = new MyDictionary<int, string>();

                // Act
                hashTable.Add(555, "Peter");
                var actualValue = hashTable.Get(555);

                // Assert
                Assert.AreEqual("Peter", actualValue);
            }

            [TestMethod]
            [ExpectedException(typeof(KeyNotFoundException))]
            public void Get_NonExistingElement_ShouldThrowException()
            {
                // Arrange
                var dictionary = new MyDictionary<int, string>();

                // Act
                dictionary.Get(12345);
            }

            [TestMethod]
            public void Indexer_ExistingElement_ShouldReturnTheValue()
            {
                // Arrange
                var dictionary = new MyDictionary<int, string>();

                // Act
                dictionary.Add(555, "Peter");
                var actualValue = dictionary[555];

                // Assert
                Assert.AreEqual("Peter", actualValue);
            }

            [TestMethod]
            [ExpectedException(typeof(KeyNotFoundException))]
            public void Indexer_NonExistingElement_ShouldThrowException()
            {
                // Arrange
                var dictionary = new MyDictionary<int, string>();

                // Act
                var value = dictionary[12345];
            }

            [TestMethod]
            public void Indexer_AddReplace_WithDuplicates_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();

                // Act
                dictionary["Peter"] = 555;
                dictionary["Maria"] = 999;
                dictionary["Maria"] = 123;
                dictionary["Maria"] = 6;
                dictionary["Peter"] = 5;

                // Assert
                var expectedElements = new KeyValue<string, int>[]
                {
                new KeyValue<string, int>("Peter", 5),
                new KeyValue<string, int>("Maria", 6)
                };
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(expectedElements, actualElements);
            }

            [TestMethod]
            public void Capacity_Grow_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>(2);

                // Assert
                Assert.AreEqual(2, dictionary.Capacity);

                // Act
                dictionary.Add("Peter", 123);
                dictionary.Add("Maria", 456);

                // Assert
                Assert.AreEqual(4, dictionary.Capacity);

                // Act
                dictionary.Add("Tanya", 555);
                dictionary.Add("George", 777);

                // Assert
                Assert.AreEqual(8, dictionary.Capacity);
            }

            [TestMethod]
            public void TryGetValue_ExistingElement_ShouldReturnTheValue()
            {
                // Arrange
                var dictionary = new MyDictionary<int, string>();

                // Act
                dictionary.Add(555, "Peter");
                string value;
                var result = dictionary.TryGetValue(555, out value);

                // Assert
                Assert.AreEqual("Peter", value);
                Assert.IsTrue(result);
            }

            [TestMethod]
            public void TryGetValue_NonExistingElement_ShouldReturnFalse()
            {
                // Arrange
                var dictionary = new MyDictionary<int, string>();

                // Act
                string value;
                var result = dictionary.TryGetValue(555, out value);

                // Assert
                Assert.IsFalse(result);
            }

            [TestMethod]
            public void Find_ExistingElement_ShouldReturnTheElement()
            {
                // Arrange
                var dictionary = new MyDictionary<string, DateTime>();
                var name = "Maria";
                var date = new DateTime(1995, 7, 18);
                dictionary.Add(name, date);

                // Act
                var element = dictionary.Find(name);

                // Assert
                var expectedElement = new KeyValue<string, DateTime>(name, date);
                Assert.AreEqual(expectedElement, element);
            }

            [TestMethod]
            public void Find_NonExistingElement_ShouldReturnNull()
            {
                // Arrange
                var dictionary = new MyDictionary<string, DateTime>();

                // Act
                var element = dictionary.Find("Maria");

                // Assert
                Assert.IsNull(element);
            }

            [TestMethod]
            public void ContainsKey_ExistingElement_ShouldReturnTrue()
            {
                // Arrange
                var dictionary = new MyDictionary<DateTime, string>();
                var date = new DateTime(1995, 7, 18);
                dictionary.Add(date, "Some value");

                // Act
                var containsKey = dictionary.ContainsKey(date);

                // Assert
                Assert.IsTrue(containsKey);
            }

            [TestMethod]
            public void ContainsKey_NonExistingElement_ShouldReturnFalse()
            {
                // Arrange
                var dictionary = new MyDictionary<DateTime, string>();
                var date = new DateTime(1995, 7, 18);

                // Act
                var containsKey = dictionary.ContainsKey(date);

                // Assert
                Assert.IsFalse(containsKey);
            }

            [TestMethod]
            public void Remove_ExistingElement_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, double>();
                dictionary.Add("Peter", 12.5);
                dictionary.Add("Maria", 99.9);

                // Assert
                Assert.AreEqual(2, dictionary.Count);

                // Act
                var removed = dictionary.Remove("Peter");

                // Assert
                Assert.IsTrue(removed);
                Assert.AreEqual(1, dictionary.Count);
            }

            [TestMethod]
            public void Remove_NonExistingElement_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, double>();
                dictionary.Add("Peter", 12.5);
                dictionary.Add("Maria", 99.9);

                // Assert
                Assert.AreEqual(2, dictionary.Count);

                // Act
                var removed = dictionary.Remove("George");

                // Assert
                Assert.IsFalse(removed);
                Assert.AreEqual(2, dictionary.Count);
            }

            [TestMethod]
            public void Remove_5000_Elements_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();
                var keys = new List<string>();
                var count = 5000;
                for (int i = 0; i < count; i++)
                {
                    var key = Guid.NewGuid().ToString();
                    keys.Add(key);
                    dictionary.Add(key, i);
                }

                // Assert
                Assert.AreEqual(count, dictionary.Count);

                // Act & Assert
                keys.Reverse();
                foreach (var key in keys)
                {
                    dictionary.Remove(key);
                    count--;
                    Assert.AreEqual(count, dictionary.Count);
                }

                // Assert
                var expectedElements = new List<KeyValue<string, int>>();
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(expectedElements, actualElements);
            }

            [TestMethod]
            public void Clear_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, int>();

                // Assert
                Assert.AreEqual(0, dictionary.Count);

                // Act
                dictionary.Clear();

                // Assert
                Assert.AreEqual(0, dictionary.Count);

                // Arrange
                dictionary.Add("Peter", 5);
                dictionary.Add("George", 7);
                dictionary.Add("Maria", 3);

                // Assert
                Assert.AreEqual(3, dictionary.Count);

                // Act
                dictionary.Clear();

                // Assert
                Assert.AreEqual(0, dictionary.Count);
                var expectedElements = new List<KeyValue<string, int>>();
                var actualElements = dictionary.ToList();
                CollectionAssert.AreEquivalent(expectedElements, actualElements);

                dictionary.Add("Peter", 5);
                dictionary.Add("George", 7);
                dictionary.Add("Maria", 3);

                // Assert
                Assert.AreEqual(3, dictionary.Count);
            }

            [TestMethod]
            public void Keys_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, double>();

                // Assert
                CollectionAssert.AreEquivalent(new string[0], dictionary.Keys.ToArray());

                // Arrange
                dictionary.Add("Peter", 12.5);
                dictionary.Add("Maria", 99.9);
                dictionary["Peter"] = 123.45;

                // Act
                var keys = dictionary.Keys;

                // Assert
                var expectedKeys = new string[] { "Peter", "Maria" };
                CollectionAssert.AreEquivalent(expectedKeys, keys.ToArray());
            }

            [TestMethod]
            public void Values_ShouldWorkCorrectly()
            {
                // Arrange
                var dictionary = new MyDictionary<string, double>();

                // Assert
                CollectionAssert.AreEquivalent(new string[0], dictionary.Values.ToArray());

                // Arrange
                dictionary.Add("Peter", 12.5);
                dictionary.Add("Maria", 99.9);
                dictionary["Peter"] = 123.45;

                // Act
                var values = dictionary.Values;

                // Assert
                var expectedValues = new double[] { 99.9, 123.45 };
                CollectionAssert.AreEquivalent(expectedValues, values.ToArray());
            }
        }
    }

}
