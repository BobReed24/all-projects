using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class RecamansSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 0;
            var elements = new HashSet<BigInteger> { 0 };
            var previous = 0;
            var i = 1;

            while (true)
            {
                var current = previous - i;
                if (current < 0 || elements.Contains(current))
                {
                    current = previous + i;
                }

                yield return current;
                previous = current;
                elements.Add(current);
                i++;
            }
        }
    }
}
