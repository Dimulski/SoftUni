namespace Problem2TirePressureMonitoringSystem
{
    using Models;

    public class Sensor
    {
        const double Offset = 16;
        
        public double PopNextPressurePsiValue(PressureReader reader)
        {
            double pressureTelemetryValue = reader.ReadPressureSample();

            return Offset + pressureTelemetryValue;
        }
    }
}
