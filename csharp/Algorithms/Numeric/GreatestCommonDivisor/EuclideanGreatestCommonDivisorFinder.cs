namespace Algorithms.Numeric.GreatestCommonDivisor;

public class EuclideanGreatestCommonDivisorFinder : IGreatestCommonDivisorFinder
{
    
    public int FindGcd(int a, int b)
    {
        if (a == 0 && b == 0)
        {
            return int.MaxValue;
        }

        if (a == 0 || b == 0)
        {
            return a + b;
        }

        var aa = a;
        var bb = b;
        var cc = aa % bb;

        while (cc != 0)
        {
            aa = bb;
            bb = cc;
            cc = aa % bb;
        }

        return bb;
    }
}
