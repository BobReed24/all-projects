using System;
using Algorithms.Sorters.Integer;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.Integer;

public static class RadixSorterTests
{
    [Test]
    public static void SortsArray(
        [Random(0, 1000, 100, Distinct = true)]
        int n)
    {
        
        var sorter = new RadixSorter();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        sorter.Sort(testArray);
        Array.Sort(correctArray);

        Assert.That(testArray, Is.EqualTo(correctArray));
    }
}
