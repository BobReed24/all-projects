using System;
using System.Numerics;
using Algorithms.Numeric;
using NUnit.Framework;

namespace Algorithms.Tests.Numeric;

public static class MillerRabinPrimalityTest
{
    [TestCase("7", ExpectedResult = true)]  
    [TestCase("47", ExpectedResult = true)] 
    [TestCase("247894109041876714378152933343208766493", ExpectedResult = true)] 
    [TestCase("247894109041876714378152933343208766493", 1, ExpectedResult = true)] 
    [TestCase("315757551269487563269454472438030700351", ExpectedResult = true)] 
    [TestCase("2476099", 12445, ExpectedResult = false)] 
    
    [TestCase("78274436845194327170519855212507883195883737501141260366253362532531612139043", ExpectedResult = false)]
    [Retry(3)]
    public static bool MillerRabinPrimalityWork(string testcase, int? seed = null)
    {
        
        BigInteger number = BigInteger.Parse(testcase);

        BigInteger rounds = (BigInteger)(BigInteger.Log10(number) / BigInteger.Log10(2));

        var result = MillerRabinPrimalityChecker.IsProbablyPrimeNumber(number, rounds, seed);

        return result;
    }

    [TestCase("-2")]
    [TestCase("0")]
    [TestCase("3")]
    
    public static void MillerRabinPrimalityShouldThrowEx(string testcase)
    {
        
        BigInteger number = BigInteger.Parse(testcase);
        BigInteger rounds = 1;
        
        Assert.Throws<ArgumentException>(() => MillerRabinPrimalityChecker.IsProbablyPrimeNumber(number, rounds));
    }
}
