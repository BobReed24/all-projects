using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class FibonacciSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 0;
            yield return 1;
            BigInteger previous = 0;
            BigInteger current = 1;
            while (true)
            {
                var next = previous + current;
                previous = current;
                current = next;
                yield return next;
            }
        }
    }
}
