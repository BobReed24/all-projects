using System;
using System.Collections.Generic;

namespace Algorithms.Numeric;

public static class RungeKuttaMethod
{
    
    public static List<double[]> ClassicRungeKuttaMethod(
        double xStart,
        double xEnd,
        double stepSize,
        double yStart,
        Func<double, double, double> function)
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
            var k1 = function(xCurrent, yCurrent);
            var k2 = function(xCurrent + 0.5 * stepSize, yCurrent + 0.5 * stepSize * k1);
            var k3 = function(xCurrent + 0.5 * stepSize, yCurrent + 0.5 * stepSize * k2);
            var k4 = function(xCurrent + stepSize, yCurrent + stepSize * k3);

            yCurrent += (1.0 / 6.0) * stepSize * (k1 + 2 * k2 + 2 * k3 + k4);
            xCurrent += stepSize;

            double[] newPoint = { xCurrent, yCurrent };
            points.Add(newPoint);
        }

        return points;
    }
}
