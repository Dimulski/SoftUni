using System;

namespace SIS.HTTP.Exceptions
{
    public class InternalServerErrorException : Exception
    {
        private const string message = "The Server has encountered an error.";

        public InternalServerErrorException() : this(message)
        {
        }
        public InternalServerErrorException(string message) : base(message)
        {
        }
    }
}
