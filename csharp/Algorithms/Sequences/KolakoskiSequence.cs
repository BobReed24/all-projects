using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class KolakoskiSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 1;
            yield return 2;
            yield return 2;

            var queue = new Queue<int>();
            queue.Enqueue(2);
            var nextElement = 1;
            while (true)
            {
                var nextRun = queue.Dequeue();
                for (var i = 0; i < nextRun; i++)
                {
                    queue.Enqueue(nextElement);
                    yield return nextElement;
                }

                nextElement = 1 + nextElement % 2;
            }
        }
    }
}
