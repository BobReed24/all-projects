using System;
using System.Linq;
using Algorithms.Numeric;

namespace Algorithms.Encoders;

public class HillEncoder : IEncoder<double[,]>
{
    private readonly GaussJordanElimination linearEquationSolver;

    public HillEncoder() => linearEquationSolver = new GaussJordanElimination(); 

    public string Encode(string text, double[,] key)
    {
        var preparedText = FillGaps(text);
        var chunked = ChunkTextToArray(preparedText);
        var splitted = SplitToCharArray(chunked);

        var ciphered = new double[chunked.Length][];

        for (var i = 0; i < chunked.Length; i++)
        {
            var vector = new double[3];
            Array.Copy(splitted, i * 3, vector, 0, 3);
            var product = MatrixCipher(vector, key);
            ciphered[i] = product;
        }

        var merged = MergeArrayList(ciphered);

        return BuildStringFromArray(merged);
    }

    public string Decode(string text, double[,] key)
    {
        var chunked = ChunkTextToArray(text);
        var split = SplitToCharArray(chunked);

        var deciphered = new double[chunked.Length][];

        for (var i = 0; i < chunked.Length; i++)
        {
            var vector = new double[3];
            Array.Copy(split, i * 3, vector, 0, 3);
            var product = MatrixDeCipher(vector, key);
            deciphered[i] = product;
        }

        var merged = MergeArrayList(deciphered);
        var str = BuildStringFromArray(merged);

        return UnFillGaps(str);
    }

    private static string BuildStringFromArray(double[] arr) => new(arr.Select(c => (char)c).ToArray());

    private static double[] MatrixCipher(double[] vector, double[,] key)
    {
        var multiplied = new double[vector.Length];

        for (var i = 0; i < key.GetLength(1); i++)
        {
            for (var j = 0; j < key.GetLength(0); j++)
            {
                multiplied[i] += key[i, j] * vector[j];
            }
        }

        return multiplied;
    }

    private static double[] MergeArrayList(double[][] list)
    {
        var merged = new double[list.Length * 3];

        for (var i = 0; i < list.Length; i++)
        {
            Array.Copy(list[i], 0, merged, i * 3, list[0].Length);
        }

        return merged;
    }

    private static char[] SplitToCharArray(string[] chunked)
    {
        var splitted = new char[chunked.Length * 3];

        for (var i = 0; i < chunked.Length; i++)
        {
            for (var j = 0; j < 3; j++)
            {
                splitted[i * 3 + j] = chunked[i].ToCharArray()[j];
            }
        }

        return splitted;
    }

    private static string[] ChunkTextToArray(string text)
    {
        
        var div = text.Length / 3;
        var chunks = new string[div];

        for (var i = 0; i < div; i++)
        {
            chunks.SetValue(text.Substring(i * 3, 3), i);
        }

        return chunks;
    }

    private static string FillGaps(string text)
    {
        var remainder = text.Length % 3;
        return remainder == 0 ? text : text + new string(' ', 3 - remainder);
    }

    private static string UnFillGaps(string text) => text.TrimEnd();

    private double[] MatrixDeCipher(double[] vector, double[,] key)
    {
        
        var augM = new double[3, 4];

        for (var i = 0; i < key.GetLength(0); i++)
        {
            for (var j = 0; j < key.GetLength(1); j++)
            {
                augM[i, j] = key[i, j];
            }
        }

        for (var k = 0; k < vector.Length; k++)
        {
            augM[k, 3] = vector[k];
        }

        _ = linearEquationSolver.Solve(augM);

        return new[] { augM[0, 3], augM[1, 3], augM[2, 3] };
    }
}
