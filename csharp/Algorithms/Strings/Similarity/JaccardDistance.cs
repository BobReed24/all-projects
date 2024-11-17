namespace Algorithms.Strings.Similarity;

public class JaccardDistance
{
    private readonly JaccardSimilarity jaccardSimilarity = new();

    public double Calculate(string left, string right)
    {
        return 1.0 - jaccardSimilarity.Calculate(left, right);
    }
}
