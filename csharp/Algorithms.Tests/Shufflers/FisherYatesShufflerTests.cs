using Algorithms.Shufflers;
using Algorithms.Tests.Helpers;
using FluentAssertions;
using NUnit.Framework;
using System;

namespace Algorithms.Tests.Shufflers;

public static class FisherYatesShufflerTests
{
    [Test]
    public static void ArrayShuffled_NewArrayHasSameSize(
        [Random(10, 1000, 100, Distinct = true)]
        int n)
    {
        
        var shuffler = new FisherYatesShuffler<int>();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        shuffler.Shuffle(testArray);

        testArray.Length.Should().Be(correctArray.Length);
    }

    [Test]
    public static void ArrayShuffled_NewArrayHasSameValues(
        [Random(0, 100, 10, Distinct = true)]
        int n)
    {
        
        var shuffler = new FisherYatesShuffler<int>();
        var (correctArray, testArray) = RandomHelper.GetArrays(n);

        shuffler.Shuffle(testArray);

        testArray.Should().BeEquivalentTo(correctArray);
    }

    [Test]
    public static void ArrayShuffled_SameShuffle(
       [Random(0, 1000, 2, Distinct = true)] int n,
       [Random(1000, 10000, 5, Distinct = true)] int seed)
    {
        
        var shuffler = new FisherYatesShuffler<int>();
        var (array1, array2) = RandomHelper.GetArrays(n);

        shuffler.Shuffle(array1, seed);
        shuffler.Shuffle(array2, seed);

        array1.Should().BeEquivalentTo(array2, options => options.WithStrictOrdering());
    }

    [Test]
    public static void ArrayShuffled_DifferentSeedDifferentShuffle(
      [Random(10, 100, 2, Distinct = true)] int n,
      [Random(1000, 10000, 5, Distinct = true)] int seed)
    {
        
        var shuffler = new FisherYatesShuffler<int>();
        var (array1, array2) = RandomHelper.GetArrays(n);

        shuffler.Shuffle(array1, seed);
        shuffler.Shuffle(array2, seed + 13);

        int hits = 0;
        for (int i = 0; i < n; i++)
        {
            if (array1[i] == array2[i])
            {
                hits++;
            }
        }
        hits.Should().BeLessThan(array2.Length);
    }
}
