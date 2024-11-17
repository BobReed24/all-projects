using System;

namespace Algorithms.Strings.PatternMatching;

public static class WildCardMatcher
{
    
    public static bool MatchPattern(string inputString, string pattern)
    {
        if (pattern.Length > 0 && pattern[0] == '*')
        {
            throw new ArgumentException("Pattern cannot start with *");
        }

        var inputLength = inputString.Length + 1;
        var patternLength = pattern.Length + 1;

        var dp = new bool[inputLength, patternLength];

        dp[0, 0] = true;

        for (var j = 1; j < patternLength; j++)
        {
            if (pattern[j - 1] == '*')
            {
                dp[0, j] = dp[0, j - 2];
            }
        }

        for (var i = 1; i < inputLength; i++)
        {
            for (var j = 1; j < patternLength; j++)
            {
                MatchRemainingLenghts(inputString, pattern, dp, i, j);
            }
        }

        return dp[inputLength - 1, patternLength - 1];
    }

    private static void MatchRemainingLenghts(string inputString, string pattern, bool[,] dp, int i, int j)
    {
        
        if (inputString[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
        {
            dp[i, j] = dp[i - 1, j - 1];
        }
        else if (pattern[j - 1] == '*')
        {
            MatchForZeroOrMore(inputString, pattern, dp, i, j);
        }
        else
        {
            
        }
    }

    private static void MatchForZeroOrMore(string inputString, string pattern, bool[,] dp, int i, int j)
    {
        if (dp[i, j - 2])
        {
            dp[i, j] = true;
        }
        else if (inputString[i - 1] == pattern[j - 2] || pattern[j - 2] == '.')
        {
            dp[i, j] = dp[i - 1, j];
        }
        else
        {
            
        }
    }
}
