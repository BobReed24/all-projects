using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class FermatPrimesSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var fermatNumbers = new FermatNumbersSequence().Sequence.Take(5);

            foreach (var n in fermatNumbers)
            {
                yield return n;
            }
        }
    }
}
