using System;
using System.Diagnostics;
using Algorithms.Crypto.Exceptions;

namespace Algorithms.Crypto.Utils;

public static class ValidationUtils
{
    
    public static void CheckDataLength(byte[] buffer, int offset, int length, string message)
    {
        if (offset > (buffer.Length - length))
        {
            throw new DataLengthException(message);
        }
    }

    public static void CheckOutputLength(bool condition, string message)
    {
        if (condition)
        {
            throw new OutputLengthException(message);
        }
    }

    public static void CheckOutputLength(byte[] buffer, int offset, int length, string message)
    {
        if (offset > (buffer.Length - length))
        {
            throw new OutputLengthException(message);
        }
    }

    public static void CheckOutputLength<T>(Span<T> output, int length, string message)
    {
        if (output.Length > length)
        {
            throw new OutputLengthException(message);
        }
    }
}
