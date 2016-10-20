namespace Problem1Logger.Layouts
{
    using System;
    using Contracts;
    using Enumerations;

    class SimpleLayout : ILayout
    {
        public string Format(DateTime date, ReportLevel reportLevel, string message)
        {
            string formattedString = string.Format("{0} - {1} - {2}", date, reportLevel, message);
            return formattedString;
        }
    }
}
