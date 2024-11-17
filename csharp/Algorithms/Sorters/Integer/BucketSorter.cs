using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Sorters.Integer;

public class BucketSorter : IIntegerSorter
{
    private const int NumOfDigitsInBase10 = 10;

    public void Sort(int[] array)
    {
        if (array.Length <= 1)
        {
            return;
        }

        var totalDigits = NumberOfDigits(array);

        var buckets = new int[NumOfDigitsInBase10, array.Length + 1];

        for (var pass = 1; pass <= totalDigits; pass++)
        {
            DistributeElements(array, buckets, pass); 
            CollectElements(array, buckets); 

            if (pass != totalDigits)
            {
                EmptyBucket(buckets); 
            }
        }
    }

    private static int NumberOfDigits(IEnumerable<int> array) => (int)Math.Floor(Math.Log10(array.Max()) + 1);

    private static void DistributeElements(IEnumerable<int> data, int[,] buckets, int digit)
    {
        
        var divisor = (int)Math.Pow(10, digit);

        foreach (var element in data)
        {
            
            var bucketNumber = NumOfDigitsInBase10 * (element % divisor) / divisor;

            var elementNumber = ++buckets[bucketNumber, 0]; 
            buckets[bucketNumber, elementNumber] = element;
        }
    }

    private static void CollectElements(IList<int> data, int[,] buckets)
    {
        var subscript = 0; 

        for (var i = 0; i < NumOfDigitsInBase10; i++)
        {
            
            for (var j = 1; j <= buckets[i, 0]; j++)
            {
                data[subscript++] = buckets[i, j]; 
            }
        }
    }

    private static void EmptyBucket(int[,] buckets)
    {
        for (var i = 0; i < NumOfDigitsInBase10; i++)
        {
            buckets[i, 0] = 0; 
        }
    }
}
