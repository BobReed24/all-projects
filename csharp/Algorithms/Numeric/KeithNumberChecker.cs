using System;

namespace Algorithms.Numeric;

public static class KeithNumberChecker
{
    
    public static bool IsKeithNumber(int number)
    {
        if (number < 0)
        {
            throw new ArgumentException($"{nameof(number)} cannot be negative");
        }

        var tempNumber = number;

        var stringNumber = number.ToString();

        var digitsInNumber = stringNumber.Length;

        var termsArray = new int[number];

        for (var i = digitsInNumber - 1; i >= 0; i--)
        {
            termsArray[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        var sum = 0;
        var k = digitsInNumber;
        while (sum < number)
        {
            sum = 0;

            for (var j = 1; j <= digitsInNumber; j++)
            {
                sum += termsArray[k - j];
            }

            termsArray[k] = sum;
            k++;
        }

        return sum == number;
    }
}
