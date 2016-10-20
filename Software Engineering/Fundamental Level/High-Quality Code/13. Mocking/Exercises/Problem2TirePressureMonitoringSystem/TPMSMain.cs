using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem2TirePressureMonitoringSystem
{
    using Problem2TirePressureMonitoringSystem.Models;

    class TPMSMain
    {
        static void Main(string[] args)
        {
            PressureReader reader = new PressureReader();
            Console.WriteLine(reader.ReadPressureSample());
            Sensor sensor = new Sensor();
            Alarm alarm = new Alarm();
            alarm.Check(sensor);
            Console.WriteLine(alarm.AlarmOn);
        }
    }
}
