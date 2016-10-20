namespace Problem1DateTime.Now.AddDays.Tests
{
    using System;
    using Interfaces;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Moq;

    [TestClass]
    public class AddDaysTest
    {
        [TestMethod]
        public void AddDays_AddADayInMiddleOfMonth_ShouldChangeDate()
        {
            // Here I tried to do the same test with a property instead of a method (it works the same).
            //var mock = new Mock<IDateTimeProvider>();
            //mock.Setup(d => d.DateTimeNow).Returns(new DateTime(2016, 1, 25));

            //var date = mock.Object.DateTimeNow.AddDays(1);
            //var expected = new DateTime(2016, 1, 26);

            //Assert.AreEqual(expected, date);

            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(2016, 1, 26));

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
            var expected = new DateTime(2016, 1, 27);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        public void AddDays_AddDayAtEndOfMonth_ShouldChangeMonth()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(2016, 1, 31));

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
            var expected = new DateTime(2016, 2, 1);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        public void AddDays_AddNegativeDays_ShouldLowerDate()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(2016, 1, 26));

            var date = mock.Object.ProvideDateTimeNow().AddDays(-5);
            var expected = new DateTime(2016, 1, 21);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        public void AddDays_AddNegativeDaysAtBeginningOfMonth_ShouldLowerMonth()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(2016, 1, 3));

            var date = mock.Object.ProvideDateTimeNow().AddDays(-10);
            var expected = new DateTime(2015, 12, 24);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        public void AddDays_AddDayToLeapYear_ShouldNotChangeMonth()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(2008, 2, 28));

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
            var expected = new DateTime(2008, 2, 29);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        public void AddDays_AddDayToNonLeapYear_ShouldChangeMonth()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(new DateTime(1900, 2, 28));

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
            var expected = new DateTime(1900, 3, 1);

            Assert.AreEqual(expected, date);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void AddDays_AddDayToDateTimeMaxValue_ShouldThrow()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(DateTime.MaxValue);

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
        }

        [TestMethod]
        public void AddDays_AddDayToDateTimeMinValue_ShouldNotThrow()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(DateTime.MinValue);

            var date = mock.Object.ProvideDateTimeNow().AddDays(1);
        }

        [TestMethod]
        public void AddDays_AddNegativeDayToDateTimeMaxValue_ShouldNotThrow()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(DateTime.MaxValue);

            var date = mock.Object.ProvideDateTimeNow().AddDays(-1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void AddDays_AddNegativeDayToDateTimeMinValue_ShouldThrow()
        {
            var mock = new Mock<IDateTimeProvider>();
            mock.Setup(d => d.ProvideDateTimeNow()).Returns(DateTime.MinValue);

            var date = mock.Object.ProvideDateTimeNow().AddDays(-1);
        }
    }
}
