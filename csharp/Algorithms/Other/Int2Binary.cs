using System.Text;

namespace Algorithms.Other;

public static class Int2Binary
{
    
    public static string Int2Bin(ushort input)
    {
        ushort msb = ushort.MaxValue / 2 + 1;
        var output = new StringBuilder();
        for (var i = 0; i < 16; i++)
        {
            if (input >= msb)
            {
                output.Append("1");
                input -= msb;
                msb /= 2;
            }
            else
            {
                output.Append("0");
                msb /= 2;
            }
        }

        return output.ToString();
    }

    public static string Int2Bin(uint input)
    {
        var msb = uint.MaxValue / 2 + 1;
        var output = new StringBuilder();
        for (var i = 0; i < 32; i++)
        {
            if (input >= msb)
            {
                output.Append("1");
                input -= msb;
                msb /= 2;
            }
            else
            {
                output.Append("0");
                msb /= 2;
            }
        }

        return output.ToString();
    }

    public static string Int2Bin(ulong input)
    {
        var msb = ulong.MaxValue / 2 + 1;
        var output = new StringBuilder();
        for (var i = 0; i < 64; i++)
        {
            if (input >= msb)
            {
                output.Append("1");
                input -= msb;
                msb /= 2;
            }
            else
            {
                output.Append("0");
                msb /= 2;
            }
        }

        return output.ToString();
    }
}
