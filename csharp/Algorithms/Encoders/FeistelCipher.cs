using System;
using System.Collections.Generic;
using System.Text;

namespace Algorithms.Encoders;

public class FeistelCipher : IEncoder<uint>
{
    
    private const int Rounds = 32;

    public string Encode(string text, uint key)
    {
        List<ulong> blocksListPlain = SplitTextToBlocks(text);
        StringBuilder encodedText = new();

        foreach (ulong block in blocksListPlain)
        {
            uint temp = 0;

            uint rightSubblock = (uint)(block & 0x00000000FFFFFFFF);
            uint leftSubblock = (uint)(block >> 32);

            uint roundKey;

            for (int round = 0; round < Rounds; round++)
            {
                roundKey = GetRoundKey(key, round);
                temp = rightSubblock ^ BlockModification(leftSubblock, roundKey);
                rightSubblock = leftSubblock;
                leftSubblock = temp;
            }

            ulong encodedBlock = leftSubblock;
            encodedBlock = (encodedBlock << 32) | rightSubblock;
            encodedText.Append(string.Format("{0:X16}", encodedBlock));
        }

        return encodedText.ToString();
    }

    public string Decode(string text, uint key)
    {
        
        if (text.Length % 16 != 0)
        {
            throw new ArgumentException($"The length of {nameof(key)} should be divisible by 16");
        }

        List<ulong> blocksListEncoded = GetBlocksFromEncodedText(text);
        StringBuilder decodedTextHex = new();

        foreach (ulong block in blocksListEncoded)
        {
            uint temp = 0;

            uint rightSubblock = (uint)(block & 0x00000000FFFFFFFF);
            uint leftSubblock = (uint)(block >> 32);

            uint roundKey;
            for (int round = Rounds - 1; round >= 0; round--)
            {
                roundKey = GetRoundKey(key, round);
                temp = leftSubblock ^ BlockModification(rightSubblock, roundKey);
                leftSubblock = rightSubblock;
                rightSubblock = temp;
            }

            ulong decodedBlock = leftSubblock;
            decodedBlock = (decodedBlock << 32) | rightSubblock;

            for(int i = 0; i < 8; i++)
            {
                ulong a = (decodedBlock & 0xFF00000000000000) >> 56;

                if (a != 0)
                {
                    decodedTextHex.Append((char)a);
                }

                decodedBlock = decodedBlock << 8;
            }
        }

        return decodedTextHex.ToString();
    }

    private static List<ulong> SplitTextToBlocks(string text)
    {
        List<ulong> blocksListPlain = new();
        byte[] textArray = Encoding.ASCII.GetBytes(text);
        int offset = 8;
        for(int i = 0; i < text.Length; i += 8)
        {
            
            if (i > text.Length - 8)
            {
                offset = text.Length - i;
            }

            string block = Convert.ToHexString(textArray, i, offset);
            blocksListPlain.Add(Convert.ToUInt64(block, 16));
        }

        return blocksListPlain;
    }

    private static List<ulong> GetBlocksFromEncodedText(string text)
    {
        List<ulong> blocksListPlain = new();
        for(int i = 0; i < text.Length; i += 16)
        {
            ulong block = Convert.ToUInt64(text.Substring(i, 16), 16);
            blocksListPlain.Add(block);
        }

        return blocksListPlain;
    }

    private static uint BlockModification(uint block, uint key)
    {
        for (int i = 0; i < 32; i++)
        {
            
            block = ((block ^ 0x55555555) * block) % key;
            block = block ^ key;
        }

        return block;
    }

    private static uint GetRoundKey(uint key, int round)
    {
        
        uint a = (uint)Math.Pow((double)key, round + 2);
        return a ^ key;
    }
}
