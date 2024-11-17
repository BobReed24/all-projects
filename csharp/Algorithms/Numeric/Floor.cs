using System;
using System.Numerics;

namespace Algorithms.Numeric;

public static class Floor
{
    
    public static T FloorVal<T>(T inputNum) where T : INumber<T>
    {
        T intPart = T.CreateChecked(Convert.ToInt32(inputNum));

        return inputNum < intPart ? intPart - T.One : intPart;
    }
}
