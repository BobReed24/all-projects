using System;
using Algorithms.Sorters.Comparison;
using Algorithms.Tests.Helpers;
using NUnit.Framework;

namespace Algorithms.Tests.Sorters.Comparison;

public static class CocktailSorterTests
{
    [Test]
    public static void SortsArray(
        [Random(0, 1000, 100, Distinct = true)]
        int n)
    {
        
        var sorter = new CocktailSorter<int>();
        var intComparer = new IntComparer();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        sorter.Sort(testArray, intComparer);
        Array.Sort(correctArray);

        Assert.That(testArray, Is.EqualTo(correctArray));
    }
}