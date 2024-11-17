using System;
using System.Linq;

namespace Algorithms.Numeric.Series;

public static class Maclaurin
{
    
    public static double Exp(double x, int n) =>
        Enumerable.Range(0, n).Sum(i => ExpTerm(x, i));

    public static double Sin(double x, int n) =>
        Enumerable.Range(0, n).Sum(i => SinTerm(x, i));

    public static double Cos(double x, int n) =>
        Enumerable.Range(0, n).Sum(i => CosTerm(x, i));

    public static double Exp(double x, double error = 0.00001) => ErrorTermWrapper(x, error, ExpTerm);

    public static double Sin(double x, double error = 0.00001) => ErrorTermWrapper(x, error, SinTerm);

    public static double Cos(double x, double error = 0.00001) => ErrorTermWrapper(x, error, CosTerm);

    private static double ErrorTermWrapper(double x, double error, Func<double, int, double> term)
    {
        if (error <= 0.0 || error >= 1.0)
        {
            throw new ArgumentException("Error value is not on interval (0.0; 1.0).");
        }

        var i = 0;
        var termCoefficient = 0.0;
        var result = 0.0;

        do
        {
            result += termCoefficient;
            termCoefficient = term(x, i);
            i++;
        }
        while (Math.Abs(termCoefficient) > error);

        return result;
    }

    private static double ExpTerm(double x, int i) => Math.Pow(x, i) / (long)Factorial.Calculate(i);

    private static double SinTerm(double x, int i) =>
        Math.Pow(-1, i) / ((long)Factorial.Calculate(2 * i + 1)) * Math.Pow(x, 2 * i + 1);

    private static double CosTerm(double x, int i) =>
        Math.Pow(-1, i) / ((long)Factorial.Calculate(2 * i)) * Math.Pow(x, 2 * i);
}
