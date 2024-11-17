namespace Algorithms.Search;

public static class InterpolationSearch
{
    
    public static int FindIndex(int[] sortedArray, int val)
    {
        var start = 0;
        var end = sortedArray.Length - 1;

        while (start <= end && val >= sortedArray[start] && val <= sortedArray[end])
        {
            var denominator = (sortedArray[end] - sortedArray[start]) * (val - sortedArray[start]);

            if (denominator == 0)
            {
                denominator = 1;
            }

            var pos = start + (end - start) / denominator;

            if (sortedArray[pos] == val)
            {
                return pos;
            }

            if (sortedArray[pos] < val)
            {
                start = pos + 1;
            }
            else
            {
                end = pos - 1;
            }
        }

        return -1;
    }
}
