namespace SIS.HTTP.Headers.Contacts
{
    public interface IHttpHeaderCollection
    {
        void AddHeader(HttpHeader header);

        bool ContainsHeader(string key);

        HttpHeader GetHeader(string key);
    }
}
