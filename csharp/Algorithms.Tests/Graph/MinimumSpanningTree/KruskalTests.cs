using Algorithms.Graph.MinimumSpanningTree;
using FluentAssertions;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Tests.Graph.MinimumSpanningTree;

internal class KruskalTests
{
    [Test]
    public void ValidateGraph_adjWrongSize_ThrowsException()
    {
        
        var adj = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity },
            { 3, 0, 5, 6 },
            { 4, 5, 0, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0 },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity },
        };
        Assert.Throws<ArgumentException>(() => Kruskal.Solve(adj), "adj must be square!");

        adj = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
        };
        Assert.Throws<ArgumentException>(() => Kruskal.Solve(adj), "adj must be square!");
    }

    [Test]
    public void ValidateGraph_adjDirectedGraph_ThrowsException()
    {
        
        var adj = new[,]
        {
            { 0, float.PositiveInfinity, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, 0 },
        };
        Assert.Throws<ArgumentException>(() => Kruskal.Solve(adj), "adj must be symmetric!");
    }

    [Test]
    public void Solve_adjGraph1_CorrectAnswer()
    {
        
        var adj = new float[,]
        {
            { 0, 3, 2 },
            { 3, 0, 2 },
            { 2, 2, 0 },
        };

        var expected = new[,]
        {
            { float.PositiveInfinity, float.PositiveInfinity, 2 },
            { float.PositiveInfinity, float.PositiveInfinity, 2 },
            { 2, 2, float.PositiveInfinity },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void Solve_adjGraph2_CorrectAnswer()
    {
        
        var adj = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, 0 },
        };

        var expected = new[,]
        {
            { float.PositiveInfinity, 3, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, float.PositiveInfinity, float.PositiveInfinity, 6, 2 },
            { 4, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void Solve_adjGraph3_CorrectAnswer()
    {
        
        var adj = new[,]
        {
            { 0, 4, 3, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 4, 0, 1, 2, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 1, 0, 4, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 2, 4, 0, 6, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, 0, 2 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 2, 0 },
        };

        var expected = new[,]
        {
            { float.PositiveInfinity, float.PositiveInfinity, 3, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 1, 2, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 1, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, 6, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, float.PositiveInfinity, 2 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 2, float.PositiveInfinity },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void Solve_adjGraph4_CorrectAnswer()
    {
        
        var adj = new[,]
        {
            { 0, 7, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 7, 0, 8, 9, 7, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 8, 0, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity },
            { 5, 9, float.PositiveInfinity, 0, 15, 6, float.PositiveInfinity },
            { float.PositiveInfinity, 7, 5, 15, 0, 8, 9 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, 8, 0, 11 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 9, 11, 0 },
        };

        var expected = new[,]
        {
            { float.PositiveInfinity, 7, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 7, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 7, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity },
            { 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, float.PositiveInfinity },
            { float.PositiveInfinity, 7, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 9 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 9, float.PositiveInfinity, float.PositiveInfinity },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void Solve_adjGraph5_CorrectAnswer()
    {
        
        var adj = new[,]
        {
            { 0, 8, float.PositiveInfinity, 4, float.PositiveInfinity, float.PositiveInfinity, 10, float.PositiveInfinity, float.PositiveInfinity },
            { 8, 0, 15, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 15, 0, 25, 13, 12, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 4, 5, 25, 0, 14, float.PositiveInfinity, 9, 6, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 13, 14, 0, float.PositiveInfinity, float.PositiveInfinity, 16, 18 },
            { float.PositiveInfinity, float.PositiveInfinity, 12, float.PositiveInfinity, float.PositiveInfinity, 0, float.PositiveInfinity, float.PositiveInfinity, 30 },
            { 10, float.PositiveInfinity, float.PositiveInfinity, 9, float.PositiveInfinity, float.PositiveInfinity, 0, 18, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 6, 16, float.PositiveInfinity, 18, 0, 20 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 18, 30, float.PositiveInfinity, 20, 0 },
        };

        var expected = new[,]
        {
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                4,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                5,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                13,
                12,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                4,
                5,
                float.PositiveInfinity,
                float.PositiveInfinity,
                14,
                float.PositiveInfinity,
                9,
                6,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                13,
                14,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                18,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                12,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                9,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                6,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
            {
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                18,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
                float.PositiveInfinity,
            },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void Solve_adjGraph6_CorrectAnswer()
    {
        
        var adj = new[,]
        {
            { 0, 7, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 7, 0, float.PositiveInfinity, 9, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 0, float.PositiveInfinity, 5, float.PositiveInfinity, 2 },
            { 5, 9, float.PositiveInfinity, 0, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 5, float.PositiveInfinity, 0, 8, 9 },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 8, 0, 11 },
            { float.PositiveInfinity, float.PositiveInfinity, 2, float.PositiveInfinity, 9, 11, 0 },
        };

        var expected = new[,]
        {
            { float.PositiveInfinity, 7, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { 7, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 5, float.PositiveInfinity, 2 },
            { 5, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 5, float.PositiveInfinity, float.PositiveInfinity, 8, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 8, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity },
        };

        Kruskal.Solve(adj).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
    }

    [Test]
    public void ValidateGraph_ListDirectedGraph_ThrowsException()
    {
        var adj = new[]
        {
            new Dictionary<int, float>{ { 2, 4 } },
            new Dictionary<int, float>{ { 0, 3 }, { 2, 5 }, { 3, 6 }, { 4, 2 } },
            new Dictionary<int, float>{ { 0, 4 }, { 1, 5 } },
            new Dictionary<int, float>{ { 1, 6 } },
            new Dictionary<int, float>{ { 1, 2 } },
        };
        Assert.Throws<ArgumentException>(() => Kruskal.Solve(adj), "Graph must be undirected!");
    }

    [Test]
    public void Solve_ListGraph1_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 3 }, { 2, 2 } },
            new Dictionary<int, float>{ { 0, 3 }, { 2, 2 } },
            new Dictionary<int, float>{ { 0, 2 }, { 1, 2 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 2, 2 } },
            new Dictionary<int, float>{ { 2, 2 } },
            new Dictionary<int, float>{ { 0, 2 }, { 1, 2 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }

    [Test]
    public void Solve_ListGraph2_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 3 }, { 2, 4 } },
            new Dictionary<int, float>{ { 0, 3 }, { 2, 5 }, { 3, 6 }, { 4, 2 } },
            new Dictionary<int, float>{ { 0, 4 }, { 1, 5 } },
            new Dictionary<int, float>{ { 1, 6 } },
            new Dictionary<int, float>{ { 1, 2 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 1, 3 }, { 2, 4 } },
            new Dictionary<int, float>{ { 0, 3 }, { 3, 6 }, { 4, 2 } },
            new Dictionary<int, float>{ { 0, 4 } },
            new Dictionary<int, float>{ { 1, 6 } },
            new Dictionary<int, float>{ { 1, 2 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }

    [Test]
    public void Solve_ListGraph3_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 4 }, { 2, 3 } },
            new Dictionary<int, float>{ { 0, 4 }, { 2, 1 }, { 3, 2 } },
            new Dictionary<int, float>{ { 0, 3 }, { 1, 1 }, { 3, 4 } },
            new Dictionary<int, float>{ { 1, 2 }, { 2, 4 }, { 4, 6 } },
            new Dictionary<int, float>{ { 3, 6 }, { 5, 2 } },
            new Dictionary<int, float>{ { 4, 2 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 2, 3 } },
            new Dictionary<int, float>{ { 2, 1 }, { 3, 2 } },
            new Dictionary<int, float>{ { 0, 3 }, { 1, 1 } },
            new Dictionary<int, float>{ { 1, 2 }, { 4, 6 } },
            new Dictionary<int, float>{ { 3, 6 }, { 5, 2 } },
            new Dictionary<int, float>{ { 4, 2 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }

    [Test]
    public void Solve_ListGraph4_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 7 }, { 3, 5 } },
            new Dictionary<int, float>{ { 0, 7 }, { 2, 8 }, { 3, 9 }, { 4, 7 } },
            new Dictionary<int, float>{ { 1, 8 }, { 4, 5 } },
            new Dictionary<int, float>{ { 0, 5 }, { 1, 9 }, { 4, 15 }, { 5, 6 } },
            new Dictionary<int, float>{ { 1, 7 }, { 2, 5 }, { 3, 15 }, { 5, 8 }, { 6, 9 } },
            new Dictionary<int, float>{ { 3, 6 }, { 4, 8 }, { 6, 11 } },
            new Dictionary<int, float>{ { 4, 9 }, { 5, 11 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 1, 7 }, { 3, 5 } },
            new Dictionary<int, float>{ { 0, 7 }, { 4, 7 } },
            new Dictionary<int, float>{ { 4, 5 } },
            new Dictionary<int, float>{ { 0, 5 }, { 5, 6 } },
            new Dictionary<int, float>{ { 1, 7 }, { 2, 5 }, { 6, 9 } },
            new Dictionary<int, float>{ { 3, 6 } },
            new Dictionary<int, float>{ { 4, 9 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }

    [Test]
    public void Solve_ListGraph5_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 8 }, { 3, 4 }, { 6, 10 } },
            new Dictionary<int, float>{ { 0, 8 }, { 2, 15 }, { 3, 5 } },
            new Dictionary<int, float>{ { 1, 15 }, { 3, 25 }, { 4, 13 }, { 5, 12 } },
            new Dictionary<int, float>{ { 0, 4 }, { 1, 5 }, { 2, 25 }, { 4, 14 }, { 6, 9 }, { 7, 6 } },
            new Dictionary<int, float>{ { 2, 13 }, { 3, 14 }, { 7, 16 }, { 8, 18 } },
            new Dictionary<int, float>{ { 2, 12 }, { 8, 30 } },
            new Dictionary<int, float>{ { 0, 10 }, { 3, 9 }, { 7, 18 } },
            new Dictionary<int, float>{ { 3, 6 }, { 4, 16 }, { 6, 18 }, { 8, 20 } },
            new Dictionary<int, float>{ { 4, 18 }, { 5, 30 }, { 7, 20 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 3, 4 } },
            new Dictionary<int, float>{ { 3, 5 } },
            new Dictionary<int, float>{ { 4, 13 }, { 5, 12 } },
            new Dictionary<int, float>{ { 0, 4 }, { 1, 5 }, { 4, 14 }, { 6, 9 }, { 7, 6 } },
            new Dictionary<int, float>{ { 2, 13 }, { 3, 14 }, { 8, 18 } },
            new Dictionary<int, float>{ { 2, 12 } },
            new Dictionary<int, float>{ { 3, 9 } },
            new Dictionary<int, float>{ { 3, 6 } },
            new Dictionary<int, float>{ { 4, 18 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }

    [Test]
    public void Solve_ListGraph6_CorrectAnswer()
    {
        
        var adj = new[]
        {
            new Dictionary<int, float>{ { 1, 7 }, { 3, 5 } },
            new Dictionary<int, float>{ { 0, 7 }, { 3, 9 } },
            new Dictionary<int, float>{ { 4, 5 }, { 6, 2 } },
            new Dictionary<int, float>{ { 0, 5 }, { 1, 9 } },
            new Dictionary<int, float>{ { 2, 5 }, { 5, 8 }, { 6, 9 } },
            new Dictionary<int, float>{ { 4, 8 }, { 6, 11 } },
            new Dictionary<int, float>{ { 2, 2 }, { 4, 9 }, { 5, 11 } },
        };

        var expected = new[]
        {
            new Dictionary<int, float>{ { 1, 7 }, { 3, 5 } },
            new Dictionary<int, float>{ { 0, 7 } },
            new Dictionary<int, float>{ { 4, 5 }, { 6, 2 } },
            new Dictionary<int, float>{ { 0, 5 } },
            new Dictionary<int, float>{ { 2, 5 }, { 5, 8 } },
            new Dictionary<int, float>{ { 4, 8 } },
            new Dictionary<int, float>{ { 2, 2 } },
        };

        var res = Kruskal.Solve(adj);
        for (var i = 0; i < adj.Length; i++)
        {
            res[i].OrderBy(edge => edge.Key).SequenceEqual(expected[i]).Should().BeTrue();
        }
    }
}
