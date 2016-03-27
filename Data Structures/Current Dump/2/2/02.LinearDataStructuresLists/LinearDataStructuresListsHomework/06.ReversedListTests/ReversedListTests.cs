namespace _06.ReversedListTests
{
    using System;
    using _06.ReversedList;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class ReversedListTests
    {
        private ReversedList<int> reversedList;

        [TestInitialize]
        public void Setup()
        {
            this.reversedList = new ReversedList<int>();
        }

        [TestMethod]
        public void TestCount_NoElements_ShouldReturnZero()
        {
            const int ExpectedCount = 0;

            Assert.AreEqual(ExpectedCount, this.reversedList.Count);
        }

        [TestMethod]
        public void TestAdd_AddedThreeElements_CountShouldBeThree()
        {
            const int ExpectedCount = 3;

            this.reversedList.Add(12);
            this.reversedList.Add(1);
            this.reversedList.Add(-3);

            Assert.AreEqual(ExpectedCount, this.reversedList.Count);
        }

        [TestMethod]
        public void TestCount_AddElementsThenRemoveSome_ShouldReturnTwo()
        {
            const int ExpectedCount = 2;

            this.reversedList.Add(12);
            this.reversedList.Add(1);
            this.reversedList.Add(-3);
            this.reversedList.Add(5432);
            this.reversedList.Remove(0);
            this.reversedList.Remove(1);

            Assert.AreEqual(ExpectedCount, this.reversedList.Count);
        }

        [TestMethod]
        public void TestRemove_RemoveOneElement_ExpectedRemovedElement()
        {
            const int ExpectedElement = 10;

            this.reversedList.Add(1);
            this.reversedList.Add(5);
            this.reversedList.Add(11);
            this.reversedList.Add(10);
            this.reversedList.Add(100);
            this.reversedList.Add(-1);

            int removedElement = this.reversedList.Remove(2);

            Assert.AreEqual(ExpectedElement, removedElement);
        }

        [TestMethod]
        public void TestIndex_AddedFiveElements_ExpectedThirdElement()
        {
            const int ExpectedElement = 5;

            this.reversedList.Add(1);
            this.reversedList.Add(5);
            this.reversedList.Add(11);
            this.reversedList.Add(10);
            this.reversedList.Add(100);

            Assert.AreEqual(ExpectedElement, this.reversedList[3]);
        }

        [TestMethod]
        public void TestIndex_OneElement_ExpectedElement()
        {
            const int ExpectedElement = 132;

            this.reversedList.Add(132);

            Assert.AreEqual(ExpectedElement, this.reversedList[0]);
        }

        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestIndex_NegativeIndex_ExpectedIndexOutOfRangeException()
        {
            this.reversedList.Add(132);
            this.reversedList.Add(354);
            this.reversedList.Add(-4);

            int number = this.reversedList[-1];
        }

        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestIndex_IndexHigherThanCount_ExpectedIndexOutOfRangeException()
        {
            this.reversedList.Add(132);
            this.reversedList.Add(354);
            this.reversedList.Add(-4);

            int number = this.reversedList[10];
        }

        [TestMethod]
        public void TestGetEnumerator_FiveElements_ExpectedReversedOrder()
        {
            const string ExpectedList = "15 0 -4 3 132 ";

            this.reversedList.Add(132);
            this.reversedList.Add(3);
            this.reversedList.Add(-4);
            this.reversedList.Add(0);
            this.reversedList.Add(15);

            string list = string.Empty;
            foreach (var number in this.reversedList)
            {
                list += number + " ";
            }

            Assert.AreEqual(ExpectedList, list);
        }
    }
}
