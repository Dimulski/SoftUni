namespace _08.LinkedQueueUnitTests
{
    using System;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using _07.LinkedQueue;

    [TestClass]
    public class LinkedQueueTests
    {
        private LinkedQueue<int> linkedQueue;

        [TestInitialize]
        public void Setup()
        {
            this.linkedQueue = new LinkedQueue<int>();
        }

        [TestMethod]
        public void TestCount_EmptyStack_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            Assert.AreEqual(ExpectedCount, this.linkedQueue.Count);
        }

        [TestMethod]
        public void TestEnqueue_EnqueueOneElement_ShouldBeOne()
        {
            const int ExpectedCount = 1;

            this.linkedQueue.Enqueue(12);

            Assert.AreEqual(ExpectedCount, this.linkedQueue.Count);
        }

        [TestMethod]
        public void TestEnqueue_EnqueueOneElementThenDequeueIt_ShouldReturnDequeuedElement()
        {
            const int ExpectedElement = -89;

            this.linkedQueue.Enqueue(-89);
            var element = this.linkedQueue.Dequeue();

            Assert.AreEqual(ExpectedElement, element);
        }

        [TestMethod]
        public void TestCount_EnqueueOneElementThenDequeueIt_ShouldBeZero()
        {
            const int ExpectedCount = 0;

            this.linkedQueue.Enqueue(2);
            this.linkedQueue.Dequeue();

            Assert.AreEqual(ExpectedCount, this.linkedQueue.Count);
        }

        [TestMethod]
        public void TestEnqueue_Enqueue1000Elements_CountShouldBe1000()
        {
            const int ExpectedCount = 1000;

            for (int i = 0; i < 1000; i++)
            {
                this.linkedQueue.Enqueue(i);
            }

            Assert.AreEqual(ExpectedCount, this.linkedQueue.Count);
        }

        [TestMethod]
        public void TestDequeue_Enqueue1000ElementsDequeue500_CountShouldBe500()
        {
            const int ExpectedCount = 500;

            for (int i = 0; i < 1000; i++)
            {
                this.linkedQueue.Enqueue(i);
            }

            for (int i = 0; i < 500; i++)
            {
                this.linkedQueue.Dequeue();
            }

            Assert.AreEqual(ExpectedCount, this.linkedQueue.Count);
        }

        [TestMethod]
        public void TestDequeue_Enqueue1000ElementsDequeue500_ExpectedDequeuedElements()
        {
            for (int i = 1; i <= 1000; i++)
            {
                this.linkedQueue.Enqueue(i);
            }

            for (int i = 1; i <= 500; i++)
            {
                var element = this.linkedQueue.Dequeue();

                Assert.AreEqual(i, element);
            }
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void TestDequeue_DequeueEmptyQueue_ExpectedInvalidOperationException()
        {
            this.linkedQueue.Dequeue();
        }

        [TestMethod]
        public void TestToArray_EnqueueFiveElements_CorrectOrder()
        {
            int[] expectedArray = new int[5]
            {
                1, 3, 0, 4, -7
            };

            this.linkedQueue.Enqueue(1);
            this.linkedQueue.Enqueue(3);
            this.linkedQueue.Enqueue(0);
            this.linkedQueue.Enqueue(4);
            this.linkedQueue.Enqueue(-7);

            var array = this.linkedQueue.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }

        [TestMethod]
        public void TestToArray_EmptyStack_EmptyArray()
        {
            int[] expectedArray = new int[0];

            var array = this.linkedQueue.ToArray();

            CollectionAssert.AreEqual(expectedArray, array);
        }
    }
}
