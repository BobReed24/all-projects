using System;

namespace Algorithms.Numeric;

public static class AliquotSumCalculator
{
    
    public static int CalculateAliquotSum(int number)
    {
        if (number < 0)
        {
            throw new ArgumentException($"{nameof(number)} cannot be negative");
        }

        var sum = 0;
        for (int i = 1, limit = number / 2; i <= limit; ++i)
        {
            if (number % i == 0)
            {
                sum += i;
            }
        }

        return sum;
    }
}
