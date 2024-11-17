using System;

namespace Algorithms.Crypto.Paddings;

public class Pkcs7Padding : IBlockCipherPadding
{
    private readonly int blockSize;

    public Pkcs7Padding(int blockSize)
    {
        if (blockSize is < 1 or > 255)
        {
            throw new ArgumentOutOfRangeException(nameof(blockSize), $"Invalid block size: {blockSize}");
        }

        this.blockSize = blockSize;
    }

    public int AddPadding(byte[] input, int inputOffset)
    {
        
        var code = (byte)((blockSize - (input.Length % blockSize)) % blockSize);

        if (code == 0)
        {
            code = (byte)blockSize;
        }

        if (inputOffset + code > input.Length)
        {
            throw new ArgumentException("Not enough space in input array for padding");
        }

        for (var i = 0; i < code; i++)
        {
            input[inputOffset + i] = code;
        }

        return code;
    }

    public byte[] RemovePadding(byte[] input)
    {
        
        if (input.Length % blockSize != 0)
        {
            throw new ArgumentException("Input length must be a multiple of block size");
        }

        var paddingLength = input[^1];

        if (paddingLength < 1 || paddingLength > blockSize)
        {
            throw new ArgumentException("Invalid padding length");
        }

        for (var i = 0; i < paddingLength; i++)
        {
            if (input[input.Length - 1 - i] != paddingLength)
            {
                throw new ArgumentException("Invalid padding");
            }
        }

        var output = new byte[input.Length - paddingLength];

        Array.Copy(input, output, output.Length);

        return output;
    }

    public int GetPaddingCount(byte[] input)
    {
        if (input == null)
        {
            throw new ArgumentNullException(nameof(input), "Input cannot be null");
        }

        var lastByte = input[^1];
        var paddingCount = lastByte & 0xFF;

        var paddingStartIndex = input.Length - paddingCount;
        var paddingCheckFailed = 0;

        paddingCheckFailed = (paddingStartIndex | (paddingCount - 1)) >> 31;

        for (var i = 0; i < input.Length; i++)
        {
            
            paddingCheckFailed |= (input[i] ^ lastByte) & ~((i - paddingStartIndex) >> 31);
        }

        if (paddingCheckFailed != 0)
        {
            throw new ArgumentException("Padding block is corrupted");
        }

        return paddingCount;
    }
}
