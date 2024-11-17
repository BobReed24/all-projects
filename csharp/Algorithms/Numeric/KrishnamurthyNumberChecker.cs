using System;

namespace Algorithms.Numeric;

public static class KrishnamurthyNumberChecker
{
    
    public static bool IsKMurthyNumber(int n)
    {
        int sumOfFactorials = 0;
        int tmp = n;

        if (n <= 0)
        {
            return false;
        }

        while (n != 0)
        {
            int factorial = (int)Factorial.Calculate(n % 10);
            sumOfFactorials += factorial;
            n = n / 10;
        }

        return tmp == sumOfFactorials;
    }
}
