using System;

namespace Algorithms.Search.AStar;

public class PathfindingException : Exception
{
    public PathfindingException(string message)
        : base(message)
    {
    }
}
