using System;
using System.Linq;

namespace Algorithms.LinearAlgebra.Distances;

public static class Euclidean
{
    
    public static double Distance(double[] point1, double[] point2)
    {
        if (point1.Length != point2.Length)
        {
            throw new ArgumentException("Both points should have the same dimensionality");
        }

        return Math.Sqrt(point1.Zip(point2, (x1, x2) => (x1 - x2) * (x1 - x2)).Sum());
    }
}
