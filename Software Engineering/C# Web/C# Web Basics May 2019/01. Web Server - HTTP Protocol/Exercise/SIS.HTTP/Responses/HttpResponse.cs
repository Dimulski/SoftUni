using SIS.HTTP.Common;
using SIS.HTTP.Enums;
using SIS.HTTP.Extensions;
using SIS.HTTP.Headers;
using SIS.HTTP.Headers.Contacts;
using SIS.HTTP.Responses.Contracts;
using System;
using System.Text;

namespace SIS.HTTP.Responses
{
    public class HttpResponse : IHttpResponse
    {
        public HttpResponse()
        {
            Headers = new HttpHeaderCollection();
            Content = new byte[0];
        }

        public HttpResponse(HttpResponseStatusCode statusCode) : this()
        {
            CoreValidator.ThrowIfNull(statusCode, nameof(statusCode));
            StatusCode = statusCode;
        }

        public HttpResponseStatusCode StatusCode { get; set; }

        public IHttpHeaderCollection Headers { get; }

        public byte[] Content { get; set; }

        public void AddHeader(HttpHeader header)
        {
            Headers.AddHeader(header);
        }

        public byte[] GetBytes()
        {
            byte[] httpResponseBytesWithoutBody = Encoding.UTF8.GetBytes(ToString());
            byte[] httpResponseBytesWithBody = new byte[httpResponseBytesWithoutBody.Length + Content.Length];

            for (int i = 0; i < httpResponseBytesWithoutBody.Length; i++)
            {
                httpResponseBytesWithBody[i] = httpResponseBytesWithoutBody[i];
            }
            for (int i = 0; i < httpResponseBytesWithBody.Length - httpResponseBytesWithoutBody.Length; i++)
            {
                httpResponseBytesWithBody[i + httpResponseBytesWithoutBody.Length] = this.Content[i];
            }

            return httpResponseBytesWithBody;
        }

        public override string ToString()
        {
            StringBuilder result = new StringBuilder();

            //HTTP/1.1

            result
                .Append($"{GlobalConstants.HttpOneProtocolFragment} {StatusCode.GetStatusLine()}").Append(GlobalConstants.HttpNewLine)
                .Append($"{Headers}").Append(GlobalConstants.HttpNewLine);

            result.Append(GlobalConstants.HttpNewLine);

            return result.ToString();
        }
    }
}
