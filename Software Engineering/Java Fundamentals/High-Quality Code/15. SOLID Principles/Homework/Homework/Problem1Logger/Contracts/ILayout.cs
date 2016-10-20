namespace Problem1Logger.Contracts
{
    using System;
    using Enumerations;

    public interface ILayout
    {
        string Format(DateTime date, ReportLevel reportLevel, string message);
    }
}
