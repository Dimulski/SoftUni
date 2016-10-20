namespace Problem2TirePressureMonitoringSystem.Tests
{
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using Moq;

    using Interfaces;

    using Problem2TirePressureMonitoringSystem.Models;

    [TestClass]
    public class AlarmTests
    {
        [TestMethod]
        public void Check_WhenPressureIs22_ShouldReturnFalse()
        {
            var mockOne = new Mock<PressureReader>();
            mockOne.Setup(x => x.ReadPressureSample()).Returns(22);

            var mockTwo = new Mock<Sensor>();
            mockTwo.Setup(x => x.PopNextPressurePsiValue(mockOne.Object));

            Alarm alarm = new Alarm();
            alarm.Check(mockTwo.Object);

            bool boolean = alarm.AlarmOn;
            Assert.AreEqual(false, boolean);
        }
    }
}
