namespace _07.LinkedListTests
{
    using System;
    using _07.LinkedList;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class LinkedListTests
    {
        private LinkedList<int> linkedList;

        [TestInitialize]
        public void Setup()
        {
            this.linkedList = new LinkedList<int>();
        }

        [TestMethod]
        public void TestCount_NoElements_ShouldReturnZero()
        {
            const int ExpectedCount = 0;

            Assert.AreEqual(ExpectedCount, this.linkedList.Count);
        }

        [TestMethod]
        public void TestAdd_AddFourElements_CountShouldBeFour()
        {
            const int ExpectedCount = 4;

            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);

            Assert.AreEqual(ExpectedCount, this.linkedList.Count);
        }

        [TestMethod]
        public void TestRemove_RemoveLastElement_ExpectedRemovedElement()
        {
            const int ExpectedElement = 4;

            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);

            int element = this.linkedList.Remove(3);

            Assert.AreEqual(ExpectedElement, element);
        }

        [TestMethod]
        public void TestRemove_RemoveMiddleElement_ExpectedRemovedElement()
        {
            const int ExpectedElement = 2;

            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);

            int element = this.linkedList.Remove(1);

            Assert.AreEqual(ExpectedElement, element);
        }

        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestRemove_NegativeIndex_ExpectedIndexOutOfRangeException()
        {
            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);

            int element = this.linkedList.Remove(-2);
        }

        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestRemove_IndexHigherThanCount_ExpectedIndexOutOfRangeException()
        {
            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);

            int element = this.linkedList.Remove(4);
        }

        [TestMethod]
        public void TestFirstIndexOf_ContainsItem_IndexOfFirstAppearance()
        {
            const int ExpectedIndex = 2;

            this.linkedList.Add(-6);
            this.linkedList.Add(32);
            this.linkedList.Add(1);
            this.linkedList.Add(100);
            this.linkedList.Add(1);

            Assert.AreEqual(ExpectedIndex, this.linkedList.FirstIndexOf(1));
        }

        [TestMethod]
        public void TestFirstIndexOf_ItemIsNotInList_ExpectedMinusOne()
        {
            const int ExpectedIndex = -1;

            this.linkedList.Add(-6);
            this.linkedList.Add(32);
            this.linkedList.Add(1);
            this.linkedList.Add(100);
            this.linkedList.Add(1);

            Assert.AreEqual(ExpectedIndex, this.linkedList.FirstIndexOf(2));
        }

        [TestMethod]
        public void TestLastIndexOf_ContainsItem_IndexOfLastAppearance()
        {
            const int ExpectedIndex = 4;

            this.linkedList.Add(-6);
            this.linkedList.Add(32);
            this.linkedList.Add(1);
            this.linkedList.Add(100);
            this.linkedList.Add(1);

            Assert.AreEqual(ExpectedIndex, this.linkedList.LastIndexOf(1));
        }

        [TestMethod]
        public void TestLastIndexOf_ItemIsNotInList_ExpectedMinusOne()
        {
            const int ExpectedIndex = -1;

            this.linkedList.Add(-6);
            this.linkedList.Add(32);
            this.linkedList.Add(1);
            this.linkedList.Add(100);
            this.linkedList.Add(1);

            Assert.AreEqual(ExpectedIndex, this.linkedList.LastIndexOf(43));
        }

        [TestMethod]
        public void TestGetEnumerator_FiveElements_ExpectedElementsInOrder()
        {
            const string ExpectedElements = "1 2 3 4 5 ";

            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);
            this.linkedList.Add(5);

            string elements = string.Empty;
            foreach (var item in this.linkedList)
            {
                elements += item + " ";
            }

            Assert.AreEqual(ExpectedElements, elements);
        }

        [TestMethod]
        public void TestGetEnumerator_FiveElementsRemovedOne_ExpectedElementsInOrder()
        {
            const string ExpectedElements = "1 3 4 5 ";

            this.linkedList.Add(1);
            this.linkedList.Add(2);
            this.linkedList.Add(3);
            this.linkedList.Add(4);
            this.linkedList.Add(5);
            this.linkedList.Remove(1);

            string elements = string.Empty;
            foreach (var item in this.linkedList)
            {
                elements += item + " ";
            }

            Assert.AreEqual(ExpectedElements, elements);
        }
    }
}
