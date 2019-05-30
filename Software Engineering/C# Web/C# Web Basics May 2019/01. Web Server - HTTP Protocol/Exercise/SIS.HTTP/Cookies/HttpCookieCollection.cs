using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace SIS.HTTP.Cookies
{
    public class HttpCookieCollection : IHttpCookieCollection
    {
        public void AddCookie(HttpCookie cookie)
        {
            throw new NotImplementedException();
        }

        public bool ContainsCookie(string key)
        {
            throw new NotImplementedException();
        }

        public HttpCookie GetCookie(string key)
        {
            throw new NotImplementedException();
        }

        public IEnumerator<HttpCookie> GetEnumerator()
        {
            throw new NotImplementedException();
        }

        public bool HasCookies()
        {
            throw new NotImplementedException();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }

        public override string ToString()
        {
            return string.Join(HttpCookieStringSeparator, cookies.Values);
        }
    }
}
