using System;
using System.Security.Cryptography;

namespace Algorithms.Crypto.Paddings;

public class Iso10126D2Padding : IBlockCipherPadding
{
    
    public int AddPadding(byte[] inputData, int inputOffset)
    {
        
        var code = (byte)(inputData.Length - inputOffset);

        if (code == 0 || inputOffset + code > inputData.Length)
        {
            throw new ArgumentException("Not enough space in input array for padding");
        }

        while (inputOffset < (inputData.Length - 1))
        {
            inputData[inputOffset] = (byte)RandomNumberGenerator.GetInt32(255);
            inputOffset++;
        }

        inputData[inputOffset] = code;

        return code;
    }

    public byte[] RemovePadding(byte[] inputData)
    {
        
        var paddingLength = inputData[^1];

        if (paddingLength < 1 || paddingLength > inputData.Length)
        {
            throw new ArgumentException("Invalid padding length");
        }

        var output = new byte[inputData.Length - paddingLength];

        Array.Copy(inputData, 0, output, 0, output.Length);

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
        if (paddingCheckFailed != 0)
        {
            throw new ArgumentException("Padding block is corrupted");
        }

        return paddingCount;
    }
}
