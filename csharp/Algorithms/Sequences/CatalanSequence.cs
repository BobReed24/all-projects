using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class CatalanSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            
            var catalan = new BigInteger(1);
            var n = 0;
            while (true)
            {
                yield return catalan;
                catalan = (2 * (2 * n + 1) * catalan) / (n + 2);
                n++;
            }
        }
    }
}
