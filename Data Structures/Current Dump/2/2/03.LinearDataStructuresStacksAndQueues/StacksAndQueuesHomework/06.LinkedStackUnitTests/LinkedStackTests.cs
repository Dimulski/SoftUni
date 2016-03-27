namespace _06.LinkedStackUnitTests
{
    using System;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using _05.LinkedStack;

    [TestClass]
    public class LinkedStackTests
    {
        private LinkedStack<int> linkedStack;

        [TestInitialize]
        public void Setup()
        {
            this.linkedStack = new LinkedStack<int>();
        }

        [TestMethod]
        public void TestCount_EmptyStack_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            Assert.AreEqual(ExpectedCount, this.linkedStack.Count);
        }

        [TestMethod]
        public void TestPush_PushOneElement_ShouldBeOne()
        {
            const int ExpectedCount = 1;

            this.linkedStack.Push(12);

            Assert.AreEqual(ExpectedCount, this.linkedStack.Count);
        }

        [TestMethod]
        public void TestPop_PushOneElementThenPopIt_ShouldReturnPoppedElement()
        {
            const int ExpectedElement = -89;

            this.linkedStack.Push(-89);
            var element = this.linkedStack.Pop();

            Assert.AreEqual(ExpectedElement, element);
        }

        [TestMethod]
        public void TestCount_PushOneElementThenPopIt_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            this.linkedStack.Push(2);
            this.linkedStack.Pop();

            Assert.AreEqual(ExpectedCount, this.linkedStack.Count);
        }

        [TestMethod]
        public void TestPush_Push1000Elements_CountShouldBe1000()
        {
            const int ExpectedCount = 1000;

            for (int i = 0; i < 1000; i++)
            {
                this.linkedStack.Push(i);
            }

            Assert.AreEqual(ExpectedCount, this.linkedStack.Count);
        }

        [TestMethod]
        public void TestPop_Push1000ElementsPop500_CountShouldBe500()
        {
            const int ExpectedCount = 500;

            for (int i = 0; i < 1000; i++)
            {
                this.linkedStack.Push(i);
            }

            for (int i = 0; i < 500; i++)
            {
                this.linkedStack.Pop();
            }

            Assert.AreEqual(ExpectedCount, this.linkedStack.Count);
        }

        [TestMethod]
        public void TestPop_Push1000ElementsPop500_ExpectedPoppedElements()
        {
            for (int i = 1; i <= 1000; i++)
            {
                this.linkedStack.Push(i);
            }

            for (int i = 1000; i >= 500; i--)
            {
                var element = this.linkedStack.Pop();

                Assert.AreEqual(i, element);
            }
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestPop_PopEmptyStack_ExpectedInvalidOperationException()
        {
            this.linkedStack.Pop();
        }

        [TestMethod]
        public void TestToArray_PushFiveElements_ReversedOrder()
        {
            int[] expectedArray = new int[5]
            {
                -7, 4, 0, 3, 1
            };

            this.linkedStack.Push(1);
            this.linkedStack.Push(3);
            this.linkedStack.Push(0);
            this.linkedStack.Push(4);
            this.linkedStack.Push(-7);

            var array = this.linkedStack.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }

        [TestMethod]
        public void TestToArray_EmptyStack_EmptyArray()
        {
            int[] expectedArray = new int[0];

            var array = this.linkedStack.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }
    }
}
