using System;

namespace Algorithms.Crypto.Digests;

public class Md2Digest
{
    
    private static readonly byte[] STable =
    {
        41, 46, 67, 201, 162, 216, 124, 1, 61, 54, 84, 161, 236, 240, 6, 19,
        98, 167, 5, 243, 192, 199, 115, 140, 152, 147, 43, 217, 188, 76, 130, 202,
        30, 155, 87, 60, 253, 212, 224, 22, 103, 66, 111, 24, 138, 23, 229, 18,
        190, 78, 196, 214, 218, 158, 222, 73, 160, 251, 245, 142, 187, 47, 238, 122,
        169, 104, 121, 145, 21, 178, 7, 63, 148, 194, 16, 137, 11, 34, 95, 33,
        128, 127, 93, 154, 90, 144, 50, 39, 53, 62, 204, 231, 191, 247, 151, 3,
        255, 25, 48, 179, 72, 165, 181, 209, 215, 94, 146, 42, 172, 86, 170, 198,
        79, 184, 56, 210, 150, 164, 125, 182, 118, 252, 107, 226, 156, 116, 4, 241,
        69, 157, 112, 89, 100, 113, 135, 32, 134, 91, 207, 101, 230, 45, 168, 2,
        27, 96, 37, 173, 174, 176, 185, 246, 28, 70, 97, 105, 52, 64, 126, 15,
        85, 71, 163, 35, 221, 81, 175, 58, 195, 92, 249, 206, 186, 197, 234, 38,
        44, 83, 13, 110, 133, 40, 132, 9, 211, 223, 205, 244, 65, 129, 77, 82,
        106, 220, 55, 200, 108, 193, 171, 250, 36, 225, 123, 8, 12, 189, 177, 74,
        120, 136, 149, 139, 227, 99, 232, 109, 233, 203, 213, 254, 59, 0, 29, 57,
        242, 239, 183, 14, 102, 88, 208, 228, 166, 119, 114, 248, 235, 117, 75, 10,
        49, 68, 80, 180, 143, 237, 31, 26, 219, 153, 141, 51, 159, 17, 131, 20,
    };

    private readonly byte[] xBuffer = new byte[48];

    private readonly byte[] mBuffer = new byte[16];

    private readonly byte[] checkSum = new byte[16];

    private int xBufferOffset;
    private int mBufferOffset;

    public byte[] Digest(byte[] input)
    {
        Update(input, 0, input.Length);

        var paddingByte = (byte)(mBuffer.Length - mBufferOffset);

        for (var i = mBufferOffset; i < mBuffer.Length; i++)
        {
            mBuffer[i] = paddingByte;
        }

        ProcessCheckSum(mBuffer);

        ProcessBlock(mBuffer);

        ProcessBlock(checkSum);

        var digest = new byte[16];

        xBuffer.AsSpan(xBufferOffset, 16).CopyTo(digest);

        Reset();
        return digest;
    }

    private void Reset()
    {
        xBufferOffset = 0;
        for (var i = 0; i != xBuffer.Length; i++)
        {
            xBuffer[i] = 0;
        }

        mBufferOffset = 0;
        for (var i = 0; i != mBuffer.Length; i++)
        {
            mBuffer[i] = 0;
        }

        for (var i = 0; i != checkSum.Length; i++)
        {
            checkSum[i] = 0;
        }
    }

    private void ProcessBlock(byte[] block)
    {
        
        for (var i = 0; i < 16; i++)
        {
            xBuffer[i + 16] = block[i];
            xBuffer[i + 32] = (byte)(block[i] ^ xBuffer[i]);
        }

        var tmp = 0;

        for (var j = 0; j < 18; j++)
        {
            for (var k = 0; k < 48; k++)
            {
                tmp = xBuffer[k] ^= STable[tmp];
                tmp &= 0xff;
            }

            tmp = (tmp + j) % 256;
        }
    }

    private void ProcessCheckSum(byte[] block)
    {
        
        var last = checkSum[15];
        for (var i = 0; i < 16; i++)
        {
            
            var map = STable[(mBuffer[i] ^ last) & 0xff];

            checkSum[i] ^= map;

            last = checkSum[i];
        }
    }

    private void Update(byte input)
    {
        mBuffer[mBufferOffset++] = input;
    }

    private void Update(byte[] input, int inputOffset, int length)
    {
        
        while (length >= 16)
        {
            Array.Copy(input, inputOffset, mBuffer, 0, 16);
            ProcessCheckSum(mBuffer);
            ProcessBlock(mBuffer);

            length -= 16;
            inputOffset += 16;
        }

        while (length > 0)
        {
            Update(input[inputOffset]);
            inputOffset++;
            length--;
        }
    }
}
