using System;
using System.Linq;
using Utilities.Extensions;

namespace Algorithms.LinearAlgebra.Eigenvalue;

public static class PowerIteration
{
    
    public static (double Eigenvalue, double[] Eigenvector) Dominant(
        double[,] source,
        double[] startVector,
        double error = 0.00001)
    {
        if (source.GetLength(0) != source.GetLength(1))
        {
            throw new ArgumentException("The source matrix is not square-shaped.");
        }

        if (source.GetLength(0) != startVector.Length)
        {
            throw new ArgumentException(
                "The length of the start vector doesn't equal the size of the source matrix.");
        }

        double eigenNorm;
        double[] previousEigenVector;
        double[] currentEigenVector = startVector;

        do
        {
            previousEigenVector = currentEigenVector;
            currentEigenVector = source.Multiply(
                    previousEigenVector.ToColumnVector())
                .ToRowVector();

            eigenNorm = currentEigenVector.Magnitude();
            currentEigenVector = currentEigenVector.Select(x => x / eigenNorm).ToArray();
        }
        while (Math.Abs(currentEigenVector.Dot(previousEigenVector)) < 1.0 - error);

        var eigenvalue = source.Multiply(currentEigenVector.ToColumnVector()).ToRowVector().Magnitude();

        return (eigenvalue, Eigenvector: currentEigenVector);
    }

    public static (double Eigenvalue, double[] Eigenvector) Dominant(double[,] source, double error = 0.00001) =>
        Dominant(source, new Random().NextVector(source.GetLength(1)), error);
}
