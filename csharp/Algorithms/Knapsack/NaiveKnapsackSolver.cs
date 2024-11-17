using System;
using System.Collections.Generic;

namespace Algorithms.Knapsack;

public class NaiveKnapsackSolver<T> : IHeuristicKnapsackSolver<T>
{
    
    public T[] Solve(T[] items, double capacity, Func<T, double> weightSelector, Func<T, double> valueSelector)
    {
        var weight = 0d;
        var left = new List<T>();

        foreach (var item in items)
        {
            var weightDelta = weightSelector(item);
            if (weight + weightDelta <= capacity)
            {
                weight += weightDelta;
                left.Add(item);
            }
        }

        return left.ToArray();
    }
}
