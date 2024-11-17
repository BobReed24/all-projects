using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class TetranacciNumbersSequence : ISequence
{
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var buffer = Enumerable.Repeat(BigInteger.One, 4).ToArray();
            while (true)
            {
                yield return buffer[0];
                var next = buffer[0] + buffer[1] + buffer[2] + buffer[3];
                buffer[0] = buffer[1];
                buffer[1] = buffer[2];
                buffer[2] = buffer[3];
                buffer[3] = next;
            }
        }
    }
}
