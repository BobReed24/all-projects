using System;
using System.Buffers.Binary;
using System.Runtime.CompilerServices;

namespace Algorithms.Crypto.Utils;

public static class ByteEncodingUtils
{
    
    public static ulong BigEndianToUint64(byte[] byteStream, int offset)
    {
        return BinaryPrimitives.ReadUInt64BigEndian(byteStream.AsSpan(offset));
    }

    [MethodImpl(MethodImplOptions.AggressiveInlining)]
    public static ulong BigEndianToUint64(ReadOnlySpan<byte> byteStream)
    {
        return BinaryPrimitives.ReadUInt64BigEndian(byteStream);
    }

    [MethodImpl(MethodImplOptions.AggressiveInlining)]
    public static void UInt64ToBigEndian(ulong value, Span<byte> byteStream)
    {
        BinaryPrimitives.WriteUInt64BigEndian(byteStream, value);
    }
}
