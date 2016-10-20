namespace Problem4ArrayBasedStackTests
{
    using System;
    using System.Collections.Generic;

    using Microsoft.VisualStudio.TestTools.UnitTesting;

    using Problem3ArrayBasedStack;

    [TestClass]
    public class ArrayBasedStackTests
    {
        private ArrayStack<int> stack;

        [TestInitialize]
        public void TestStackInitialize()
        {
            this.stack = new ArrayStack<int>();
        }
        
        [TestMethod]
        public void InitializeStack_ShouldSetProperCount()
        {
            Assert.AreEqual(0, this.stack.Count);
        }

        [TestMethod]
        public void Push_ShouldChangeCountAccordingly()
        {
            this.stack.Push(1);

            Assert.AreEqual(1, this.stack.Count);
        }

        [TestMethod]
        public void Pop_ShouldReturnProperElement()
        {
            this.stack.Push(2);
            var element = this.stack.Pop();

            Assert.AreEqual(2, element);
        }

        [TestMethod]
        public void Pop_ShouldChangeCountAccordingly()
        {
            this.stack.Push(3);
            this.stack.Pop();

            Assert.AreEqual(0, this.stack.Count);
        }

        [TestMethod]
        public void PushElement1000Times_ShouldChangeCountAccordingly()
        {
            for (int i = 1; i <= 1000; i++)
            {
                this.stack.Push(i);

                Assert.AreEqual(i, this.stack.Count);
            }
        }

        [TestMethod]
        public void PopElement1000Times_ShouldReturnProperElementAndCount()
        {
            var count = 1000;
            for (int i = 0; i < 1000; i++)
            {
                this.stack.Push(count--);
            }

            count = 1000;
            for (int i = 0; i < 1000; i++)
            {
                var element = this.stack.Pop();
                count--;

                Assert.AreEqual(i + 1, element);
                Assert.AreEqual(count, this.stack.Count);
            }
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void Pop_EmptyArrayStack_ShouldThrow()
        {
            this.stack.Pop();
        }

        [TestMethod]
        public void PushPop_WithInitialCapacity1_ShouldReturnProperCountAndElements()
        {
            var stack = new ArrayStack<int>(1);
            Assert.AreEqual(0, stack.Count);

            stack.Push(5);
            Assert.AreEqual(1, stack.Count);

            stack.Push(10);
            Assert.AreEqual(2, stack.Count);

            var element = stack.Pop();
            Assert.AreEqual(10, element);
            Assert.AreEqual(1, stack.Count);

            element = stack.Pop();
            Assert.AreEqual(5, element);
            Assert.AreEqual(0, stack.Count);
        }

        [TestMethod]
        public void ToArray_ReturnsElementsInCorrectOrder()
        {
            this.stack.Push(3);
            this.stack.Push(5);
            this.stack.Push(-2);
            this.stack.Push(7);

            var result = this.stack.ToArray();

            CollectionAssert.AreEqual(new int[] { 7, -2, 5, 3 }, result);
        }

        [TestMethod]
        public void ToArray_OnEmptyArrayStack_ShouldReturnEmptyArray()
        {
            var dateTimeArrayStack = new ArrayStack<DateTime>();
            var result = dateTimeArrayStack.ToArray();

            CollectionAssert.AreEqual(new DateTime[] { }, result);
        }
    }
}
