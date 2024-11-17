using System;

namespace Algorithms.Search.AStar;

public struct VecN : IEquatable<VecN>
{
    private readonly double[] data;

    public VecN(params double[] vals) => data = vals;

    public int N => data.Length;

    public double SqrLength()
    {
        double ret = 0;
        for (var i = 0; i < data.Length; i++)
        {
            ret += data[i] * data[i];
        }

        return ret;
    }

    public double Length() => Math.Sqrt(SqrLength());

    public double Distance(VecN other)
    {
        var delta = Subtract(other);
        return delta.Length();
    }

    public double SqrDistance(VecN other)
    {
        var delta = Subtract(other);
        return delta.SqrLength();
    }

    public VecN Subtract(VecN other)
    {
        var dd = new double[Math.Max(data.Length, other.data.Length)];
        for (var i = 0; i < dd.Length; i++)
        {
            double val = 0;
            if (data.Length > i)
            {
                val = data[i];
            }

            if (other.data.Length > i)
            {
                val -= other.data[i];
            }

            dd[i] = val;
        }

        return new VecN(dd);
    }

    public bool Equals(VecN other)
    {
        if (other.N != N)
        {
            return false;
        }

        for (var i = 0; i < other.data.Length; i++)
        {
            if (Math.Abs(data[i] - other.data[i]) > 0.000001)
            {
                return false;
            }
        }

        return true;
    }
}
