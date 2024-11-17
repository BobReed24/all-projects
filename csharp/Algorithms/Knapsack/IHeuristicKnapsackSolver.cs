using System;

namespace Algorithms.Knapsack;

public interface IHeuristicKnapsackSolver<T>
{
    
    T[] Solve(T[] items, double capacity, Func<T, double> weightSelector, Func<T, double> valueSelector);
}
