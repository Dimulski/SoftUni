﻿namespace BangaloreUniversityLearningSystem.Infrastructure
{
    using System;
    using System.Collections.Generic;
    using System.Net;

    using BangaloreUniversityLearningSystem.Core.Interfaces;

    public class Route : IRoute
    {
        public Route(string routeUrl)
        {
            this.Parse(routeUrl);
        }

        public IDictionary<string, string> Parameters { get; private set; }

        public string ActionName { get; private set; }

        public string ControllerName { get; private set; }

        private void Parse(string routeUrl)
        {
            string[] parts = routeUrl.Split(new[] { "/", "?" }, StringSplitOptions.RemoveEmptyEntries);
            if (parts.Length < 2)
            {
                throw new InvalidOperationException("The provided route is invalid.");
            }

            this.ControllerName = parts[0] + "Controller";
            this.ActionName = parts[1];
            if (parts.Length >= 3)
            {
                this.Parameters = new Dictionary<string, string>();
                string[] parameterPairs = parts[2].Split('&');
                foreach (var pair in parameterPairs)
                {
                    string[] nameValue = pair.Split('=');
                    this.Parameters.Add(WebUtility.UrlDecode(nameValue[0]), WebUtility.UrlDecode(nameValue[1])); // POTENTIAL BUG: Might be Encode r/d Decode
                }
            }
        }
    }
}
