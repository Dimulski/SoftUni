using SIS.HTTP.Common;
using SIS.HTTP.Cookies;
using SIS.HTTP.Enums;
using SIS.HTTP.Exceptions;
using SIS.HTTP.Headers;
using SIS.HTTP.Headers.Contacts;
using SIS.HTTP.Requests.Contracts;
using SIS.HTTP.Sessions.Contracts;
using System;
using System.Collections.Generic;
using System.Linq;

namespace SIS.HTTP.Requests
{
    public class HttpRequest : IHttpRequest
    {
        public HttpRequest(string requestString)
        {
            CoreValidator.ThrowIfNullOrEmpty(requestString, nameof(requestString));

            FormData = new Dictionary<string, object>();
            QueryData = new Dictionary<string, object>();
            Headers = new HttpHeaderCollection();
            Cookies = new HttpCookieCollection();

            ParseRequest(requestString);
        }

        public string Path { get; private set; }
        public string Url { get; private set; }
        public Dictionary<string, object> FormData { get; }
        public Dictionary<string, object> QueryData { get; }
        public IHttpHeaderCollection Headers { get; }
        public HttpRequestMethod RequestMethod { get; private set; }
        public IHttpCookieCollection Cookies { get; }
        public IHttpSession Session { get; set; }

        private bool IsValidRequestLine(string[] requestLineParams)
        {
            return requestLineParams.Length == 3 && requestLineParams[2].Equals(GlobalConstants.HttpOneProtocolFragment);
        }

        private bool IsValidRequestQueryString(string queryString, string[] queryParameters)
        {
            CoreValidator.ThrowIfNullOrEmpty(queryString, nameof(queryString));

            //return queryParameters.Length > 1;
            return true; // regex query string
        }

        private void ParseRequestMethod(string[] requestLineParams)
        {
            bool parseResult = HttpRequestMethod.TryParse(requestLineParams[0], true,
                out HttpRequestMethod method);

            if (!parseResult)
            {
                throw new BadRequestException(
                    string.Format(GlobalConstants.UnsupportedHttpMethodExceptionMessage,
                        requestLineParams[0]));
            }

            RequestMethod = method;
        }

        private void ParseRequestUrl(string[] requestLineParams)
        {
            Url = requestLineParams[1];
        }

        private void ParseRequestPath()
        {
            Path = Url.Split('?')[0];
        }

        private void ParseRequestHeaders(string[] plainHeaders)
        {
            plainHeaders.Select(plainHeader => plainHeader.Split(new[] { ": " }
                , StringSplitOptions.RemoveEmptyEntries))
                .ToList()
                .ForEach(headerKeyValuePair =>
                Headers.AddHeader(new HttpHeader(headerKeyValuePair[0], headerKeyValuePair[1])));
        }

        private void ParseCookies()
        {
            if (Headers.ContainsHeader(HttpHeader.Cookie))
            {
                string value = Headers.GetHeader(HttpHeader.Cookie).Value;
                string[] unparsedCookies = value.Split(new[] { "; " }, StringSplitOptions.RemoveEmptyEntries);

                foreach (string unparsedCookie in unparsedCookies)
                {
                    string[] cookieKeyValuePair = unparsedCookie.Split(new[] { '=' }, 2);

                    HttpCookie httpCookie = new HttpCookie(cookieKeyValuePair[0], cookieKeyValuePair[1], false);

                    Cookies.AddCookie(httpCookie);
                }
            }
        }

        private bool HasQueryString()
        {
            return Url.Split('?').Length > 1;
        }

        private void ParseRequestQueryParameters()
        {
            if (HasQueryString())
            {
                Url.Split('?', '#')[1]
                    .Split('&')
                    .Select(plainQueryParameter => plainQueryParameter.Split('='))
                    .ToList()
                    .ForEach(queryParameterKeyValuePair =>
                        QueryData.Add(queryParameterKeyValuePair[0], queryParameterKeyValuePair[1]));
            }
        }

        private void ParseRequestFormDataParameters(string requestBody)
        {
            if (!string.IsNullOrEmpty(requestBody))
            {
                // TODO: Parse multiple parameters by Name
                requestBody
                    .Split('&')
                    .Select(plainQueryParameter => plainQueryParameter.Split('='))
                    .ToList()
                    .ForEach(queryParameterKeyValuePair =>
                        FormData.Add(queryParameterKeyValuePair[0], queryParameterKeyValuePair[1]));
            }
        }

        private void ParseRequestParameters(string requestBody)
        {
            ParseRequestQueryParameters();
            ParseRequestFormDataParameters(requestBody);
        }

        private IEnumerable<string> ParsePlainRequestHeaders(string[] requestLines)
        {
            for (int i = 1; i < requestLines.Length - 1; i++)
            {
                if (!string.IsNullOrEmpty(requestLines[i]))
                {
                    yield return requestLines[i];
                }
            }
        }

        private void ParseRequest(string requestString)
        {
            string[] splitRequestString = requestString
                .Split(new[] { GlobalConstants.HttpNewLine }, StringSplitOptions.None);

            string[] requestLineParams = splitRequestString[0].Trim()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            if (!this.IsValidRequestLine(requestLineParams))
            {
                throw new BadRequestException();
            }

            ParseRequestMethod(requestLineParams);
            ParseRequestUrl(requestLineParams);
            ParseRequestPath();

            ParseRequestHeaders(ParsePlainRequestHeaders(splitRequestString).ToArray());
            ParseCookies();

            ParseRequestParameters(splitRequestString[splitRequestString.Length - 1]);
        }
    }
}
