namespace Algorithms.Sorters.Integer;

public class RadixSorter : IIntegerSorter
{
    
    public void Sort(int[] array)
    {
        var bits = 4;
        var b = new int[array.Length];
        var rshift = 0;
        for (var mask = ~(-1 << bits); mask != 0; mask <<= bits, rshift += bits)
        {
            var cntarray = new int[1 << bits];
            foreach (var t in array)
            {
                var key = (t & mask) >> rshift;
                ++cntarray[key];
            }

            for (var i = 1; i < cntarray.Length; ++i)
            {
                cntarray[i] += cntarray[i - 1];
            }

            for (var p = array.Length - 1; p >= 0; --p)
            {
                var key = (array[p] & mask) >> rshift;
                --cntarray[key];
                b[cntarray[key]] = array[p];
            }

            var temp = b;
            b = array;
            array = temp;
        }
    }
}
