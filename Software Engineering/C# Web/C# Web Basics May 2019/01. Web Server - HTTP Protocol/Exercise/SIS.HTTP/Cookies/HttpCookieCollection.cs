using SIS.HTTP.Common;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace SIS.HTTP.Cookies
{
    public class HttpCookieCollection : IHttpCookieCollection
    {
        private Dictionary<string, HttpCookie> httpCookies;
        private string HttpCookieStringSeparator = "; ";

        public HttpCookieCollection()
        {
            httpCookies = new Dictionary<string, HttpCookie>();
        }

        public void AddCookie(HttpCookie httpCookie)
        {
            CoreValidator.ThrowIfNull(httpCookie, nameof(httpCookie));

            if (!this.ContainsCookie(httpCookie.Key))
            {
                httpCookies.Add(httpCookie.Key, httpCookie);

            }
        }

        public bool ContainsCookie(string key)
        {
            CoreValidator.ThrowIfNullOrEmpty(key, nameof(key));

            return httpCookies.ContainsKey(key);
        }

        public HttpCookie GetCookie(string key)
        {
            CoreValidator.ThrowIfNullOrEmpty(key, nameof(key));

            // TODO: Validation for existing parameter

            return httpCookies[key];
        }

        public bool HasCookies()
        {
            return httpCookies.Count != 0;
        }

        public IEnumerator<HttpCookie> GetEnumerator()
        {
            return httpCookies.Values.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();

            foreach (var cookie  in httpCookies.Values)
            {
                sb.Append($"Set-Cookie: {cookie}").Append(GlobalConstants.HttpNewLine);
            }

            return sb.ToString();
        }
    }
}
