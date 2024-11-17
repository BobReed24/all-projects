using Algorithms.Other;
using NUnit.Framework;

namespace Algorithms.Tests.Other;

public class LuhnTests
{
    [TestCase("89014103211118510720")] 
    [TestCase("071052120")] 
    [TestCase("449125546588769")] 
    [TestCase("4417123456789113")] 
    public void ValidateTrue(string number)
    {
        
        bool validate;

        validate = Luhn.Validate(number);

        Assert.That(validate, Is.True);
    }

    [TestCase("89012104211118510720")] 
    [TestCase("021053120")] 
    [TestCase("449145545588969")] 
    [TestCase("4437113456749113")] 
    public void ValidateFalse(string number)
    {
        
        bool validate;

        validate = Luhn.Validate(number);

        Assert.That(validate, Is.False);
    }

    [TestCase("x9012104211118510720")] 
    [TestCase("0210x3120")] 
    [TestCase("44914554558896x")] 
    [TestCase("4437113456x49113")] 
    public void GetLostNum(string number)
    {
        
        int lostNum;
        bool validate;

        lostNum = Luhn.GetLostNum(number);
        validate = Luhn.Validate(number.Replace("x", lostNum.ToString()));

        Assert.That(validate, Is.True);
    }
}
