using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Other;

public class GaussOptimization
{
    
    public (double X1, double X2) Optimize(
        Func<double, double, double> func,
        double n,
        double step,
        double eps,
        double x1,
        double x2)
    {
        
        double error = 1;

        while (Math.Abs(error) > eps)
        {
            
            double bottom = func(x1, x2 - step);
            double top = func(x1, x2 + step);
            double left = func(x1 - step, x2);
            double right = func(x1 + step, x2);

            var possibleFunctionValues = new List<double> { bottom, top, left, right };
            double maxValue = possibleFunctionValues.Max();
            double maxValueIndex = possibleFunctionValues.IndexOf(maxValue);

            error = maxValue - func(x1, x2);

            switch (maxValueIndex)
            {
                case 0:
                    x2 -= step;
                    break;
                case 1:
                    x2 += step;
                    break;
                case 2:
                    x1 -= step;
                    break;
                default:
                    x1 += step;
                    break;
            }

            step /= n;
        }

        return (x1, x2);
    }
}
