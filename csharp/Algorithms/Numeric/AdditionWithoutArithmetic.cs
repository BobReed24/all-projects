using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class AdditionWithoutArithmetic
{
    
    public static int CalculateAdditionWithoutArithmetic(int first, int second)
    {
        while (second != 0)
        {
            int c = first & second;      
            first ^= second;             
            second = c << 1;            
        }

        return first;
    }
}
