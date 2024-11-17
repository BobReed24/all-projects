using System;

namespace Algorithms.Other;

public static class Luhn
{
    
    public static bool Validate(string number) => GetSum(number) % 10 == 0;

    public static int GetLostNum(string number)
    {
        var lostIndex = number.Length - 1 - number.LastIndexOf("x", StringComparison.CurrentCultureIgnoreCase);
        var lostNum = GetSum(number.Replace("x", "0", StringComparison.CurrentCultureIgnoreCase)) * 9 % 10;

        if (lostIndex % 2 == 0)
        {
            return lostNum;
        }

        var tempLostNum = lostNum / 2;

        return Validate(number.Replace("x", tempLostNum.ToString())) ? tempLostNum : (lostNum + 9) / 2;
    }

    private static int GetSum(string number)
    {
        var sum = 0;
        for (var i = 0; i < number.Length; i++)
        {
            var d = number[i] - '0';
            d = (i + number.Length) % 2 == 0
                ? 2 * d
                : d;
            if (d > 9)
            {
                d -= 9;
            }

            sum += d;
        }

        return sum;
    }
}
