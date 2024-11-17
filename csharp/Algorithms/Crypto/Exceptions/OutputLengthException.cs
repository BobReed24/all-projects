using System;

namespace Algorithms.Crypto.Exceptions;

public class OutputLengthException : DataLengthException
{
    
    public OutputLengthException()
    {
    }

    public OutputLengthException(string message)
        : base(message)
    {
    }

    public OutputLengthException(string message, Exception inner)
        : base(message, inner)
    {
    }
}
