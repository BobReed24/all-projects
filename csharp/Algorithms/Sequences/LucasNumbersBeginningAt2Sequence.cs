using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class LucasNumbersBeginningAt2Sequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 2;
            yield return 1;
            BigInteger previous = 2;
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
