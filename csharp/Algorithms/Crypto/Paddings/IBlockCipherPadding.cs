using System;

namespace Algorithms.Crypto.Paddings;

public interface IBlockCipherPadding
{
    
    public int AddPadding(byte[] inputData, int inputOffset);

    public byte[] RemovePadding(byte[] inputData);

    public int GetPaddingCount(byte[] input);
}
