using System;
using System.Runtime.CompilerServices;
using Algorithms.Crypto.Utils;

namespace Algorithms.Crypto.Digests;

public class AsconDigest : IDigest
{
    public enum AsconParameters
    {
        
        AsconHash,

        AsconHashA,
    }

    private readonly AsconParameters asconParameters;

    private readonly int asconPbRounds;

    private readonly byte[] buffer = new byte[8];

    private ulong x0;

    private ulong x1;

    private ulong x2;

    private ulong x3;

    private ulong x4;

    private int bufferPosition;

    public AsconDigest(AsconParameters parameters)
    {
        
        asconParameters = parameters;

        asconPbRounds = parameters switch
        {
            AsconParameters.AsconHash => 12,  
            AsconParameters.AsconHashA => 8,  
            _ => throw new ArgumentException("Invalid parameter settings for Ascon Hash"), 
        };

        Reset();
    }

    public string AlgorithmName
    {
        get
        {
            return asconParameters switch
            {
                AsconParameters.AsconHash => "Ascon-Hash",  
                AsconParameters.AsconHashA => "Ascon-HashA", 
                _ => throw new InvalidOperationException(), 
            };
        }
    }

    public int GetDigestSize() => 32;

    public int GetByteLength() => 8;

    public void Update(byte input)
    {
        
        buffer[bufferPosition] = input;

        if (++bufferPosition != 8)
        {
            return; 
        }

        x0 ^= ByteEncodingUtils.BigEndianToUint64(buffer, 0);

        P(asconPbRounds);

        bufferPosition = 0;
    }

    public void BlockUpdate(byte[] input, int inOff, int inLen)
    {
        
        ValidationUtils.CheckDataLength(input, inOff, inLen, "input buffer too short");

        BlockUpdate(input.AsSpan(inOff, inLen));
    }

    public void BlockUpdate(ReadOnlySpan<byte> input)
    {
        
        var available = 8 - bufferPosition;

        if (input.Length < available)
        {
            input.CopyTo(buffer.AsSpan(bufferPosition)); 
            bufferPosition += input.Length; 
            return; 
        }

        if (bufferPosition > 0)
        {
            
            input[..available].CopyTo(buffer.AsSpan(bufferPosition));

            x0 ^= ByteEncodingUtils.BigEndianToUint64(buffer);
            P(asconPbRounds); 

            input = input[available..];
        }

        while (input.Length >= 8)
        {
            
            x0 ^= ByteEncodingUtils.BigEndianToUint64(input);
            P(asconPbRounds);

            input = input[8..];
        }

        input.CopyTo(buffer);
        bufferPosition = input.Length; 
    }

    public int DoFinal(byte[] output, int outOff)
    {
        
        return DoFinal(output.AsSpan(outOff));
    }

    public int DoFinal(Span<byte> output)
    {
        
        ValidationUtils.CheckOutputLength(output, 32, "output buffer too short");

        AbsorbAndFinish();

        ByteEncodingUtils.UInt64ToBigEndian(x0, output);

        for (var i = 0; i < 3; ++i)
        {
            
            output = output[8..];

            P(asconPbRounds);

            ByteEncodingUtils.UInt64ToBigEndian(x0, output);
        }

        Reset();

        return 32;
    }

    public string Digest(byte[] input)
    {
        return Digest(input.AsSpan());
    }

    public string Digest(Span<byte> input)
    {
        
        BlockUpdate(input);

        var output = new byte[GetDigestSize()];

        DoFinal(output, 0);

        return BitConverter.ToString(output).Replace("-", string.Empty).ToLowerInvariant();
    }

    public void Reset()
    {
        
        Array.Clear(buffer, 0, buffer.Length);

        bufferPosition = 0;

        switch (asconParameters)
        {
            
            case AsconParameters.AsconHashA:
                x0 = 92044056785660070UL;
                x1 = 8326807761760157607UL;
                x2 = 3371194088139667532UL;
                x3 = 15489749720654559101UL;
                x4 = 11618234402860862855UL;
                break;

            case AsconParameters.AsconHash:
                x0 = 17191252062196199485UL;
                x1 = 10066134719181819906UL;
                x2 = 13009371945472744034UL;
                x3 = 4834782570098516968UL;
                x4 = 3787428097924915520UL;
                break;

            default:
                throw new InvalidOperationException();
        }
    }

    private void AbsorbAndFinish()
    {
        
        buffer[bufferPosition] = 0x80;

        x0 ^= ByteEncodingUtils.BigEndianToUint64(buffer, 0) & (ulong.MaxValue << (56 - (bufferPosition << 3)));

        P(12);
    }

    private void P(int numberOfRounds)
    {
        if (numberOfRounds == 12)
        {
            Round(0xf0UL);
            Round(0xe1UL);
            Round(0xd2UL);
            Round(0xc3UL);
        }

        Round(0xb4UL);
        Round(0xa5UL);

        Round(0x96UL);
        Round(0x87UL);
        Round(0x78UL);
        Round(0x69UL);
        Round(0x5aUL);
        Round(0x4bUL);
    }

    [MethodImpl(MethodImplOptions.AggressiveInlining)]
    private void Round(ulong circles)
    {
        
        var t0 = x0 ^ x1 ^ x2 ^ x3 ^ circles ^ (x1 & (x0 ^ x2 ^ x4 ^ circles));
        var t1 = x0 ^ x2 ^ x3 ^ x4 ^ circles ^ ((x1 ^ x2 ^ circles) & (x1 ^ x3));
        var t2 = x1 ^ x2 ^ x4 ^ circles ^ (x3 & x4);
        var t3 = x0 ^ x1 ^ x2 ^ circles ^ (~x0 & (x3 ^ x4));
        var t4 = x1 ^ x3 ^ x4 ^ ((x0 ^ x4) & x1);

        x0 = t0 ^ LongUtils.RotateRight(t0, 19) ^ LongUtils.RotateRight(t0, 28);
        x1 = t1 ^ LongUtils.RotateRight(t1, 39) ^ LongUtils.RotateRight(t1, 61);
        x2 = ~(t2 ^ LongUtils.RotateRight(t2, 1) ^ LongUtils.RotateRight(t2, 6));
        x3 = t3 ^ LongUtils.RotateRight(t3, 10) ^ LongUtils.RotateRight(t3, 17);
        x4 = t4 ^ LongUtils.RotateRight(t4, 7) ^ LongUtils.RotateRight(t4, 41);
    }
}
