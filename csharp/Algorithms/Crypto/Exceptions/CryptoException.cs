using System;

namespace Algorithms.Crypto.Exceptions;

public class CryptoException : Exception
{
    
    public CryptoException()
    {
    }

    public CryptoException(string message)
        : base(message)
    {
    }

    public CryptoException(string message, Exception inner)
        : base(message, inner)
    {
    }
}
