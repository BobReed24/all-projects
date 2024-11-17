using Algorithms.Sorters.Utils;
using NUnit.Framework;
using System.Collections.Generic;

namespace Algorithms.Tests.Sorters.Utils
{
    [TestFixture]
    public class GallopingStrategyTests
    {
        private readonly IComparer<int> comparer = Comparer<int>.Default;

[Test]
        public void GallopLeft_KeyPresent_ReturnsCorrectIndex()
        {
            var array = new[] { 1, 2, 3, 4, 5 };
            var index = GallopingStrategy<int>.GallopLeft(array, 3, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(2));
        }

        [Test]
        public void GallopLeft_KeyNotPresent_ReturnsCorrectIndex()
        {
            var array = new[] { 1, 2, 4, 5 };
            var index = GallopingStrategy<int>.GallopLeft(array, 3, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(2));
        }

        [Test]
        public void GallopLeft_KeyLessThanAll_ReturnsZero()
        {
            var array = new[] { 2, 3, 4, 5 };
            var index = GallopingStrategy<int>.GallopLeft(array, 1, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(0));
        }

        [Test]
        public void GallopLeft_KeyGreaterThanAll_ReturnsLength()
        {
            var array = new[] { 1, 2, 3, 4 };
            var index = GallopingStrategy<int>.GallopLeft(array, 5, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(array.Length));
        }

        [Test]
        public void GallopRight_KeyPresent_ReturnsCorrectIndex()
        {
            var array = new[] { 1, 2, 3, 4, 5 };
            var index = GallopingStrategy<int>.GallopRight(array, 3, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(3));
        }

        [Test]
        public void GallopRight_KeyNotPresent_ReturnsCorrectIndex()
        {
            var array = new[] { 1, 2, 4, 5 };
            var index = GallopingStrategy<int>.GallopRight(array, 3, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(2));
        }

        [Test]
        public void GallopRight_KeyLessThanAll_ReturnsZero()
        {
            var array = new[] { 2, 3, 4, 5 };
            var index = GallopingStrategy<int>.GallopRight(array, 1, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(0));
        }

        [Test]
        public void GallopRight_KeyGreaterThanAll_ReturnsLength()
        {
            var array = new[] { 1, 2, 3, 4 };
            var index = GallopingStrategy<int>.GallopRight(array, 5, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(array.Length));
        }

        [Test]
        public void GallopLeft_EmptyArray_ReturnsZero()
        {
            var array = new int[] { };
            var index = GallopingStrategy<int>.GallopLeft(array, 1, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(0));
        }

        [Test]
        public void GallopRight_EmptyArray_ReturnsZero()
        {
            var array = new int[] { };
            var index = GallopingStrategy<int>.GallopRight(array, 1, 0, array.Length, comparer);
            Assert.That(index, Is.EqualTo(0));
        }

        [Test]
        public void TestBoundLeftShift_WhenShiftableCausesNegativeShift_ReturnsShiftedValuePlusOne()
        {
            
            int shiftable = int.MaxValue; 

            int result = GallopingStrategy<int>.BoundLeftShift(shiftable);

            Assert.That((shiftable << 1) + 1, Is.EqualTo(result));  
        }

        [Test]
        public void TestBoundLeftShift_WhenShiftableDoesNotCauseNegativeShift_ReturnsMaxValue()
        {
            
            int shiftable = 1;  

            int result = GallopingStrategy<int>.BoundLeftShift(shiftable);

            Assert.That(int.MaxValue, Is.EqualTo(result));  
        }
    }
}
