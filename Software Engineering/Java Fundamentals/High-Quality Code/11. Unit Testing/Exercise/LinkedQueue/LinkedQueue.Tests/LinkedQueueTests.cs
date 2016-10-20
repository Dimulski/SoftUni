namespace LinkedQueue.Tests
{
    using System;
    using System.Text;
    using _01.LinkedQueue;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class LinkedQueueTests
    {
        private LinkedQueue<int> queue;

        [TestInitialize]
        public void QueueInitialize()
        {
            this.queue = new LinkedQueue<int>();
        }

        [TestMethod]
        public void LinkedQueue_EnqueueDequeue_ShouldReturnExpectedElement()
        {
            // Arrange
            var element = 5;

            // Act
            this.queue.Enqueue(element);
            this.queue.Dequeue();

            // Assert
            Assert.AreEqual(0, this.queue.Count);
        }

        [TestMethod]
        public void Dequeue_EnqueueDequeueSeveralElements_ShouldReturnElementsInCorrectOrder()
        {
            var firstElement = 5;
            var secondElement = 10;
            var thirdElement = 20;
            var stringBuilder = new StringBuilder();

            this.queue.Enqueue(firstElement);
            this.queue.Enqueue(secondElement);
            this.queue.Enqueue(thirdElement);
            stringBuilder.Append(this.queue.Dequeue() + " ");
            stringBuilder.Append(this.queue.Dequeue() + " ");
            stringBuilder.Append(this.queue.Dequeue().ToString());

            Assert.AreEqual("5 10 20", stringBuilder.ToString(), "The string should match the stringbuilder value!");
        }

        [TestMethod]
        public void Count_EnqueueElements_ShouldReturnCorrectCount()
        {
            this.queue.Enqueue(94);
            Assert.AreEqual(1, this.queue.Count, "The LinkedQueue.Count should show the correct count of the queue!");

            this.queue.Enqueue(80);
            Assert.AreEqual(2, this.queue.Count, "The LinkedQueue.Count should show the correct count of the queue!");

            this.queue.Enqueue(61);
            Assert.AreEqual(3, this.queue.Count, "The LinkedQueue.Count should show the correct count of the queue!");
        }

        [TestMethod]
        public void Count_EnqueueDequeueElements_ShouldReturnCorrectCount()
        {
            this.queue.Enqueue(88);
            this.queue.Enqueue(41);
            this.queue.Enqueue(54);
            this.queue.Enqueue(50);
            this.queue.Dequeue();
            Assert.AreEqual(3, this.queue.Count);

            this.queue.Dequeue();
            this.queue.Dequeue();
            Assert.AreEqual(1, this.queue.Count);
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void Dequeue_EmptyQueue_ShouldThrow()
        {
            this.queue.Dequeue();
        }
    }
}