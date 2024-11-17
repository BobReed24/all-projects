using System;
using System.Linq;
using Algorithms.Sorters.Comparison;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.Comparison;

public static class TimSorterTests
{
    private static readonly IntComparer IntComparer = new();
    private static readonly TimSorterSettings Settings = new();

    [Test]
    public static void ArraySorted(
        [Random(0, 10_000, 2000)] int n)
    {
        
        var sorter = new TimSorter<int>(Settings, IntComparer);
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        sorter.Sort(testArray, IntComparer);
        Array.Sort(correctArray, IntComparer);

        Assert.That(correctArray, Is.EqualTo(testArray));
    }

    [Test]
    public static void TinyArray()
    {
        
        var sorter = new TimSorter<int>(Settings, IntComparer);
        var tinyArray = new[] { 1 };
        var correctArray = new[] { 1 };

        sorter.Sort(tinyArray, IntComparer);

        Assert.That(correctArray, Is.EqualTo(tinyArray));
    }

    [Test]
    public static void SmallChunks()
    {
        
        var sorter = new TimSorter<int>(Settings, IntComparer);
        var (correctArray, testArray) = RandomHelper.GetArrays(800);
        Array.Sort(correctArray, IntComparer);
        Array.Sort(testArray, IntComparer);

        var max = testArray.Max();
        var min = testArray.Min();

        correctArray[0] = max;
        correctArray[800-1] = min;
        testArray[0] = max;
        testArray[800 - 1] = min;

        sorter.Sort(testArray, IntComparer);
        Array.Sort(correctArray, IntComparer);

        Assert.That(correctArray, Is.EqualTo(testArray));
    }
}
