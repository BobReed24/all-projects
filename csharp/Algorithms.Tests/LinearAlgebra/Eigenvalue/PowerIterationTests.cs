using System;
using Algorithms.LinearAlgebra.Eigenvalue;
using FluentAssertions;
using NUnit.Framework;
using Utilities.Extensions;

namespace Algorithms.Tests.LinearAlgebra.Eigenvalue;

public class PowerIterationTests
{
    private static readonly object[] DominantVectorTestCases =
    {
        new object[]
        {
            3.0,
            new[] { 0.7071039, 0.70710966 },
            new[,] { { 2.0, 1.0 }, { 1.0, 2.0 } },
        },
        new object[]
        {
            4.235889,
            new[] { 0.91287093, 0.40824829 },
            new[,] { { 2.0, 5.0 }, { 1.0, 2.0 } },
        },
    };

    private readonly double epsilon = Math.Pow(10, -5);

    [Test]
    public void Dominant_ShouldThrowArgumentException_WhenSourceMatrixIsNotSquareShaped()
    {
        
        var source = new double[,] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };

        Action action = () => PowerIteration.Dominant(source, StartVector(source.GetLength(0)), epsilon);

        action.Should().Throw<ArgumentException>().WithMessage("The source matrix is not square-shaped.");
    }

    [Test]
    public void Dominant_ShouldThrowArgumentException_WhenStartVectorIsNotSameSizeAsMatrix()
    {
        
        var source = new double[,] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        var startVector = new double[] { 1, 0, 0, 0 };

        Action action = () => PowerIteration.Dominant(source, startVector, epsilon);

        action.Should().Throw<ArgumentException>()
            .WithMessage("The length of the start vector doesn't equal the size of the source matrix.");
    }

    [TestCaseSource(nameof(DominantVectorTestCases))]
    public void Dominant_ShouldCalculateDominantEigenvalueAndEigenvector(
        double eigenvalue,
        double[] eigenvector,
        double[,] source)
    {
        
        var (actualEigVal, actualEigVec) =
            PowerIteration.Dominant(source, StartVector(source.GetLength(0)), epsilon);

        actualEigVal.Should().BeApproximately(eigenvalue, epsilon);
        actualEigVec.Magnitude().Should().BeApproximately(eigenvector.Magnitude(), epsilon);
    }

    private double[] StartVector(int length) => new Random(111111).NextVector(length);
}
