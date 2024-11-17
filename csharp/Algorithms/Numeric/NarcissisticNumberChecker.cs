using System;

namespace Algorithms.Numeric;

public static class NarcissisticNumberChecker
{
    
    public static bool IsNarcissistic(int number)
    {
        var sum = 0;
        var temp = number;
        var numberOfDigits = 0;
        while (temp != 0)
        {
            numberOfDigits++;
            temp /= 10;
        }

        temp = number;
        while (number > 0)
        {
            var remainder = number % 10;
            var power = (int)Math.Pow(remainder, numberOfDigits);

            sum += power;
            number /= 10;
        }

        return sum == temp;
    }
}
