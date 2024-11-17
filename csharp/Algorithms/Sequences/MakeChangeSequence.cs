using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class MakeChangeSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            var seed = new List<BigInteger>
                       {
                           1, 1, 2, 2, 3, 4, 5, 6, 7, 8,
                           11, 12, 15, 16, 19, 22, 25,
                       };
            foreach (var value in seed)
            {
                yield return value;
            }

            for(var index = 17; ; index++)
            {
                BigInteger newValue = seed[index - 2] + seed[index - 5] - seed[index - 7]
                                    + seed[index - 10] - seed[index - 12] - seed[index - 15]
                                    + seed[index - 17] + 1;

                seed.Add(newValue);
                yield return newValue;
            }
        }
    }
}
