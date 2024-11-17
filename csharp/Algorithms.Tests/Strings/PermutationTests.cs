using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using Algorithms.Numeric;
using Algorithms.Strings;
using NUnit.Framework;

namespace Algorithms.Tests.Strings;

public class PermutationTests
{
    [TestCase("")]
    [TestCase("A")]
    [TestCase("abcd")]
    [TestCase("aabcd")]
    [TestCase("aabbbcd")]
    [TestCase("aabbccccd")]
    public void Test_GetEveryUniquePermutation(string word)
    {
        var permutations = Permutation.GetEveryUniquePermutation(word);

        var charOccurrence = new Dictionary<char, int>();
        foreach (var c in word)
        {
            if (charOccurrence.ContainsKey(c))
            {
                charOccurrence[c] += 1;
            }
            else
            {
                charOccurrence[c] = 1;
            }
        }
        
        var expectedNumberOfAnagrams = Factorial.Calculate(word.Length);
        expectedNumberOfAnagrams = charOccurrence.Aggregate(expectedNumberOfAnagrams, (current, keyValuePair) =>
        {
            return current / Factorial.Calculate(keyValuePair.Value);
        });
        Assert.That(new BigInteger(permutations.Count), Is.EqualTo(expectedNumberOfAnagrams));
        
        var wordSorted = SortString(word);
        foreach (var permutation in permutations)
        {
            Assert.That(SortString(permutation), Is.EqualTo(wordSorted));
        }
        
        Assert.That(new HashSet<string>(permutations).Count, Is.EqualTo(permutations.Count));
        
    }

    private static string SortString(string word)
    {
        var asArray = word.ToArray();
        Array.Sort(asArray);
        return new string(asArray);
    }
}
