using System.Collections.Generic;

namespace Algorithms.Search.AStar;

public static class AStar
{
    
    public static void ResetNodes(List<Node> nodes)
    {
        foreach (var node in nodes)
        {
            node.CurrentCost = 0;
            node.EstimatedCost = 0;
            node.Parent = null;
            node.State = NodeState.Unconsidered;
        }
    }

    public static List<Node> GeneratePath(Node target)
    {
        var ret = new List<Node>();
        var current = target;
        while (!(current is null))
        {
            ret.Add(current);
            current = current.Parent;
        }

        ret.Reverse();
        return ret;
    }

    public static List<Node> Compute(Node from, Node to)
    {
        var done = new List<Node>();

        var open = new PriorityQueue<Node>();
        foreach (var node in from.ConnectedNodes)
        {
            
            if (node.Traversable)
            {
                
                node.CurrentCost = from.CurrentCost + from.DistanceTo(node) * node.TraversalCostMultiplier;
                node.EstimatedCost = from.CurrentCost + node.DistanceTo(to);

                open.Enqueue(node);
            }
        }

        while (true)
        {
            
            if (open.Count == 0)
            {
                ResetNodes(done);
                ResetNodes(open.GetData());
                return new List<Node>();
            }

            var current = open.Dequeue();

            done.Add(current);

            current.State = NodeState.Closed;

            if (current == to)
            {
                var ret = GeneratePath(to); 

                ResetNodes(done);
                ResetNodes(open.GetData());
                return ret;
            }

            AddOrUpdateConnected(current, to, open);
        }
    }

    private static void AddOrUpdateConnected(Node current, Node to, PriorityQueue<Node> queue)
    {
        foreach (var connected in current.ConnectedNodes)
        {
            if (!connected.Traversable ||
                connected.State == NodeState.Closed)
            {
                continue; 
            }

            if (connected.State == NodeState.Unconsidered)
            {
                connected.Parent = current;
                connected.CurrentCost =
                    current.CurrentCost + current.DistanceTo(connected) * connected.TraversalCostMultiplier;
                connected.EstimatedCost = connected.CurrentCost + connected.DistanceTo(to);
                connected.State = NodeState.Open;
                queue.Enqueue(connected);
            }
            else if (current != connected)
            {
                
                var newCCost = current.CurrentCost + current.DistanceTo(connected);
                var newTCost = newCCost + current.EstimatedCost;
                if (newTCost < connected.TotalCost)
                {
                    connected.Parent = current;
                    connected.CurrentCost = newCCost;
                }
            }
            else
            {
                
                throw new PathfindingException(
                    "Detected the same node twice. Confusion how this could ever happen");
            }
        }
    }
}
