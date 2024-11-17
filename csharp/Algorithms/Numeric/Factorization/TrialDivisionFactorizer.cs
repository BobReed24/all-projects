using System;
using System.Linq;

namespace Algorithms.Numeric.Factorization;

public class TrialDivisionFactorizer : IFactorizer
{
    
    public bool TryFactor(int n, out int factor)
    {
        n = Math.Abs(n);
        factor = Enumerable.Range(2, (int)Math.Sqrt(n) - 1).FirstOrDefault(i => n % i == 0);
        return factor != 0;
    }
}
