using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace Algorithms.Sequences;

public class KolakoskiSequence2 : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 1;
            yield return 2;
            yield return 2;

            var inner = new KolakoskiSequence2().Sequence.Skip(2);
            var nextElement = 1;
            foreach (var runLength in inner)
            {
                yield return nextElement;
                if (runLength > 1)
                {
                    yield return nextElement;
                }

                nextElement = 1 + nextElement % 2;
            }
        }
    }
}
