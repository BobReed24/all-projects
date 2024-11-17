using System;
using Algorithms.Sorters.Integer;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.Integer;

public static class CountingSorterTests
{
    [Test]
    public static void SortsNonEmptyArray(
        [Random(1, 10000, 100, Distinct = true)]
        int n)
    {
        
        var sorter = new CountingSorter();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        sorter.Sort(testArray);
        Array.Sort(correctArray);

        Assert.That(testArray, Is.EqualTo(correctArray));
    }

    [Test]
    public static void SortsEmptyArray()
    {
        
        var sorter = new CountingSorter();
        var (correctArray, testArray) = RandomHelper.GetArrays(0);

        sorter.Sort(testArray);
        Array.Sort(correctArray);

        Assert.That(testArray, Is.Empty);
    }
}
