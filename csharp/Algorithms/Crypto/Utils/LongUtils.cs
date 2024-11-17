using System.Numerics;

namespace Algorithms.Crypto.Utils;

public static class LongUtils
{
    
    public static long RotateLeft(long i, int distance)
    {
        return (long)BitOperations.RotateLeft((ulong)i, distance);
    }

    public static ulong RotateLeft(ulong i, int distance)
    {
        return BitOperations.RotateLeft(i, distance);
    }

    public static long RotateRight(long i, int distance)
    {
        return (long)BitOperations.RotateRight((ulong)i, distance);
    }

    public static ulong RotateRight(ulong i, int distance)
    {
        return BitOperations.RotateRight(i, distance);
    }
}
