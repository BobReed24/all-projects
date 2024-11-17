using System;

namespace Algorithms.Numeric;

public class ModularExponentiation
{
    
    public int ModularPow(int b, int e, int m)
    {
        
        int res = 1;
        if (m == 1)
        {
            
            return 0;
        }

        if (m <= 0)
        {
            
            throw new ArgumentException(string.Format("{0} is not a positive integer", m));
        }

        for (int i = 0; i < e; i++)
        {
            res = (res * b) % m;
        }

        return res;
    }
}
