namespace Algorithms.Numeric;

public static class AmicableNumbersChecker
{
    
    public static bool AreAmicableNumbers(int x, int y)
    {
        return SumOfDivisors(x) == y && SumOfDivisors(y) == x;
    }

    private static int SumOfDivisors(int number)
    {
        var sum = 0; 
        for (var i = 1; i < number; ++i)
        {
            if (number % i == 0)
            {
                sum += i;
            }
        }

        return sum;
    }
}
