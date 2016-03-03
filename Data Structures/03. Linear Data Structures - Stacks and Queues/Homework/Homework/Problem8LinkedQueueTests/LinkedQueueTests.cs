namespace Problem8LinkedQueueTests
{
    using System;

    using Microsoft.VisualStudio.TestTools.UnitTesting;

    using Problem7LinkedQueue;

    [TestClass]
    public class LinkedQueueTests
    {
        private LinkedQueue<int> queue;

        [TestInitialize]
        public void TestStackInitialize()
        {
            this.queue = new LinkedQueue<int>();
        }

        [TestMethod]
        public void InitializeQueue_ShouldSetProperCount()
        {
            Assert.AreEqual(0, this.queue.Count);
        }

        [TestMethod]
        public void Enqueue_ShouldChangeCountAccordingly()
        {
            this.queue.Enqueue(1);

            Assert.AreEqual(1, this.queue.Count);

            this.queue.Enqueue(2);
            this.queue.Enqueue(3);
            this.queue.Enqueue(4);

            Assert.AreEqual(4, this.queue.Count);
        }

        [TestMethod]
        public void Dequeue_ShouldReturnProperElement()
        {
            this.queue.Enqueue(25);
            var element = this.queue.Dequeue();

            Assert.AreEqual(25, element);
        }

        [TestMethod]
        public void Dequeue_ShouldChangeCountAccordingly()
        {
            this.queue.Enqueue(3);
            this.queue.Enqueue(3);
            this.queue.Enqueue(3);
            this.queue.Enqueue(3);
            this.queue.Enqueue(3);
            this.queue.Dequeue();
            this.queue.Dequeue();
            this.queue.Dequeue();

            Assert.AreEqual(2, this.queue.Count);
        }

        [TestMethod]
        public void EnqueueElement1000Times_ShouldChangeCountAccordingly()
        {
            for (int i = 1; i <= 1000; i++)
            {
                this.queue.Enqueue(i);

                Assert.AreEqual(i, this.queue.Count);
            }
        }

        [TestMethod]
        public void DequeueElement1000Times_ShouldReturnProperElementAndCount()
        {
            var count = 1;
            for (int i = 0; i < 1000; i++)
            {
                this.queue.Enqueue(count++);
            }

            count = 1000;
            for (int i = 0; i < 1000; i++)
            {
                var element = this.queue.Dequeue();
                count--;

                Assert.AreEqual(i + 1, element);
                Assert.AreEqual(count, this.queue.Count);
            }
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void Dequeue_EmptyLinkedQueue_ShouldThrow()
        {
            this.queue.Dequeue();
        }

        [TestMethod]
        public void EnqueueDequeue_ShouldReturnProperCountAndElement()
        {
            var stringStack = new LinkedQueue<string>();
            Assert.AreEqual(0, stringStack.Count);

            stringStack.Enqueue("five");
            Assert.AreEqual(1, stringStack.Count);

            stringStack.Enqueue("ten");
            Assert.AreEqual(2, stringStack.Count);

            var element = stringStack.Dequeue();
            Assert.AreEqual("five", element);
            Assert.AreEqual(1, stringStack.Count);

            element = stringStack.Dequeue();
            Assert.AreEqual("ten", element);
            Assert.AreEqual(0, stringStack.Count);
        }

        [TestMethod]
        public void ToArray_ReturnsElementsInCorrectOrder()
        {
            this.queue.Enqueue(3);
            this.queue.Enqueue(5);
            this.queue.Enqueue(-2);
            this.queue.Enqueue(7);

            var result = this.queue.ToArray();

            CollectionAssert.AreEqual(new int[] { 3, 5, -2, 7 }, result);
        }

        [TestMethod]
        public void ToArray_OnEmptyLinkedQueue_ShouldReturnEmptyArray()
        {
            var dateTimeArrayStack = new LinkedQueue<DateTime>();
            var result = dateTimeArrayStack.ToArray();

            CollectionAssert.AreEqual(new DateTime[] { }, result);
        }
    }
}
