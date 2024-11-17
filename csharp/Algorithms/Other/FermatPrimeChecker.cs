using System;
using System.Numerics;

namespace Algorithms.Other;

public static class FermatPrimeChecker
{
    
    public static bool IsPrime(int numberToTest, int timesToCheck)
    {
        
        var numberToTestBigInteger = new BigInteger(numberToTest);
        var exponentBigInteger = new BigInteger(numberToTest - 1);

        var r = new Random(default(DateTime).Millisecond);

        var iterator = 1;
        var prime = true;

        while (iterator < timesToCheck && prime)
        {
            var randomNumber = r.Next(1, numberToTest);
            var randomNumberBigInteger = new BigInteger(randomNumber);
            if (BigInteger.ModPow(randomNumberBigInteger, exponentBigInteger, numberToTestBigInteger) != 1)
            {
                prime = false;
            }

            iterator++;
        }

        return prime;
    }
}
