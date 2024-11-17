using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class NumberOfBooleanFunctionsSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var n = new BigInteger(2);

            while (true)
            {
                yield return n;
                n *= n;
            }
        }
    }
}
