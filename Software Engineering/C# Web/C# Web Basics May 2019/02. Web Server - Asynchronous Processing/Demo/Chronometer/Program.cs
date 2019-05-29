using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Chronometer
{
    class Program
    {
        public static void Main()
        {
            IChronometer chronometer = new Chronometer();
            string inputLine = string.Empty;
            while ((inputLine = Console.ReadLine()) != "exit")
            {
                switch (inputLine)
                {
                    case "start":
                    {
                        chronometer.Start();
                        break;
                    }
                    case "stop":
                    {
                        chronometer.Stop();
                        break;
                    }
                    case "lap":
                    {
                        Console.WriteLine(chronometer.Lap());
                        break;
                    }
                    case "time":
                    {
                        Console.WriteLine(chronometer.GetTime);
                        break;
                    }
                    case "laps":
                    {
                        Console.WriteLine("Laps: " + (chronometer.Laps.Count == 0
                            ? "no laps."
                            : "\r\n" + string.Join("\r\n", chronometer
                                .Laps
                                .Select((lap, index) => $"{index}. {lap}"))));
                        break;
                    }
                    case "reset":
                    {
                        chronometer.Reset();
                        break;
                    }
                }
            }
        }
    }
}