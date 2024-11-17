using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class GolombsSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 1;
            yield return 2;
            yield return 2;

            var queue = new Queue<BigInteger>();
            queue.Enqueue(2);

            for (var i = 3; ; i++)
            {
                var repetitions = queue.Dequeue();
                for (var j = 0; j < repetitions; j++)
                {
                    queue.Enqueue(i);
                    yield return i;
                }
            }
        }
    }
}
