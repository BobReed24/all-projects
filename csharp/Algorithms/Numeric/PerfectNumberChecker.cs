using System;

namespace Algorithms.Numeric;

public static class PerfectNumberChecker
{
    
    public static bool IsPerfectNumber(int number)
    {
        if (number < 0)
        {
            throw new ArgumentException($"{nameof(number)} cannot be negative");
        }

        var sum = 0; 
        for (var i = 1; i < number; ++i)
        {
            if (number % i == 0)
            {
                sum += i;
            }
        }

        return sum == number;
    }
}
