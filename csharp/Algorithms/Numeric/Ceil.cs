using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class Ceil
{
    
    public static T CeilVal<T>(T inputNum) where T : INumber<T>
    {
        T intPart = T.CreateChecked(Convert.ToInt32(inputNum));

        return inputNum > intPart ? intPart + T.One : intPart;
    }
}
