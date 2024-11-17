using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Search;

public static class BoyerMoore<T> where T : IComparable
{
    public static T? FindMajority(IEnumerable<T> input)
    {
        var candidate = FindMajorityCandidate(input, input.Count());

        if (VerifyMajority(input, input.Count(), candidate))
        {
            return candidate;
        }

        return default(T?);
    }

    private static T FindMajorityCandidate(IEnumerable<T> input, int length)
    {
        int count = 1;
        T candidate = input.First();

        foreach (var element in input.Skip(1))
        {
            if (candidate.Equals(element))
            {
                count++;
            }
            else
            {
                count--;
            }

            if (count == 0)
            {
                candidate = element;
                count = 1;
            }
        }

        return candidate;
    }

    private static bool VerifyMajority(IEnumerable<T> input, int size, T candidate)
    {
        return input.Count(x => x.Equals(candidate)) > size / 2;
    }
}
