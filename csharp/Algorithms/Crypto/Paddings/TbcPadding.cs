using System;

namespace Algorithms.Crypto.Paddings;

public class TbcPadding : IBlockCipherPadding
{
    
    public int AddPadding(byte[] input, int inputOffset)
    {
        
        var count = input.Length - inputOffset;
        byte code;

        if (count < 0)
        {
            throw new ArgumentException("Not enough space in input array for padding");
        }

        if (inputOffset > 0)
        {
            
            var lastBit = input[inputOffset - 1] & 0x01;

            code = (byte)(lastBit == 0 ? 0xff : 0x00);
        }
        else
        {
            
            var lastBit = input[^1] & 0x01;

            code = (byte)(lastBit == 0 ? 0xff : 0x00);
        }

        while (inputOffset < input.Length)
        {
            
            input[inputOffset] = code;
            inputOffset++;
        }

        return count;
    }

    public byte[] RemovePadding(byte[] input)
    {
        if (input.Length == 0)
        {
            return Array.Empty<byte>();
        }

        var lastByte = input[^1];

        var code = (byte)((lastByte & 0x01) == 0 ? 0x00 : 0xff);

        int i;
        for (i = input.Length - 1; i >= 0; i--)
        {
            
            if (input[i] != code)
            {
                break;
            }
        }

        var unpadded = new byte[i + 1];

        Array.Copy(input, unpadded, i + 1);

        return unpadded;
    }

    public int GetPaddingCount(byte[] input)
    {
        var length = input.Length;

        if (length == 0)
        {
            throw new ArgumentException("No padding found.");
        }

        var paddingValue = input[--length] & 0xFF;
        var paddingCount = 1; 
        var countingMask = -1; 

        if (paddingValue != 0 && paddingValue != 0xFF)
        {
            throw new ArgumentException("No padding found");
        }

        for (var i = length - 1; i >= 0; i--)
        {
            var currentByte = input[i] & 0xFF;

            var matchMask = ((currentByte ^ paddingValue) - 1) >> 31;

            countingMask &= matchMask;

            paddingCount -= countingMask;
        }

        return paddingCount;
    }
}
