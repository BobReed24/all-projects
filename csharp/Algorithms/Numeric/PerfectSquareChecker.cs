using System;

namespace Algorithms.Numeric;

public static class PerfectSquareChecker
{
    
    public static bool IsPerfectSquare(int number)
    {
        if (number < 0)
        {
            return false;
        }

        var sqrt = (int)Math.Sqrt(number);
        return sqrt * sqrt == number;
    }
}
