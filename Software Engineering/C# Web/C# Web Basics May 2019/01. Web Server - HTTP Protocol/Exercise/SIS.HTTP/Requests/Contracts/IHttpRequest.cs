﻿using SIS.HTTP.Enums;
using SIS.HTTP.Headers.Contacts;
using System.Collections.Generic;

namespace SIS.HTTP.Requests.Contracts
{
    public class IHttpRequest
    {
        string Path { get; }

        string Url { get; }

        Dictionary<string, object> FormData { get; }

        Dictionary<string, object> QueryData { get; }

        IHttpHeaderCollection Headers { get; }

        HttpRequestMethod RequestMethod { get; }
    }
}
