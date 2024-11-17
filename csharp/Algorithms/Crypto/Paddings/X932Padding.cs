using System;
using System.Security.Cryptography;

namespace Algorithms.Crypto.Paddings;

public class X932Padding : IBlockCipherPadding
{
    private readonly bool useRandomPadding;

    public X932Padding(bool useRandomPadding) =>
        this.useRandomPadding = useRandomPadding;

    public int AddPadding(byte[] inputData, int inputOffset)
    {
        
        if (inputOffset >= inputData.Length)
        {
            throw new ArgumentException("Not enough space in input array for padding");
        }

        var code = (byte)(inputData.Length - inputOffset);

        while (inputOffset < inputData.Length - 1)
        {
            if (!useRandomPadding)
            {
                
                inputData[inputOffset] = 0;
            }
            else
            {
                
                inputData[inputOffset] = (byte)RandomNumberGenerator.GetInt32(255);
            }

            inputOffset++;
        }

        inputData[inputOffset] = code;

        return code;
    }

    public byte[] RemovePadding(byte[] inputData)
    {
        
        if (inputData.Length == 0)
        {
            return Array.Empty<byte>();
        }

        var paddingLength = inputData[^1];

        if (paddingLength < 1 || paddingLength > inputData.Length)
        {
            throw new ArgumentException("Invalid padding length");
        }

        var output = new byte[inputData.Length - paddingLength];

        Array.Copy(inputData, output, output.Length);

        return output;
    }

    public int GetPaddingCount(byte[] input)
    {
        
        var count = input[^1] & 0xFF;

        var position = input.Length - count;

        var failed = (position | (count - 1)) >> 31;

        if (failed != 0)
        {
            throw new ArgumentException("Pad block corrupted");
        }

        return count;
    }
}
