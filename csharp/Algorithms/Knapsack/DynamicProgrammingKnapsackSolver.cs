using System;
using System.Collections.Generic;

namespace Algorithms.Knapsack;

public class DynamicProgrammingKnapsackSolver<T>
{
    
    public T[] Solve(T[] items, int capacity, Func<T, int> weightSelector, Func<T, double> valueSelector)
    {
        var cache = Tabulate(items, weightSelector, valueSelector, capacity);
        return GetOptimalItems(items, weightSelector, cache, capacity);
    }

    private static T[] GetOptimalItems(T[] items, Func<T, int> weightSelector, double[,] cache, int capacity)
    {
        var currentCapacity = capacity;

        var result = new List<T>();
        for (var i = items.Length - 1; i >= 0; i--)
        {
            if (cache[i + 1, currentCapacity] > cache[i, currentCapacity])
            {
                var item = items[i];
                result.Add(item);
                currentCapacity -= weightSelector(item);
            }
        }

        result.Reverse(); 
        return result.ToArray();
    }

    private static double[,] Tabulate(
        T[] items,
        Func<T, int> weightSelector,
        Func<T, double> valueSelector,
        int maxCapacity)
    {
        
        var n = items.Length;
        var results = new double[n + 1, maxCapacity + 1];
        for (var i = 0; i <= n; i++)
        {
            for (var w = 0; w <= maxCapacity; w++)
            {
                if (i == 0 || w == 0)
                {
                    
                    results[i, w] = 0;
                }
                else if (weightSelector(items[i - 1]) <= w)
                {
                    
                    var iut = items[i - 1]; 
                    var vut = valueSelector(iut); 
                    var wut = weightSelector(iut); 
                    var valueIfTaken = vut + results[i - 1, w - wut];
                    var valueIfNotTaken = results[i - 1, w];
                    results[i, w] = Math.Max(valueIfTaken, valueIfNotTaken);
                }
                else
                {
                    
                    results[i, w] = results[i - 1, w];
                }
            }
        }

        return results;
    }
}
