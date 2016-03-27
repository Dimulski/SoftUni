namespace _04.ArrayBasedStackUnitTests
{
    using System;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using _03.ImplementAnArrayBasedStack;

    [TestClass]
    public class ArrayStackTests
    {
        private ArrayStack<int> arrayStack;

        [TestInitialize]
        public void Setup()
        {
            this.arrayStack = new ArrayStack<int>();
        }

        [TestMethod]
        public void TestCount_EmptyStack_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            Assert.AreEqual(ExpectedCount, this.arrayStack.Count);
        }

        [TestMethod]
        public void TestPush_PushOneElement_ShouldBeOne()
        {
            const int ExpectedCount = 1;

            this.arrayStack.Push(12);

            Assert.AreEqual(ExpectedCount, this.arrayStack.Count);
        }

        [TestMethod]
        public void TestPop_PushOneElementThenPopIt_ShouldReturnPoppedElement()
        {
            const int ExpectedElement = -89;

            this.arrayStack.Push(-89);
            var element = this.arrayStack.Pop();

            Assert.AreEqual(ExpectedElement, element);
        }

        [TestMethod]
        public void TestCount_PushOneElementThenPopIt_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            this.arrayStack.Push(2);
            this.arrayStack.Pop();

            Assert.AreEqual(ExpectedCount, this.arrayStack.Count);
        }

        [TestMethod]
        public void TestPush_Push1000Elements_CountShouldBe1000()
        {
            const int ExpectedCount = 1000;

            for (int i = 0; i < 1000; i++)
            {
                this.arrayStack.Push(i);
            }

            Assert.AreEqual(ExpectedCount, this.arrayStack.Count);
        }

        [TestMethod]
        public void TestPop_Push1000ElementsPop500_CountShouldBe500()
        {
            const int ExpectedCount = 500;

            for (int i = 0; i < 1000; i++)
            {
                this.arrayStack.Push(i);
            }

            for (int i = 0; i < 500; i++)
            {
                this.arrayStack.Pop();
            }

            Assert.AreEqual(ExpectedCount, this.arrayStack.Count);
        }

        [TestMethod]
        public void TestPop_Push1000ElementsPop500_ExpectedPoppedElements()
        {
            for (int i = 1; i <= 1000; i++)
            {
                this.arrayStack.Push(i);
            }

            for (int i = 1000; i >= 500; i--)
            {
                var element = this.arrayStack.Pop();

                Assert.AreEqual(i, element);
            }
        }

        [TestMethod]
        [ExpectedException(typeof (InvalidOperationException))]
        public void TestPop_PopEmptyStack_ExpectedInvalidOperationException()
        {
            this.arrayStack.Pop();
        }

        [TestMethod]
        public void TestCapacity_SetCapacityTo1_ExpectCapacityOne()
        {
            const int ExpectedCapacity = 1;

            var stack = new ArrayStack<int>(1);

            Assert.AreEqual(ExpectedCapacity, stack.Capacity);
        }

        [TestMethod]
        public void TestCount_SetCapacityTo1_CountShouldBeOne()
        {
            const int ExpectedCount = 1;

            var stack = new ArrayStack<int>(1);
            stack.Push(12);

            Assert.AreEqual(ExpectedCount, stack.Count);
        }

        [TestMethod]
        public void TestCount_SetCapacityTo1_CountShouldBeTwo()
        {
            const int ExpectedCount = 2;

            var stack = new ArrayStack<int>(1);
            stack.Push(12);
            stack.Push(12);

            Assert.AreEqual(ExpectedCount, stack.Count);
        }

        [TestMethod]
        public void TestCount_SetCapacityTo1_CountShouldBeZero()
        {
            const int ExpectedCount = 0;

            var stack = new ArrayStack<int>(1);
            stack.Push(12);
            stack.Pop();

            Assert.AreEqual(ExpectedCount, stack.Count);
        }

        [TestMethod]
        public void TestToArray_PushFiveElements_ReversedOrder()
        {
            int[] expectedArray = new int[5]
            {
                -7, 4, 0, 3, 1
            };

            this.arrayStack.Push(1);
            this.arrayStack.Push(3);
            this.arrayStack.Push(0);
            this.arrayStack.Push(4);
            this.arrayStack.Push(-7);

            var array = this.arrayStack.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }

        [TestMethod]
        public void TestToArray_EmptyStack_EmptyArray()
        {
            int[] expectedArray = new int[0];

            var array = this.arrayStack.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }
    }
}
