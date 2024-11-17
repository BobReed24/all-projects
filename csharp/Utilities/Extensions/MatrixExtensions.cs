using System;

namespace Utilities.Extensions;

public static class MatrixExtensions
{
    
    public static double[,] Multiply(this double[,] source, double[,] operand)
    {
        if (source.GetLength(1) != operand.GetLength(0))
        {
            throw new InvalidOperationException(
                "The width of a first operand should match the height of a second.");
        }

        var result = new double[source.GetLength(0), operand.GetLength(1)];

        for (var i = 0; i < result.GetLength(0); i++)
        {
            for (var j = 0; j < result.GetLength(1); j++)
            {
                double elementProduct = 0;

                for (var k = 0; k < source.GetLength(1); k++)
                {
                    elementProduct += source[i, k] * operand[k, j];
                }

                result[i, j] = elementProduct;
            }
        }

        return result;
    }

    public static double[,] Copy(this double[,] matrix)
    {
        var result = new double[matrix.GetLength(0), matrix.GetLength(1)];
        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            for (var j = 0; j < matrix.GetLength(1); j++)
            {
                result[i, j] = matrix[i, j];
            }
        }

        return result;
    }

    public static double[,] Transpose(this double[,] matrix)
    {
        var result = new double[matrix.GetLength(1), matrix.GetLength(0)];
        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            for (var j = 0; j < matrix.GetLength(1); j++)
            {
                result[j, i] = matrix[i, j];
            }
        }

        return result;
    }

    public static double[] MultiplyVector(this double[,] matrix, double[] vector)
    {
        var vectorReshaped = new double[vector.Length, 1];
        for (var i = 0; i < vector.Length; i++)
        {
            vectorReshaped[i, 0] = vector[i];
        }

        var resultMatrix = matrix.Multiply(vectorReshaped);
        var result = new double[resultMatrix.GetLength(0)];
        for (var i = 0; i < result.Length; i++)
        {
            result[i] = resultMatrix[i, 0];
        }

        return result;
    }

    public static double[,] Subtract(this double[,] lhs, double[,] rhs)
    {
        if (lhs.GetLength(0) != rhs.GetLength(0) ||
            lhs.GetLength(1) != rhs.GetLength(1))
        {
            throw new ArgumentException("Dimensions of matrices must be the same");
        }

        var result = new double[lhs.GetLength(0), lhs.GetLength(1)];
        for (var i = 0; i < lhs.GetLength(0); i++)
        {
            for (var j = 0; j < lhs.GetLength(1); j++)
            {
                result[i, j] = lhs[i, j] - rhs[i, j];
            }
        }

        return result;
    }

    public static bool IsEqual(this double[,] source, double[,] operand)
    {
        if (source.Length != operand.Length ||
            source.GetLength(0) != operand.GetLength(0) ||
            source.GetLength(1) != operand.GetLength(1))
        {
            return false;
        }

        for (var i = 0; i < source.GetLength(0); i++)
        {
            for (var j = 0; j < source.GetLength(0); j++)
            {
                if (Math.Abs(source[i, j] - operand[i, j]) >= 0.0001)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static double[,] RoundToNextInt(this double[,] source)
    {
        var rows = source.GetLength(0);
        var cols = source.GetLength(1);

        var result = new double[rows, cols];

        for (var i = 0; i < rows; i++)
        {
            for (var j = 0; j < cols; j++)
            {
                result[i, j] = Math.Round(source[i, j]);
            }
        }

        return result;
    }
}
