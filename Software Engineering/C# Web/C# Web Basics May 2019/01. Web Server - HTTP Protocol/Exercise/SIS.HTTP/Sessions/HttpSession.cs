using SIS.HTTP.Common;
using SIS.HTTP.Sessions.Contracts;
using System.Collections.Generic;

namespace SIS.HTTP.Sessions
{
    public class HttpSession : IHttpSession
    {
        private readonly Dictionary<string, object> sessionParameters;

        public HttpSession(string id)
        {
            Id = id;
            sessionParameters = new Dictionary<string, object>();
        }

        public string Id { get; }

        public object GetParameter(string parameterName)
        {
            CoreValidator.ThrowIfNullOrEmpty(parameterName, nameof(parameterName));

            // TODO: Validation for existing parameter

            return sessionParameters[parameterName];
        }

        public bool ContainsParameter(string parameterName)
        {
            CoreValidator.ThrowIfNullOrEmpty(parameterName, nameof(parameterName));

            return sessionParameters.ContainsKey(parameterName);
        }

        public void AddParameter(string parameterName, object parameter)
        {
            CoreValidator.ThrowIfNullOrEmpty(parameterName, nameof(parameterName));
            CoreValidator.ThrowIfNull(parameter, nameof(parameter));

            sessionParameters[parameterName] = parameter;
        }

        public void ClearParameters()
        {
            sessionParameters.Clear();
        }
    }
}
