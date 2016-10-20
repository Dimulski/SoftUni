namespace Problem1DateTime.Now.AddDays.Interfaces
{
    using System;

    public interface IDateTimeProvider
    {
        //DateTime DateTimeNow { get; }

        DateTime ProvideDateTimeNow();
    }
}