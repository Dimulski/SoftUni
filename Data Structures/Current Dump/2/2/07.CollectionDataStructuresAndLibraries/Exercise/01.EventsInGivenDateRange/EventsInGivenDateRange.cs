namespace _01.EventsInGivenDateRange
{
    using System;
    using Wintellect.PowerCollections;

    public class EventsInGivenDateRange
    {
        public static void Main()
        {
            var events = new OrderedMultiDictionary<DateTime, string>(true);
            int numberOfEvents = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfEvents; i++)
            {
                string[] eventArgs = Console.ReadLine().Split('|');
                DateTime date = DateTime.Parse(eventArgs[1].Trim());
                string @event = eventArgs[0].Trim();

                if (!events.ContainsKey(date))
                {
                    events.Add(date, @event);
                }
                else
                {
                    events[date].Add(@event);
                }
            }

            int numberOfDates = int.Parse(Console.ReadLine());
            for (int i = 0; i < numberOfDates; i++)
            {
                string[] rangeArgs = Console.ReadLine().Split('|');
                DateTime start = DateTime.Parse(rangeArgs[0].Trim());
                DateTime end = DateTime.Parse(rangeArgs[1].Trim());

                var range = events.Range(start, true, end, true);
                Console.WriteLine(range.Values.Count);
                foreach (var date in range.Keys)
                {
                    foreach (var @event in range[date])
                    {
                        Console.WriteLine("{0} | {1}", @event, date.ToString());
                    }
                }
            }
        }
    }
}
