namespace SingleResponsibilityBooksAfter
{
    using System.Collections.Generic;

    public class Library
    {
        private IList<Book> books;

        public Library()
        {
            this.books = new List<Book>();
        }

        public Book FindBook(string title)
        {
            // Logic for finding book ...
            return null;
        }
    }
}
