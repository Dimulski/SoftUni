namespace Problem1Logger.Models
{
    using System.Collections.Generic;
    using Contracts;
    using Enumerations;

    public class Logger : ILogger
    {
        public Logger(params IAppender[] appenders)
        {
            this.Appenders = appenders;
        }

        public IEnumerable<IAppender> Appenders { get; }

        public void Info(string message)
        {
            foreach (var appender in Appenders)
            {
                appender.Append(message, ReportLevel.Info);
            }
        }

        public void Warn(string message)
        {
            foreach (var appender in this.Appenders)
            {
                appender.Append(message, ReportLevel.Warn);
            }
        }

        public void Error(string message)
        {
            foreach (var appender in this.Appenders)
            {
                appender.Append(message, ReportLevel.Error);
            }
        }

        public void Critical(string message)
        {
            foreach (var appender in this.Appenders)
            {
                appender.Append(message, ReportLevel.Critical);
            }
        }

        public void Fatal(string message)
        {
            foreach (var appender in this.Appenders)
            {
                appender.Append(message, ReportLevel.Fatal);
            }
        }
    }
}
