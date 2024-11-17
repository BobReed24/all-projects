using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Other;

public static class DecisionsConvolutions
{
    
    public static List<decimal> Linear(List<List<decimal>> matrix, List<decimal> priorities)
    {
        var decisionValues = new List<decimal>();

        foreach (var decision in matrix)
        {
            decimal sum = 0;
            for (int i = 0; i < decision.Count; i++)
            {
                sum += decision[i] * priorities[i];
            }

            decisionValues.Add(sum);
        }

        decimal bestDecisionValue = decisionValues.Max();
        int bestDecisionIndex = decisionValues.IndexOf(bestDecisionValue);

        return matrix[bestDecisionIndex];
    }

    public static List<decimal> MaxMin(List<List<decimal>> matrix, List<decimal> priorities)
    {
        var decisionValues = new List<decimal>();

        foreach (var decision in matrix)
        {
            decimal minValue = decimal.MaxValue;
            for (int i = 0; i < decision.Count; i++)
            {
                decimal result = decision[i] * priorities[i];
                if (result < minValue)
                {
                    minValue = result;
                }
            }

            decisionValues.Add(minValue);
        }

        decimal bestDecisionValue = decisionValues.Max();
        int bestDecisionIndex = decisionValues.IndexOf(bestDecisionValue);

        return matrix[bestDecisionIndex];
    }
}
