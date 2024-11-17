using System;

namespace Algorithms.Search.AStar;

public class Node : IComparable<Node>, IEquatable<Node>
{
    public Node(VecN position, bool traversable, double traverseMultiplier)
    {
        Traversable = traversable;
        Position = position;
        TraversalCostMultiplier = traverseMultiplier;
    }

    public double TotalCost => EstimatedCost + CurrentCost;

    public double EstimatedCost { get; set; }

    public double TraversalCostMultiplier { get; }

    public double CurrentCost { get; set; }

    public NodeState State { get; set; }

    public bool Traversable { get; }

    public Node[] ConnectedNodes { get; set; } = new Node[0];

    public Node? Parent { get; set; }

    public VecN Position { get; }

    public int CompareTo(Node? other) => TotalCost.CompareTo(other?.TotalCost ?? 0);

    public bool Equals(Node? other) => CompareTo(other) == 0;

    public static bool operator ==(Node left, Node right) => left?.Equals(right) != false;

    public static bool operator >(Node left, Node right) => left.CompareTo(right) > 0;

    public static bool operator <(Node left, Node right) => left.CompareTo(right) < 0;

    public static bool operator !=(Node left, Node right) => !(left == right);

    public static bool operator <=(Node left, Node right) => left.CompareTo(right) <= 0;

    public static bool operator >=(Node left, Node right) => left.CompareTo(right) >= 0;

    public override bool Equals(object? obj) => obj is Node other && Equals(other);

    public override int GetHashCode() =>
        Position.GetHashCode()
        + Traversable.GetHashCode()
        + TraversalCostMultiplier.GetHashCode();

    public double DistanceTo(Node other) => Math.Sqrt(Position.SqrDistance(other.Position));
}
