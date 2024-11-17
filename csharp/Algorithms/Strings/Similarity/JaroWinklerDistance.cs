using System.Linq;

namespace Algorithms.Strings.Similarity;

public static class JaroWinklerDistance
{
    
    public static double Calculate(string s1, string s2, double scalingFactor = 0.1)
    {
        var jaroSimilarity = JaroSimilarity.Calculate(s1, s2);
        var commonPrefixLength = s1.Zip(s2).Take(4).TakeWhile(x => x.First == x.Second).Count();
        var jaroWinklerSimilarity = jaroSimilarity + commonPrefixLength * scalingFactor * (1 - jaroSimilarity);

        return 1 - jaroWinklerSimilarity;
    }
}
