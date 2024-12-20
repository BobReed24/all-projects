using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Problems.DynamicProgramming.CoinChange;

public static class DynamicCoinChangeSolver
{
    
    public static int[] GenerateSingleCoinChanges(int coin, int[] coins)
    {
        ValidateCoin(coin);
        ValidateCoinsArray(coins);

        var coinsArrayCopy = new int[coins.Length];

        Array.Copy(coins, coinsArrayCopy, coins.Length);
        Array.Sort(coinsArrayCopy);
        Array.Reverse(coinsArrayCopy);

        var list = new List<int>();

        foreach (var item in coinsArrayCopy)
        {
            if (item > coin)
            {
                continue;
            }

            var difference = coin - item;

            list.Add(difference);
        }

        var result = list.ToArray();

        return result;
    }

    public static Dictionary<int, int[]> GenerateChangesDictionary(int coin, int[] coins)
    {
        var dict = new Dictionary<int, int[]>();
        var currentCoin = 1;

        while (currentCoin <= coin)
        {
            var changeArray = GenerateSingleCoinChanges(currentCoin, coins);
            dict[currentCoin] = changeArray;
            currentCoin++;
        }

        return dict;
    }

    public static int GetMinimalNextCoin(int coin, Dictionary<int, int[]> exchanges)
    {
        var nextCoin = int.MaxValue;
        var minChange = int.MaxValue;

        var coinChanges = exchanges[coin];

        foreach (var change in coinChanges)
        {
            if (change == 0)
            {
                return 0;
            }

            var currentChange = exchanges[change];
            var min = currentChange.Min();

            var minIsLesser = min < minChange;

            if (minIsLesser)
            {
                nextCoin = change;
                minChange = min;
            }
        }

        return nextCoin;
    }

    public static int[] MakeCoinChangeDynamic(int coin, int[] coins)
    {
        var changesTable = GenerateChangesDictionary(coin, coins);
        var list = new List<int>();

        var currentCoin = coin;
        var nextCoin = int.MaxValue;

        while (nextCoin != 0)
        {
            nextCoin = GetMinimalNextCoin(currentCoin, changesTable);
            var difference = currentCoin - nextCoin;
            list.Add(difference);
            currentCoin = nextCoin;
        }

        var result = list.ToArray();

        return result;
    }

    private static void ValidateCoin(int coin)
    {
        if (coin <= 0)
        {
            throw new InvalidOperationException($"The coin cannot be lesser or equal to zero {nameof(coin)}.");
        }
    }

    private static void ValidateCoinsArray(int[] coinsArray)
    {
        var coinsAsArray = coinsArray.ToArray();

        if (coinsAsArray.Length == 0)
        {
            throw new InvalidOperationException($"Coins array cannot be empty {nameof(coinsAsArray)}.");
        }

        var coinsContainOne = coinsAsArray.Any(x => x == 1);

        if (!coinsContainOne)
        {
            throw new InvalidOperationException($"Coins array must contain coin 1 {nameof(coinsAsArray)}.");
        }

        var containsNonPositive = coinsAsArray.Any(x => x <= 0);

        if (containsNonPositive)
        {
            throw new InvalidOperationException(
                $"{nameof(coinsAsArray)} cannot contain numbers less than or equal to zero");
        }

        var containsDuplicates = coinsAsArray.GroupBy(x => x).Any(g => g.Count() > 1);

        if (containsDuplicates)
        {
            throw new InvalidOperationException($"Coins array cannot contain duplicates {nameof(coinsAsArray)}.");
        }
    }
}
