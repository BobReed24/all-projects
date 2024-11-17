using System;
using System.Linq;

namespace Algorithms.LinearAlgebra.Distances;

public static class Minkowski
{
    
    public static double Distance(double[] point1, double[] point2, int order)
    {
        if (order < 1)
        {
            throw new ArgumentException("The order must be greater than or equal to 1.");
        }

        if (point1.Length != point2.Length)
        {
            throw new ArgumentException("Both points should have the same dimensionality");
        }

        return Math.Pow(point1.Zip(point2, (x1, x2) => Math.Pow(Math.Abs(x1 - x2), order)).Sum(), 1.0 / order);
    }
}
