using System;

namespace Algorithms.Numeric;

public static class SoftMax
{
    
    public static double[] Compute(double[] input)
    {
        if (input.Length == 0)
        {
            throw new ArgumentException("Array is empty.");
        }

        var exponentVector = new double[input.Length];
        var sum = 0.0;
        for (var index = 0; index < input.Length; index++)
        {
            exponentVector[index] = Math.Exp(input[index]);
            sum += exponentVector[index];
        }

        for (var index = 0; index < input.Length; index++)
        {
            exponentVector[index] /= sum;
        }

        return exponentVector;
    }
}
