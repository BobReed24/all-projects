using System;

namespace Algorithms.Crypto.Paddings;

public class Iso7816D4Padding : IBlockCipherPadding
{
    
    public int AddPadding(byte[] inputData, int inputOffset)
    {
        
        var code = (byte)(inputData.Length - inputOffset);

        if (code == 0 || inputOffset + code > inputData.Length)
        {
            throw new ArgumentException("Not enough space in input array for padding");
        }

        inputData[inputOffset] = 80;
        inputOffset++;

        while (inputOffset < inputData.Length)
        {
            inputData[inputOffset] = 0;
            inputOffset++;
        }

        return code;
    }

    public byte[] RemovePadding(byte[] inputData)
    {
        
        var paddingIndex = inputData.Length - 1;

        while (paddingIndex >= 0 && inputData[paddingIndex] == 0)
        {
            paddingIndex--;
        }

        if (paddingIndex < 0 || inputData[paddingIndex] != 0x80)
        {
            throw new ArgumentException("Invalid padding");
        }

        var unpaddedData = new byte[paddingIndex];

        Array.Copy(inputData, 0, unpaddedData, 0, paddingIndex);

        return unpaddedData;
    }

    public int GetPaddingCount(byte[] input)
    {
        
        var paddingStartIndex = -1;

        var stillPaddingMask = -1;

        var currentIndex = input.Length;

        while (--currentIndex >= 0)
        {
            
            var currentByte = input[currentIndex] & 0xFF;

            var isZeroMask = (currentByte - 1) >> 31;

            var isPaddingStartMask = ((currentByte ^ 0x80) - 1) >> 31;

            paddingStartIndex ^= (currentIndex ^ paddingStartIndex) & (stillPaddingMask & isPaddingStartMask);

            stillPaddingMask &= isZeroMask;
        }

        if (paddingStartIndex < 0)
        {
            throw new ArgumentException("Pad block corrupted");
        }

        return input.Length - paddingStartIndex;
    }
}
