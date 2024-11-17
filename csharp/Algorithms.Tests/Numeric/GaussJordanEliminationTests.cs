using System;
using Algorithms.Numeric;
using NUnit.Framework;

namespace Algorithms.Tests.Numeric;

public static class GaussJordanEliminationTests
{
    [Test]
    public static void NonSquaredMatrixThrowsException()
    {
        
        var solver = new GaussJordanElimination();
        var input = new double[,] { { 2, -1, 5 }, { 0, 2, 1 }, { 3, 17, 7 } };

        void Act() => solver.Solve(input);

        _ = Assert.Throws<ArgumentException>(Act);
    }

    [Test]
    public static void UnableToSolveSingularMatrix()
    {
        
        var solver = new GaussJordanElimination();
        var input = new double[,] { { 0, 0, 0 }, { 0, 0, 0 } };

        var result = solver.Solve(input);

        Assert.That(result, Is.False);
    }
}
