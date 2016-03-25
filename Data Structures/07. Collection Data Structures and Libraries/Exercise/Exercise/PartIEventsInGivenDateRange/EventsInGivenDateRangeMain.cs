namespace PartIEventsInGivenDateRange
{
    using System;
    using System.Globalization;
    using System.Threading;

    using Wintellect.PowerCollections;

    class EventsInGivenDateRangeMain
    {
        static void Main()
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;

            var events = new OrderedMultiDictionary<DateTime, string>(true);
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string eventEntry = Console.ReadLine();
                var eventTokens = eventEntry.Split('|');
                string eventName = eventTokens[0].Trim();
                DateTime eventDate = DateTime.Parse(eventTokens[1].Trim());
                events.Add(eventDate, eventName);
            }

            var numberOfRequests = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfRequests; i++)
            {
                var requestLine = Console.ReadLine().Split('|');
                DateTime startDate = DateTime.Parse(requestLine[0].Trim());
                DateTime endDate = DateTime.Parse(requestLine[1].Trim());
                var eventsInRange = events.Range(startDate, true, endDate, true);

                Console.WriteLine(eventsInRange.KeyValuePairs.Count);
                foreach (var e in eventsInRange)
                {
                    foreach (var eventName in e.Value)
                    {
                        Console.WriteLine("{0} | {1:dd-MMM-yyyy}", eventName, e.Key);
                    }
                }
            }
        }
    }
}
