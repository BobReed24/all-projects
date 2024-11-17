using System;

namespace Algorithms.Strings.Similarity
{
    
    public static class OptimalStringAlignment
    {
        
        public static double Calculate(string firstString, string secondString)
        {
            ArgumentNullException.ThrowIfNull(nameof(firstString));
            ArgumentNullException.ThrowIfNull(nameof(secondString));

            if (firstString == secondString)
            {
                return 0.0;
            }

            if (firstString.Length == 0)
            {
                return secondString.Length;
            }

            if (secondString.Length == 0)
            {
                return firstString.Length;
            }

            var distanceMatrix = GenerateDistanceMatrix(firstString.Length, secondString.Length);
            distanceMatrix = CalculateDistance(firstString, secondString, distanceMatrix);

            return distanceMatrix[firstString.Length, secondString.Length];
        }

        private static int[,] GenerateDistanceMatrix(int firstLength, int secondLength)
        {
            var distanceMatrix = new int[firstLength + 2, secondLength + 2];

            for (var i = 0; i <= firstLength; i++)
            {
                distanceMatrix[i, 0] = i;
            }

            for (var j = 0; j <= secondLength; j++)
            {
                distanceMatrix[0, j] = j;
            }

            return distanceMatrix;
        }

        private static int[,] CalculateDistance(string firstString, string secondString, int[,] distanceMatrix)
        {
            for (var i = 1; i <= firstString.Length; i++)
            {
                for (var j = 1; j <= secondString.Length; j++)
                {
                    var cost = 1;

                    if (firstString[i - 1] == secondString[j - 1])
                    {
                        cost = 0;
                    }

                    distanceMatrix[i, j] = Minimum(
                        distanceMatrix[i - 1, j - 1] + cost, 
                        distanceMatrix[i, j - 1] + 1, 
                        distanceMatrix[i - 1, j] + 1); 

                    if (i > 1 && j > 1
                        && firstString[i - 1] == secondString[j - 2]
                        && firstString[i - 2] == secondString[j - 1])
                    {
                        distanceMatrix[i, j] = Math.Min(
                            distanceMatrix[i, j],
                            distanceMatrix[i - 2, j - 2] + cost); 
                    }
                }
            }

            return distanceMatrix;
        }

        private static int Minimum(int a, int b, int c)
        {
            return Math.Min(a, Math.Min(b, c));
        }
    }
}
