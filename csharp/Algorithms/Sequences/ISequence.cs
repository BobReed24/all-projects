using System.Collections.Generic;
using System.Numerics;

namespace Algorithms.Sequences;

public interface ISequence
{
    
    IEnumerable<BigInteger> Sequence { get; }
}
