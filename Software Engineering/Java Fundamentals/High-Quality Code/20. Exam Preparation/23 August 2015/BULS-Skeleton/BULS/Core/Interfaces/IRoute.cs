namespace BangaloreUniversityLearningSystem.Core.Interfaces
{
    using System.Collections.Generic;

    /// <summary>
    /// Serves to extract and hold information from the URL
    /// </summary>
    public interface IRoute
    {
        /// <summary>
        /// Holds the name(type) of the current controller
        /// </summary>
        string ControllerName { get; }

        /// <summary>
        /// Holds the name of the current operation/task 
        /// </summary>
        string ActionName { get; }

        /// <summary>
        /// Holds pairs of command parameter names and values
        /// </summary>
        IDictionary<string, string> Parameters { get; }
    }
}
