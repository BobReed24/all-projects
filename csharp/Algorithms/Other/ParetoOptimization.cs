using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Other;

public class ParetoOptimization
{
    
    public List<List<decimal>> Optimize(List<List<decimal>> matrix)
    {
        var optimizedMatrix = new List<List<decimal>>(matrix.Select(i => i));
        int i = 0;
        while (i < optimizedMatrix.Count)
        {
            for (int j = i + 1; j < optimizedMatrix.Count; j++)
            {
                decimal directParwiseDifference = GetMinimalPairwiseDifference(optimizedMatrix[i], optimizedMatrix[j]);
                decimal indirectParwiseDifference = GetMinimalPairwiseDifference(optimizedMatrix[j], optimizedMatrix[i]);
                
                if (directParwiseDifference >= 0 || indirectParwiseDifference >= 0)
                {
                    optimizedMatrix.RemoveAt(directParwiseDifference >= 0 ? j : i);
                    i--;
                    break;
                }
            }

            i++;
        }

        return optimizedMatrix;
    }

    private decimal GetMinimalPairwiseDifference(List<decimal> arr1, List<decimal> arr2)
    {
        decimal min = decimal.MaxValue;
        if (arr1.Count == arr2.Count)
        {
            for (int i = 0; i < arr1.Count; i++)
            {
                decimal difference = arr1[i] - arr2[i];
                if (min > difference)
                {
                    min = difference;
                }
            }
        }

        return min;
    }
}
