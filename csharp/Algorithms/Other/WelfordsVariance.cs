namespace Algorithms.Other;

public class WelfordsVariance
{
    
    private int count;

    public double Count => count;

    private double mean;

    public double Mean => count > 1 ? mean : double.NaN;

    private double m2;

    public double Variance => count > 1 ? m2 / count : double.NaN;

    public double SampleVariance => count > 1 ? m2 / (count - 1) : double.NaN;

    public WelfordsVariance()
    {
        count = 0;
        mean = 0;
    }

    public WelfordsVariance(double[] values)
    {
        count = 0;
        mean = 0;
        AddRange(values);
    }

    public void AddValue(double newValue)
    {
        count++;
        AddValueToDataset(newValue);
    }

    public void AddRange(double[] values)
    {
        var length = values.Length;
        for (var i = 1; i <= length; i++)
        {
            count++;
            AddValueToDataset(values[i - 1]);
        }
    }

    private void AddValueToDataset(double newValue)
    {
        var delta1 = newValue - mean;
        var newMean = mean + delta1 / count;

        var delta2 = newValue - newMean;
        m2 += delta1 * delta2;

        mean = newMean;
    }
}
