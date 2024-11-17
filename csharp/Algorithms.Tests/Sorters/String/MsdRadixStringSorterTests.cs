using System;
using Algorithms.Sorters.String;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.String;

public static class MsdRadixStringSorterTests
{
    [Test]
    public static void ArraySorted(
        [Random(2, 1000, 100, Distinct = true)]
        int n)
    {
        
        var sorter = new MsdRadixStringSorter();
        var (correctArray, testArray) = RandomHelper.GetStringArrays(n, 100, false);

        sorter.Sort(testArray);
        Array.Sort(correctArray);

        Assert.That(testArray, Is.EqualTo(correctArray));
    }
}
