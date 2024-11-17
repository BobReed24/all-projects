using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public class ThreeNPlusOneStepsSequence : ISequence
{
    
    public IEnumerable<BigInteger> Sequence
    {
        get
        {
            BigInteger startingValue = 1;

            while (true)
            {
                BigInteger counter = 0;
                BigInteger currentValue = startingValue;

                while (currentValue != 1)
                {
                    if (currentValue.IsEven)
                    {
                        currentValue /= 2;
                    }
                    else
                    {
                        currentValue = 3 * currentValue + 1;
                    }

                    counter++;
                }

                yield return counter;
                startingValue++;
            }
        }
    }
}
