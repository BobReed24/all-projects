using System;
using System.Globalization;

namespace Algorithms.Other;

public static class JulianEaster
{
    
    public static DateTime Calculate(int year)
    {
        var a = year % 4;
        var b = year % 7;
        var c = year % 19;
        var d = (19 * c + 15) % 30;
        var e = (2 * a + 4 * b - d + 34) % 7;
        var month = (int)Math.Floor((d + e + 114) / 31M);
        var day = ((d + e + 114) % 31) + 1;

        DateTime easter = new(year, month, day, 00, 00, 00, DateTimeKind.Utc);

        return easter;
    }
}
