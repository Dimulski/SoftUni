namespace Problem1Logger.Contracts
{
    using System.Collections.Generic;

    public interface ILogger
    {
        IEnumerable<IAppender> Appenders { get; }

        void Info(string message);

        void Warn(string message);

        void Error(string message);

        void Critical(string message);

        void Fatal(string message);
    }
}
