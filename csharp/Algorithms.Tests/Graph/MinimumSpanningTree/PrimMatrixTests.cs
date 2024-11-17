using Algorithms.Graph.MinimumSpanningTree;
using FluentAssertions;
using NUnit.Framework;
using System;
using System.Linq;

namespace Algorithms.Tests.Graph.MinimumSpanningTree;

internal class PrimTests
{
    [Test]
    public void ValidateMatrix_WrongSize_ThrowsException()
    {
        
        var matrix = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity },
            { 3, 0, 5, 6 },
            { 4, 5, 0, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0 },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity },
        };
        Assert.Throws<ArgumentException>(() => PrimMatrix.Solve(matrix, 0));

        matrix = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
        };
        Assert.Throws<ArgumentException>(() => PrimMatrix.Solve(matrix, 0));
    }

    [Test]
    public void ValidateMatrix_UnconnectedGraph_ThrowsException()
    {
        
        var matrix = new[,]
        {
            { 0, 3, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
            { float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, float.PositiveInfinity, 0 },
        };
        Assert.Throws<ArgumentException>(() => PrimMatrix.Solve(matrix, 0));
    }

    [Test]
    public void ValidateMatrix_DirectedGraph_ThrowsException()
    {
        
        var matrix = new[,]
        {
            { 0, float.PositiveInfinity, 4, float.PositiveInfinity, float.PositiveInfinity },
            { 3, 0, 5, 6, 2 },
            { 4, 5, 0, float.PositiveInfinity, float.PositiveInfinity },
            { float.PositiveInfinity, 6, float.PositiveInfinity, 0, float.PositiveInfinity },
            { float.PositiveInfinity, 2, float.PositiveInfinity, float.PositiveInfinity, 0 },
        };
        Assert.Throws<ArgumentException>(() => PrimMatrix.Solve(matrix, 0));
    }

    [Test]
    public void SolveMatrix_Graph1_CorrectAnswer()
    {
        
        var matrix = new float[,]
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

        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            PrimMatrix.Solve(matrix, i).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
        }
    }

    [Test]
    public void SolveMatrix_Graph2_CorrectAnswer()
    {
        
        var matrix = new[,]
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

        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            PrimMatrix.Solve(matrix, i).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
        }
    }

    [Test]
    public void SolveMatrix_Graph3_CorrectAnswer()
    {
        
        var matrix = new[,]
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

        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            PrimMatrix.Solve(matrix, i).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
        }
    }

    [Test]
    public void SolveMatrix_Graph4_CorrectAnswer()
    {
        
        var matrix = new[,]
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

        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            PrimMatrix.Solve(matrix, i).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
        }
    }

    [Test]
    public void SolveMatrix_Graph5_CorrectAnswer()
    {
        
        var matrix = new[,]
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

        for (var i = 0; i < matrix.GetLength(0); i++)
        {
            PrimMatrix.Solve(matrix, i).Cast<float>().SequenceEqual(expected.Cast<float>()).Should().BeTrue();
        }
    }
}
