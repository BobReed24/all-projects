using System;
using Utilities.Extensions;

namespace Algorithms.Numeric.Decomposition;

public static class ThinSvd
{
    
    public static double[] RandomUnitVector(int dimensions)
    {
        Random random = new();
        double[] result = new double[dimensions];
        for (var i = 0; i < dimensions; i++)
        {
            result[i] = 2 * random.NextDouble() - 1;
        }

        var magnitude = result.Magnitude();
        result = result.Scale(1 / magnitude);
        return result;
    }

    public static double[] Decompose1D(double[,] matrix) =>
        Decompose1D(matrix, 1E-5, 100);

    public static double[] Decompose1D(double[,] matrix, double epsilon, int maxIterations)
    {
        var n = matrix.GetLength(1);
        var iterations = 0;
        double mag;
        double[] lastIteration;
        double[] currIteration = RandomUnitVector(n);
        double[,] b = matrix.Transpose().Multiply(matrix);
        do
        {
            lastIteration = currIteration.Copy();
            currIteration = b.MultiplyVector(lastIteration);
            currIteration = currIteration.Scale(100);
            mag = currIteration.Magnitude();
            if (mag > epsilon)
            {
                currIteration = currIteration.Scale(1 / mag);
            }

            iterations++;
        }
        while (lastIteration.Dot(currIteration) < 1 - epsilon && iterations < maxIterations);

        return currIteration;
    }

    public static (double[,] U, double[] S, double[,] V) Decompose(double[,] matrix) =>
        Decompose(matrix, 1E-5, 100);

    public static (double[,] U, double[] S, double[,] V) Decompose(
        double[,] matrix,
        double epsilon,
        int maxIterations)
    {
        var m = matrix.GetLength(0);
        var n = matrix.GetLength(1);
        var numValues = Math.Min(m, n);

        double[] sigmas = new double[numValues];
        double[,] us = new double[m, numValues];
        double[,] vs = new double[n, numValues];

        double[,] remaining = matrix.Copy();

        for (var i = 0; i < numValues; i++)
        {
            
            double[] v = Decompose1D(remaining, epsilon, maxIterations);
            double[] u = matrix.MultiplyVector(v);

            double[,] contrib = u.OuterProduct(v);

            var s = u.Magnitude();

            if (s < epsilon)
            {
                u = new double[m];
                v = new double[n];
            }
            else
            {
                u = u.Scale(1 / s);
            }

            for (var j = 0; j < u.Length; j++)
            {
                us[j, i] = u[j];
            }

            for (var j = 0; j < v.Length; j++)
            {
                vs[j, i] = v[j];
            }

            sigmas[i] = s;

            remaining = remaining.Subtract(contrib);
        }

        return (U: us, S: sigmas, V: vs);
    }
}
