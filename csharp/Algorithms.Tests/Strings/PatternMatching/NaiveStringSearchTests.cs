using System.Linq;
using Algorithms.Strings;
using Algorithms.Strings.PatternMatching;
using NUnit.Framework;

namespace Algorithms.Tests.Strings;

public static class NaiveStringSearchTests
{
    [Test]
    public static void ThreeMatchesFound_PassExpected()
    {
        
        var pattern = "ABB";
        var content = "ABBBAAABBAABBBBAB";

        var expectedOccurrences = new[] { 0, 6, 10 };
        var actualOccurrences = NaiveStringSearch.NaiveSearch(content, pattern);
        var sequencesAreEqual = expectedOccurrences.SequenceEqual(actualOccurrences);

        Assert.That(sequencesAreEqual, Is.True);
    }

    [Test]
    public static void OneMatchFound_PassExpected()
    {
        
        var pattern = "BAAB";
        var content = "ABBBAAABBAABBBBAB";

        var expectedOccurrences = new[] { 8 };
        var actualOccurrences = NaiveStringSearch.NaiveSearch(content, pattern);
        var sequencesAreEqual = expectedOccurrences.SequenceEqual(actualOccurrences);

        Assert.That(sequencesAreEqual, Is.True);
    }

    [Test]
    public static void NoMatchFound_PassExpected()
    {
        
        var pattern = "XYZ";
        var content = "ABBBAAABBAABBBBAB";

        var expectedOccurrences = new int[0];
        var actualOccurrences = NaiveStringSearch.NaiveSearch(content, pattern);
        var sequencesAreEqual = expectedOccurrences.SequenceEqual(actualOccurrences);

        Assert.That(sequencesAreEqual, Is.True);
    }
}
