using System;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures.Hashing.NumberTheory;

public static class PrimeNumber
{
    
    public static bool IsPrime(int number)
    {
        if (number <= 1)
        {
            return false;
        }

        if (number <= 3)
        {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0)
        {
            return false;
        }

        for (int i = 5; i * i <= number; i += 6)
        {
            if (number % i == 0 || number % (i + 2) == 0)
            {
                return false;
            }
        }

        return true;
    }

    public static int NextPrime(int number, int factor = 1, bool desc = false)
    {
        number = factor * number;
        int firstValue = number;

        while (!IsPrime(number))
        {
            number += desc ? -1 : 1;
        }

        if (number == firstValue)
        {
            return NextPrime(
                number + (desc ? -1 : 1),
                factor,
                desc);
        }

        return number;
    }
}
