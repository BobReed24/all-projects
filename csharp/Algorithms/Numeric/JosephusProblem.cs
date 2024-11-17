using System;

namespace Algorithms.Numeric;

public static class JosephusProblem
{
    
    public static long FindWinner(long n, long k)
    {
        if (k <= 0)
        {
            throw new ArgumentException("The step cannot be smaller than 1");
        }

        if (k > n)
        {
            throw new ArgumentException("The step cannot be greater than the size of the group");
        }

        long winner = 0;
        for (long stepIndex = 1; stepIndex <= n; ++stepIndex)
        {
            winner = (winner + k) % stepIndex;
        }

        return winner + 1;
    }
}
