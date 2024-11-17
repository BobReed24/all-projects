using System;
using System.Collections.Generic;

namespace Algorithms.Numeric;

public static class EulerMethod
{
    
    public static List<double[]> EulerFull(
        double xStart,
        double xEnd,
        double stepSize,
        double yStart,
        Func<double, double, double> yDerivative)
    {
        if (xStart >= xEnd)
        {
            throw new ArgumentOutOfRangeException(
                nameof(xEnd),
                $"{nameof(xEnd)} should be greater than {nameof(xStart)}");
        }

        if (stepSize <= 0)
        {
            throw new ArgumentOutOfRangeException(
                nameof(stepSize),
                $"{nameof(stepSize)} should be greater than zero");
        }

        List<double[]> points = new();
        double[] firstPoint = { xStart, yStart };
        points.Add(firstPoint);
        var yCurrent = yStart;
        var xCurrent = xStart;

        while (xCurrent < xEnd)
        {
            yCurrent = EulerStep(xCurrent, stepSize, yCurrent, yDerivative);
            xCurrent += stepSize;
            double[] point = { xCurrent, yCurrent };
            points.Add(point);
        }

        return points;
    }

    private static double EulerStep(
        double xCurrent,
        double stepSize,
        double yCurrent,
        Func<double, double, double> yDerivative)
    {
        var yNext = yCurrent + stepSize * yDerivative(xCurrent, yCurrent);
        return yNext;
    }
}
