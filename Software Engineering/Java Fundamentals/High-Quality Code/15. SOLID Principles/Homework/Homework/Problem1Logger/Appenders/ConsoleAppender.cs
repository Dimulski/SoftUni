namespace Problem1Logger.Appenders
{
    using System;
    using Contracts;
    using Enumerations;

    class ConsoleAppender : IAppender
    {
        public ConsoleAppender(ILayout layout)
        {
            this.Layout = layout;
        }

        public ILayout Layout { get; }

        public ReportLevel ReportLevel { get; set; }

        public void Append(string message, ReportLevel reportLevel)
        {
            if ((int)reportLevel >= (int)this.ReportLevel)
            {
                string formattedMessage = this.Layout.Format(DateTime.Now, reportLevel, message);
                Console.WriteLine(formattedMessage);
            }
        }
    }
}
