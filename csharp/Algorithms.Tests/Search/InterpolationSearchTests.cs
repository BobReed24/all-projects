using Algorithms.Search;
using NUnit.Framework.Internal;
using NUnit.Framework;
using System;
using System.Linq;

namespace Algorithms.Tests.Search;

public static class InterpolationSearchTests
{
    [Test]
    public static void FindIndex_ItemPresent_IndexCorrect([Random(1, 1000, 100)] int n)
    {
        
        var random = Randomizer.CreateRandomizer();
        var arrayToSearch = Enumerable.Range(0, n).Select(_ => random.Next(0, 1000)).OrderBy(x => x).ToArray();
        var selectedIndex = random.Next(0, n);

        var actualIndex = InterpolationSearch.FindIndex(arrayToSearch, arrayToSearch[selectedIndex]);

        Assert.That(arrayToSearch[actualIndex], Is.EqualTo(arrayToSearch[selectedIndex]));
    }

    [Test]
    public static void FindIndex_ItemMissing_MinusOneReturned(
        [Random(0, 1000, 10)] int n,
        [Random(-100, 1100, 10)] int missingItem)
    {
        
        var random = Randomizer.CreateRandomizer();
        var arrayToSearch = Enumerable.Range(0, n)
            .Select(_ => random.Next(0, 1000))
            .Where(x => x != missingItem)
            .OrderBy(x => x).ToArray();

        var actualIndex = InterpolationSearch.FindIndex(arrayToSearch, missingItem);

        Assert.That(actualIndex, Is.EqualTo(-1));
    }

    [Test]
    public static void FindIndex_ArrayEmpty_MinusOneReturned([Random(100)] int itemToSearch)
    {
        
        var arrayToSearch = new int[0];

        var actualIndex = InterpolationSearch.FindIndex(arrayToSearch, itemToSearch);

        Assert.That(actualIndex, Is.EqualTo(-1));
    }
}
