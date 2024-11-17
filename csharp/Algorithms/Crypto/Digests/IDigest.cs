using System;

namespace Algorithms.Crypto.Digests;

public interface IDigest
{
    
    string AlgorithmName { get; }

    int GetDigestSize();

    int GetByteLength();

    void Update(byte input);

    void BlockUpdate(byte[] input, int inOff, int inLen);

    void BlockUpdate(ReadOnlySpan<byte> input);

    int DoFinal(byte[] output, int outOff);

    int DoFinal(Span<byte> output);

    string Digest(byte[] input);

    string Digest(Span<byte> input);

    void Reset();
}
