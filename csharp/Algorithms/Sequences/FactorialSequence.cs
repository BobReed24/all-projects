using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class FactorialSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = 0;
            var factorial = new BigInteger(1);
            while (true)
            {
                yield return factorial;
                n++;
                factorial *= n;
            }
        }
    }
}
