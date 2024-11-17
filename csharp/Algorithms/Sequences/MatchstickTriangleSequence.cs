using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class MatchstickTriangleSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var index = BigInteger.Zero;
            var eight = new BigInteger(8);
            while (true)
            {
                var temp = index * (index + 2) * (index * 2 + 1);
                var result = BigInteger.Divide(temp, eight);
                yield return result;
                index++;
            }
        }
    }
}
