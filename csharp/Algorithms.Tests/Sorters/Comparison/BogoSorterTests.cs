using System;
using Algorithms.Sorters.Comparison;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.Comparison;

public static class BogoSorterTests
{
    [Test]
    public static void ArraySorted([Random(0, 10, 10, Distinct = true)] int n)
    {
        
        var sorter = new BogoSorter<int>();
        var intComparer = new IntComparer();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        sorter.Sort(testArray, intComparer);
        Array.Sort(correctArray, intComparer);

        Assert.That(correctArray, Is.EqualTo(testArray));
    }
}
