namespace Problem6LinkedStackTests
{
    using System;

    using Microsoft.VisualStudio.TestTools.UnitTesting;

    using Problem5LinkedStack;

    [TestClass]
    public class LinkedStackTests
    {
        private LinkedStack<int> stack;

        [TestInitialize]
        public void TestStackInitialize()
        {
            this.stack = new LinkedStack<int>();
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

            this.stack.Push(2);
            this.stack.Push(3);
            this.stack.Push(4);

            Assert.AreEqual(4, this.stack.Count);
        }

        [TestMethod]
        public void Pop_ShouldReturnProperElement()
        {
            this.stack.Push(25);
            var element = this.stack.Pop();

            Assert.AreEqual(25, element);
        }

        [TestMethod]
        public void Pop_ShouldChangeCountAccordingly()
        {
            this.stack.Push(3);
            this.stack.Push(3);
            this.stack.Push(3);
            this.stack.Push(3);
            this.stack.Push(3);
            this.stack.Pop();
            this.stack.Pop();
            this.stack.Pop();

            Assert.AreEqual(2, this.stack.Count);
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
        public void Pop_EmptyLinkedStack_ShouldThrow()
        {
            this.stack.Pop();
        }

        [TestMethod]
        public void PushPop_ShouldReturnProperCountAndElements()
        {
            var stringStack = new LinkedStack<string>();
            Assert.AreEqual(0, stringStack.Count);

            stringStack.Push("five");
            Assert.AreEqual(1, stringStack.Count);

            stringStack.Push("ten");
            Assert.AreEqual(2, stringStack.Count);

            var element = stringStack.Pop();
            Assert.AreEqual("ten", element);
            Assert.AreEqual(1, stringStack.Count);

            element = stringStack.Pop();
            Assert.AreEqual("five", element);
            Assert.AreEqual(0, stringStack.Count);
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
        public void ToArray_OnEmptyLinkedStack_ShouldReturnEmptyArray()
        {
            var dateTimeArrayStack = new LinkedStack<DateTime>();
            var result = dateTimeArrayStack.ToArray();

            CollectionAssert.AreEqual(new DateTime[] { }, result);
        }
    }
}
