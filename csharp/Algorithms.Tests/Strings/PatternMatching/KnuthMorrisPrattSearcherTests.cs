using Algorithms.Strings;
using Algorithms.Strings.PatternMatching;
using NUnit.Framework;

namespace Algorithms.Tests.Strings;

public static class KnuthMorrisPrattSearcherTests
{
    [Test]
    public static void FindIndexes_ItemsPresent_PassExpected()
    {
        
        var searcher = new KnuthMorrisPrattSearcher();
        var str = "ABABAcdeABA";
        var pat = "ABA";

        var expectedItem = new[] { 0, 2, 8 };
        var actualItem = searcher.FindIndexes(str, pat);

        Assert.That(actualItem, Is.EqualTo(expectedItem));
    }

    [Test]
    public static void FindIndexes_ItemsMissing_NoIndexesReturned()
    {
        
        var searcher = new KnuthMorrisPrattSearcher();
        var str = "ABABA";
        var pat = "ABB";

        var indexes = searcher.FindIndexes(str, pat);

        Assert.That(indexes, Is.Empty);
    }

    [Test]
    public static void LongestPrefixSuffixArray_PrefixSuffixOfLength1_PassExpected()
    {
        
        var searcher = new KnuthMorrisPrattSearcher();
        var s = "ABA";

        var expectedItem = new[] { 0, 0, 1 };
        var actualItem = searcher.FindLongestPrefixSuffixValues(s);

        Assert.That(actualItem, Is.EqualTo(expectedItem));
    }

    [Test]
    public static void LongestPrefixSuffixArray_PrefixSuffixOfLength5_PassExpected()
    {
        
        var searcher = new KnuthMorrisPrattSearcher();
        var s = "AABAACAABAA";

        var expectedItem = new[] { 0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5 };
        var actualItem = searcher.FindLongestPrefixSuffixValues(s);

        Assert.That(actualItem, Is.EqualTo(expectedItem));
    }

    [Test]
    public static void LongestPrefixSuffixArray_PrefixSuffixOfLength0_PassExpected()
    {
        
        var searcher = new KnuthMorrisPrattSearcher();
        var s = "AB";

        var expectedItem = new[] { 0, 0 };
        var actualItem = searcher.FindLongestPrefixSuffixValues(s);

        Assert.That(actualItem, Is.EqualTo(expectedItem));
    }
}
