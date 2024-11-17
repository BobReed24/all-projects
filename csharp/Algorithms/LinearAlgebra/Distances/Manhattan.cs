using System;
using System.Linq;

namespace Algorithms.LinearAlgebra.Distances;

public static class Manhattan
{
    
    public static double Distance(double[] point1, double[] point2)
    {
        if (point1.Length != point2.Length)
        {
            throw new ArgumentException("Both points should have the same dimensionality");
        }

        return point1.Zip(point2, (x1, x2) => Math.Abs(x1 - x2)).Sum();
    }
}
