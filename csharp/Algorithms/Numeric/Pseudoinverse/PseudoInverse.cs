using System;
using Algorithms.Numeric.Decomposition;
using Utilities.Extensions;

namespace Algorithms.Numeric.Pseudoinverse;

public static class PseudoInverse
{
    
    public static double[,] PInv(double[,] inMat)
    {
        
        var (u, s, v) = ThinSvd.Decompose(inMat);

        var len = s.Length;

        var sigma = new double[len];
        for (var i = 0; i < len; i++)
        {
            sigma[i] = Math.Abs(s[i]) < 0.0001 ? 0 : 1 / s[i];
        }

        var diag = sigma.ToDiagonalMatrix();

        var matinv = u.Multiply(diag).Multiply(v.Transpose());

        return matinv.Transpose();
    }
}
