using System.Collections.Generic;
using System.Linq;

namespace DataStructures;

public class InvertedIndex
{
    private readonly Dictionary<string, List<string>> invertedIndex = new();

    public void AddToIndex(string sourceName, string sourceContent)
    {
        var context = sourceContent.Split(' ').Distinct();
        foreach (var word in context)
        {
            if (!invertedIndex.ContainsKey(word))
            {
                invertedIndex.Add(word, new List<string> { sourceName });
            }
            else
            {
                invertedIndex[word].Add(sourceName);
            }
        }
    }

    public IEnumerable<string> And(IEnumerable<string> terms)
    {
        var entries = terms
            .Select(term => invertedIndex
                .Where(x => x.Key.Equals(term))
                .SelectMany(x => x.Value))
            .ToList();

        var intersection = entries
            .Skip(1)
            .Aggregate(new HashSet<string>(entries.First()), (hashSet, enumerable) =>
            {
                hashSet.IntersectWith(enumerable);
                return hashSet;
            });

        return intersection;
    }

    public IEnumerable<string> Or(IEnumerable<string> terms)
    {
        var sources = new List<string>();
        foreach (var term in terms)
        {
            var source = invertedIndex
                .Where(x => x.Key.Equals(term))
                .SelectMany(x => x.Value);

            sources.AddRange(source);
        }

        return sources.Distinct();
    }
}
