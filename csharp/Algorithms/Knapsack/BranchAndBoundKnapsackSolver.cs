using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Knapsack;

public class BranchAndBoundKnapsackSolver<T>
{
    
    public T[] Solve(T[] items, int capacity, Func<T, int> weightSelector, Func<T, double> valueSelector)
    {
        
        items = items.OrderBy(i => valueSelector(i) / weightSelector(i)).ToArray();

        Queue<BranchAndBoundNode> nodesQueue = new();

        var maxCumulativeValue = 0.0;

        BranchAndBoundNode root = new(level: -1, taken: false);

        BranchAndBoundNode lastNodeOfOptimalPath = root;

        nodesQueue.Enqueue(root);

        while (nodesQueue.Count != 0)
        {
            
            BranchAndBoundNode parent = nodesQueue.Dequeue();

            if (parent.Level == items.Length - 1)
            {
                continue;
            }

            var left = new BranchAndBoundNode(parent.Level + 1, true, parent);

            var right = new BranchAndBoundNode(parent.Level + 1, false, parent);

            left.CumulativeWeight = parent.CumulativeWeight + weightSelector(items[left.Level]);
            left.CumulativeValue = parent.CumulativeValue + valueSelector(items[left.Level]);
            right.CumulativeWeight = parent.CumulativeWeight;
            right.CumulativeValue = parent.CumulativeValue;

            if (left.CumulativeWeight <= capacity && left.CumulativeValue > maxCumulativeValue)
            {
                maxCumulativeValue = left.CumulativeValue;
                lastNodeOfOptimalPath = left;
            }

            left.UpperBound = ComputeUpperBound(left, items, capacity, weightSelector, valueSelector);
            right.UpperBound = ComputeUpperBound(right, items, capacity, weightSelector, valueSelector);

            if (left.UpperBound > maxCumulativeValue && left.CumulativeWeight < capacity)
            {
                nodesQueue.Enqueue(left);
            }

            if (right.UpperBound > maxCumulativeValue)
            {
                nodesQueue.Enqueue(right);
            }
        }

        return GetItemsFromPath(items, lastNodeOfOptimalPath);
    }

    private static T[] GetItemsFromPath(T[] items, BranchAndBoundNode lastNodeOfPath)
    {
        List<T> takenItems = new();

        for (var current = lastNodeOfPath; current.Parent is not null; current = current.Parent)
        {
            if(current.IsTaken)
            {
                takenItems.Add(items[current.Level]);
            }
        }

        return takenItems.ToArray();
    }

    private static double ComputeUpperBound(BranchAndBoundNode aNode, T[] items, int capacity, Func<T, int> weightSelector, Func<T, double> valueSelector)
    {
        var upperBound = aNode.CumulativeValue;
        var availableWeight = capacity - aNode.CumulativeWeight;
        var nextLevel = aNode.Level + 1;

        while (availableWeight > 0 && nextLevel < items.Length)
        {
            if (weightSelector(items[nextLevel]) <= availableWeight)
            {
                upperBound += valueSelector(items[nextLevel]);
                availableWeight -= weightSelector(items[nextLevel]);
            }
            else
            {
                upperBound += valueSelector(items[nextLevel]) / weightSelector(items[nextLevel]) * availableWeight;
                availableWeight = 0;
            }

            nextLevel++;
        }

        return upperBound;
    }
}
