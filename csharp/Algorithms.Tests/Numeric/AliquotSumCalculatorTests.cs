using System;
using Algorithms.Numeric;
using FluentAssertions;
using NUnit.Framework;

namespace Algorithms.Tests.Numeric;

public static class AliquotSumCalculatorTests
{
    [TestCase(1, 0)]
    [TestCase(3, 1)]
    [TestCase(25, 6)]
    [TestCase(99, 57)]
    public static void CalculateSum_SumIsCorrect(int number, int expectedSum)
    {
        
        var result = AliquotSumCalculator.CalculateAliquotSum(number);

        result.Should().Be(expectedSum);
    }

    [TestCase(-2)]
    public static void CalculateSum_NegativeInput_ExceptionIsThrown(int number)
    {
        
        Action act = () => AliquotSumCalculator.CalculateAliquotSum(number);

        act.Should().Throw<ArgumentException>();
    }
}
