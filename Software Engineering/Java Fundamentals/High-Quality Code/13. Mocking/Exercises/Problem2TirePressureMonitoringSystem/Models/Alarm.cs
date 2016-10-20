// "You are given a small project for a system which monitors the pressure in car tires. Your task is to write unit tests for the system.
// You will need to use mocking in order to pass dependencies. Think about the corner cases of the project."
// 
// I have no idea what im supposed to be testing. The Sensor.PopNextPressurePsiValue() always returns from 0 to 22 and the Alarm.Check() returns
// true or false depending on the pressure value... I am supposed to test the Check method by mocking the sensor method? Seems pretty simple and
// pointless.

namespace Problem2TirePressureMonitoringSystem
{
    using Problem2TirePressureMonitoringSystem.Interfaces;
    using Problem2TirePressureMonitoringSystem.Models;

    public class Alarm
    {
        private const double LowPressureThreshold = 17;
        private const double HighPressureThreshold = 21;
        readonly PressureReader reader = new PressureReader();
        bool _alarmOn = false;

        public void Check(Sensor sensor)
        {
            double psiPressureValue = sensor.PopNextPressurePsiValue(reader);

            if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
            {
                _alarmOn = true;
            }
        }

        public bool AlarmOn
        {
            get { return _alarmOn; }
        }
    }
}
