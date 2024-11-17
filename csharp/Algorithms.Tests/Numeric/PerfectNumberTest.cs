using System;
using Algorithms.Numeric;
using NUnit.Framework;

namespace Algorithms.Tests.Numeric;

public static class PerfectNumberTests
{
    [TestCase(6)]
    [TestCase(28)]
    [TestCase(496)]
    [TestCase(8128)]
    public static void PerfectNumberWork(int number)
    {
        
        var result = PerfectNumberChecker.IsPerfectNumber(number);

        Assert.That(result, Is.True);
    }

    [TestCase(-2)]
    public static void PerfectNumberShouldThrowEx(int number)
    {
        
        Assert.Throws<ArgumentException>(() => PerfectNumberChecker.IsPerfectNumber(number));
    }
}
