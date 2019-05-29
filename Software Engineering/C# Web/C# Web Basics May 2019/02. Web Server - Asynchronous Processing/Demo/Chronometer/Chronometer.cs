using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace Chronometer
{
    public class Chronometer : IChronometer
    {
        private long milliseconds { get; set; }
        private bool isRunning;

        public Chronometer()
        {
            Reset();
        }

        public string GetTime => $"{milliseconds / 60000:D2}:{milliseconds / 1000:D2}:{milliseconds % 1000:D4}";

        public List<string> Laps { get; private set; }

        public string Lap()
        {
            string lap = GetTime;
            Laps.Add(lap);
            return lap;
        }

        public void Stop()
        {
            isRunning = false;
        }

        public void Reset()
        {
            Stop();
            milliseconds = 0;
            Laps = new List<string>();
        }

        public void Start()
        {
            isRunning = true;

            Task.Run(() =>
            {
                while (isRunning)
                {
                    Thread.Sleep(1);
                    milliseconds++;
                }
            });
        }
    }
}
