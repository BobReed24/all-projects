using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class Abs
{
    
    public static T AbsVal<T>(T inputNum) where T : INumber<T>
    {
        return T.IsNegative(inputNum) ? -inputNum : inputNum;
    }

    public static T AbsMin<T>(T[] inputNums) where T : INumber<T>
    {
        if (inputNums.Length == 0)
        {
            throw new ArgumentException("Array is empty.");
        }

        var min = inputNums[0];
        for (var index = 1; index < inputNums.Length; index++)
        {
            var current = inputNums[index];
            if (AbsVal(current).CompareTo(AbsVal(min)) < 0)
            {
                min = current;
            }
        }

        return min;
    }

    public static T AbsMax<T>(T[] inputNums) where T : INumber<T>
    {
        if (inputNums.Length == 0)
        {
            throw new ArgumentException("Array is empty.");
        }

        var max = inputNums[0];
        for (var index = 1; index < inputNums.Length; index++)
        {
            var current = inputNums[index];
            if (AbsVal(current).CompareTo(AbsVal(max)) > 0)
            {
                max = current;
            }
        }

        return max;
    }
}
