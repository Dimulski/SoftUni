namespace Problem2TirePressureMonitoringSystem.Models
{
    using System;
    using Interfaces;

    public class PressureReader : IPressureReader
    {
        public double ReadPressureSample()
        {
            // Simulate info read from a real sensor in a real tire
            Random randomGenerator = new Random();
            return 6 * randomGenerator.NextDouble() * randomGenerator.NextDouble();
        }
    }
}
