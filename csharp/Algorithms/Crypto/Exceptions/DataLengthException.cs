using System;

namespace Algorithms.Crypto.Exceptions;

public class DataLengthException : CryptoException
{
    
    public DataLengthException()
    {
    }

    public DataLengthException(string message)
        : base(message)
    {
    }

    public DataLengthException(string message, Exception inner)
        : base(message, inner)
    {
    }
}
