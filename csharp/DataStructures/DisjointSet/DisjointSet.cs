using System.Collections;

namespace DataStructures.DisjointSet;

public class DisjointSet<T>
{
    
    public Node<T> MakeSet(T x) => new(x);

    public Node<T> FindSet(Node<T> node)
    {
        if (node != node.Parent)
        {
            node.Parent = FindSet(node.Parent);
        }

        return node.Parent;
    }

    public void UnionSet(Node<T> x, Node<T> y)
    {
        Node<T> nx = FindSet(x);
        Node<T> ny = FindSet(y);
        if (nx == ny)
        {
            return;
        }

        if (nx.Rank > ny.Rank)
        {
            ny.Parent = nx;
        }
        else if (ny.Rank > nx.Rank)
        {
            nx.Parent = ny;
        }
        else
        {
            nx.Parent = ny;
            ny.Rank++;
        }
    }
}
