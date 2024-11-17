using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class VanEcksSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            yield return 0;
            var dictionary = new Dictionary<BigInteger, BigInteger>();
            BigInteger previous = 0;
            BigInteger currentIndex = 2; 
            while (true)
            {
                BigInteger element = 0;
                if (dictionary.TryGetValue(previous, out var previousIndex))
                {
                    element = currentIndex - previousIndex;
                }

                yield return element;

                dictionary[previous] = currentIndex;
                previous = element;
                currentIndex++;
            }
        }
    }
}
