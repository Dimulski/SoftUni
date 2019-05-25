using System;

namespace SIS.HTTP.Exceptions
{
    public class BadRequestException : Exception
    {
        private const string message = "The Request was malformed or contains unsupported elements.";

        public BadRequestException() : this(message)
        {
        }

        public BadRequestException(string message) : base(message)
        {
        }
    }
}
