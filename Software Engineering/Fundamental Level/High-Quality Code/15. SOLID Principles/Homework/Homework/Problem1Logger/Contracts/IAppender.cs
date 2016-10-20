namespace Problem1Logger.Contracts
{
    using Enumerations;

    public interface IAppender
    {
        ILayout Layout { get; }

        ReportLevel ReportLevel { get; set; }

        void Append(string message, ReportLevel reportLevel);
    }
}
