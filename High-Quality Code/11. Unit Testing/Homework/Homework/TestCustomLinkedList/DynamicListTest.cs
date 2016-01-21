namespace TestCustomLinkedList
{
    using System;
    using CustomLinkedList;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class DynamicListTest
    {
        private DynamicList<char> dynamicList;

        [TestInitialize]
        public void TestInitialize()
        {
            this.dynamicList = new DynamicList<char>();
        }

        [TestMethod]
        public void GettingListCountShouldReturnCorrectValue()
        {
            this.dynamicList.Add('a');
            Assert.AreEqual(1, this.dynamicList.Count, "Getter doesn't return correct list count.");
        }

        [TestMethod]
        public void AddingItemShouldIncrementListCountByOne()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');

            Assert.AreEqual(2, this.dynamicList.Count, "Add method doesn't increment list count by one.");
        }

        [TestMethod]
        public void AddingItemShouldReturnCorrectAddedItem()
        {
            this.dynamicList.Add('a');
            var added = this.dynamicList[0];

            Assert.AreEqual('a', added, "Add method doesn't add the correct item.");
        }

        [TestMethod]
        public void RemovingValidItemShouldDecrementListCountByOne()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Remove('a');

            Assert.AreEqual(
                0,
                this.dynamicList.Count,
                "Remove method doesn't decrement list count by one.");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void RemovingInvalidItemShouldThrowException()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Remove('b');
        }

        [TestMethod]
        public void RemovingItemAtValidPositionShouldDecrementListCountByOne()
        {
            this.dynamicList.Add('a');
            this.dynamicList.RemoveAt(0);

            Assert.AreEqual(
                0, this.dynamicList.Count, "RemoveAt method doesn't decrement list count.");
        }

        [TestMethod]
        public void RemovingItemAtValidPositionShouldReturnCorrectRemovedItem()
        {
            this.dynamicList.Add('a');
            var removed = this.dynamicList[0];
            this.dynamicList.RemoveAt(0);

            Assert.IsTrue(removed == 'a', "RemoveAt method doesn't remove the correct item.");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void RemovingItemAtNegativePositionShouldThrowException()
        {
            this.dynamicList.Add('a');
            this.dynamicList.RemoveAt(-1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]

        public void RemovingItemAtInvalidPositionShouldThrowException()
        {
            this.dynamicList.Add('a');
            this.dynamicList.RemoveAt(1);
        }

        [TestMethod]
        public void GettingItemByValidIndexShouldReturnCorrectItem()
        {
            this.dynamicList.Add('a');

            Assert.IsTrue(
                this.dynamicList[0] == 'a',
                "Getting item by index method doesn't return the correct item.");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void GettingItemByNegativeIndexShouldThrowException()
        {
            this.dynamicList.Add('a');
            var position = this.dynamicList[-1];
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void GettingItemByInvalidIndexShouldThrowException()
        {
            this.dynamicList.Add('a');
            var position = this.dynamicList[3];
        }

        [TestMethod]
        public void SettingItemByValidIndexShouldReturnCorrectItem()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            this.dynamicList[2] = 'd';

            Assert.IsTrue(
                this.dynamicList[2] == 'd',
                "Setting item by index method doesn't return correct item.");
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void SettingItemByNegativeIndexShouldThrowException()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            this.dynamicList[-1] = 'd';
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void SettingItemByInvalidIndexShouldThrowException()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            this.dynamicList[3] = 'd';
        }

        [TestMethod]
        public void CkeckingIndexOfValidItemShouldReturnCorrectIndex()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            int index = this.dynamicList.IndexOf('b');

            Assert.AreEqual(1, index, "IndexOf method doesn't return correct index.");
        }

        [TestMethod]
        public void CkeckingIndexOfInvalidItemShouldReturnMinusOne()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            int index = this.dynamicList.IndexOf('z');

            Assert.AreEqual(-1, index, "IndexOf method doesn't -1.");
        }

        [TestMethod]
        public void CheckingIfExcistingItemContainsShouldReturnTrue()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            bool isContains = this.dynamicList.Contains('a');

            Assert.AreEqual(true, isContains, "Contains method doesn't return true.");
        }

        [TestMethod]
        public void CheckingIfNonExcistingItemContainsShouldReturnFalse()
        {
            this.dynamicList.Add('a');
            this.dynamicList.Add('b');
            this.dynamicList.Add('c');

            bool isContains = this.dynamicList.Contains('z');

            Assert.AreEqual(false, isContains, "Contains method doesn't return false.");
        }
    }
}