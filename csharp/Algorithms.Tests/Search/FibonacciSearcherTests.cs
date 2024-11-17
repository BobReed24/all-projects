using Algorithms.Search;
using FluentAssertions;
using NUnit.Framework;
using System;

namespace Algorithms.Tests.Search;

public static class FibonacciSearcherTests
{
    [Test]
    public static void FindIndex_ItemPresent_IndexCorrect([Random(1, 1000, 10)] int n)
    {
        
        var searcher = new FibonacciSearcher<int>();
        var arrayToSearch = Helper.GetSortedArray(n);
        var present = Helper.GetItemIn(arrayToSearch);

        var actualIndex = searcher.FindIndex(arrayToSearch, present);

        arrayToSearch[actualIndex].Should().Be(present);
    }

    [Test]
    public static void FindIndex_ItemMissing_MinusOneReturned([Random(1, 1000, 10)] int n)
    {
        
        var searcher = new FibonacciSearcher<int>();
        var arrayToSearch = Helper.GetSortedArray(n);
        var present = Helper.GetItemNotIn(arrayToSearch);
        var expectedIndex = -1;

        var actualIndex = searcher.FindIndex(arrayToSearch, present);

        actualIndex.Should().Be(expectedIndex);
    }

    [Test]
    public static void FindIndex_ArrayEmpty_MinusOneReturned([Random(1, 1000, 10)] int missingItem)
    {
        
        var searcher = new FibonacciSearcher<int>();
        var sortedArray = Array.Empty<int>();
        var expectedIndex = -1;

        var actualIndex = searcher.FindIndex(sortedArray, missingItem);

        actualIndex.Should().Be(expectedIndex);
    }

    [TestCase(null, "a")]
    [TestCase(new[] { "a", "b", "c" }, null)]
    [TestCase(null, null)]
    public static void FindIndex_ArrayNull_ItemNull_ArgumentNullExceptionThrown(string[] sortedArray, string searchItem)
    {
        
        var searcher = new FibonacciSearcher<string>();

        Action action = () => searcher.FindIndex(sortedArray, searchItem);

        action.Should().Throw<ArgumentNullException>();
    }
}
