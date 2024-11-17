using System.Collections.Generic;
using Algorithms.DataCompression;
using NUnit.Framework;

namespace Algorithms.Tests.Compressors;

public static class TranslatorTests
{
    [Test]
    public static void TranslateCorrectly()
    {
        
        var translator = new Translator();
        var dict = new Dictionary<string, string>
        {
            { "Hey", "Good day" },
            { " ", " " },
            { "man", "sir" },
            { "!", "." },
        };

        var translatedText = translator.Translate("Hey man!", dict);

        Assert.That(translatedText, Is.EqualTo("Good day sir."));
    }
}
