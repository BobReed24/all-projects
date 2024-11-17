using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DataStructures;

public sealed class BitArray : ICloneable, IEnumerator<bool>, IEnumerable<bool>
{
    private readonly bool[] field; 
    private int position = -1; 

    public BitArray(int n)
    {
        if (n < 1)
        {
            field = new bool[0];
        }

        field = new bool[n];
    }

    public BitArray(string sequence)
    {
        
        if (sequence.Length <= 0)
        {
            throw new ArgumentException("Sequence must been greater than or equal to 1");
        }

        ThrowIfSequenceIsInvalid(sequence);

        field = new bool[sequence.Length];
        Compile(sequence);
    }

    public BitArray(bool[] bits) => field = bits;

    private int Length => field.Length;

    public bool this[int offset]
    {
        get => field[offset];
        private set => field[offset] = value;
    }

    public object Clone()
    {
        var theClone = new BitArray(Length);

        for (var i = 0; i < Length; i++)
        {
            theClone[i] = field[i];
        }

        return theClone;
    }

    public IEnumerator<bool> GetEnumerator() => this;

    IEnumerator IEnumerable.GetEnumerator() => this;

    public bool Current => field[position];

    object IEnumerator.Current => field[position];

    public bool MoveNext()
    {
        if (position + 1 >= field.Length)
        {
            return false;
        }

        position++;
        return true;
    }

    public void Reset() => position = -1;

    public void Dispose()
    {
        
    }

    public static BitArray operator &(BitArray one, BitArray two)
    {
        var sequence1 = one.ToString();
        var sequence2 = two.ToString();
        var result = new StringBuilder();
        var tmp = new StringBuilder();

        if (one.Length != two.Length)
        {
            int difference;
            if (one.Length > two.Length)
            {
                
                difference = one.Length - two.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp.Append('0');
                }

                tmp.Append(two);
                sequence2 = tmp.ToString();
            }
            else
            {
                
                difference = two.Length - one.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp.Append('0');
                }

                tmp.Append(one);
                sequence1 = tmp.ToString();
            }
        } 

        var len = one.Length > two.Length ? one.Length : two.Length;
        var ans = new BitArray(len);

        for (var i = 0; i < one.Length; i++)
        {
            result.Append(sequence1[i].Equals('1') && sequence2[i].Equals('1') ? '1' : '0');
        }

        ans.Compile(result.ToString().Trim());

        return ans;
    }

    public static BitArray operator |(BitArray one, BitArray two)
    {
        var sequence1 = one.ToString();
        var sequence2 = two.ToString();
        var result = string.Empty;
        var tmp = string.Empty;

        if (one.Length != two.Length)
        {
            int difference;
            if (one.Length > two.Length)
            {
                
                difference = one.Length - two.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp += '0';
                }

                tmp += two.ToString();
                sequence2 = tmp;
            }
            else
            {
                
                difference = two.Length - one.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp += '0';
                }

                tmp += one.ToString();
                sequence1 = tmp;
            }
        } 

        var len = one.Length > two.Length ? one.Length : two.Length;
        var ans = new BitArray(len);

        for (var i = 0; i < len; i++)
        {
            result += sequence1[i].Equals('0') && sequence2[i].Equals('0') ? '0' : '1';
        }

        result = result.Trim();
        ans.Compile(result);

        return ans;
    }

    public static BitArray operator ~(BitArray one)
    {
        var ans = new BitArray(one.Length);
        var sequence = one.ToString();
        var result = string.Empty;

        foreach (var ch in sequence)
        {
            if (ch == '1')
            {
                result += '0';
            }
            else
            {
                result += '1';
            }
        }

        result = result.Trim();
        ans.Compile(result);

        return ans;
    }

    public static BitArray operator <<(BitArray other, int n)
    {
        var ans = new BitArray(other.Length + n);

        for (var i = 0; i < other.Length; i++)
        {
            ans[i] = other[i];
        }

        return ans;
    }

    public static BitArray operator ^(BitArray one, BitArray two)
    {
        var sequence1 = one.ToString();
        var sequence2 = two.ToString();
        var tmp = string.Empty;

        if (one.Length != two.Length)
        {
            int difference;
            if (one.Length > two.Length)
            {
                
                difference = one.Length - two.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp += '0';
                }

                tmp += two.ToString();
                sequence2 = tmp;
            }
            else
            {
                
                difference = two.Length - one.Length;

                for (var i = 0; i < difference; i++)
                {
                    tmp += '0';
                }

                tmp += one.ToString();
                sequence1 = tmp;
            }
        } 

        var len = one.Length > two.Length ? one.Length : two.Length;
        var ans = new BitArray(len);

        var sb = new StringBuilder();

        for (var i = 0; i < len; i++)
        {
            _ = sb.Append(sequence1[i] == sequence2[i] ? '0' : '1');
        }

        var result = sb.ToString().Trim();
        ans.Compile(result);

        return ans;
    }

    public static BitArray operator >>(BitArray other, int n)
    {
        var ans = new BitArray(other.Length - n);

        for (var i = 0; i < other.Length - n; i++)
        {
            ans[i] = other[i];
        }

        return ans;
    }

    public static bool operator ==(BitArray one, BitArray two)
    {
        if (ReferenceEquals(one, two))
        {
            return true;
        }

        if (one.Length != two.Length)
        {
            return false;
        }

        var status = true;
        for (var i = 0; i < one.Length; i++)
        {
            if (one[i] != two[i])
            {
                status = false;
                break;
            }
        }

        return status;
    }

    public static bool operator !=(BitArray one, BitArray two) => !(one == two);

    public void Compile(string sequence)
    {
        
        if (sequence.Length > field.Length)
        {
            throw new ArgumentException($"{nameof(sequence)} must be not longer than the bit array length");
        }

        ThrowIfSequenceIsInvalid(sequence);

        var tmp = string.Empty;
        if (sequence.Length < field.Length)
        {
            var difference = field.Length - sequence.Length;

            for (var i = 0; i < difference; i++)
            {
                tmp += '0';
            }

            tmp += sequence;
            sequence = tmp;
        }

        for (var i = 0; i < sequence.Length; i++)
        {
            field[i] = sequence[i] == '1';
        }
    }

    public void Compile(int number)
    {
        var tmp = string.Empty;

        if (number <= 0)
        {
            throw new ArgumentException($"{nameof(number)} must be positive");
        }

        var binaryNumber = Convert.ToString(number, 2);

        if (binaryNumber.Length > field.Length)
        {
            throw new ArgumentException("Provided number is too big");
        }

        if (binaryNumber.Length < field.Length)
        {
            var difference = field.Length - binaryNumber.Length;

            for (var i = 0; i < difference; i++)
            {
                tmp += '0';
            }

            tmp += binaryNumber;
            binaryNumber = tmp;
        }

        for (var i = 0; i < binaryNumber.Length; i++)
        {
            field[i] = binaryNumber[i] == '1';
        }
    }

    public void Compile(long number)
    {
        var tmp = string.Empty;

        if (number <= 0)
        {
            throw new ArgumentException($"{nameof(number)} must be positive");
        }

        var binaryNumber = Convert.ToString(number, 2);

        if (binaryNumber.Length > field.Length)
        {
            throw new ArgumentException("Provided number is too big");
        }

        if (binaryNumber.Length < field.Length)
        {
            var difference = field.Length - binaryNumber.Length;

            for (var i = 0; i < difference; i++)
            {
                tmp += '0';
            }

            tmp += binaryNumber;
            binaryNumber = tmp;
        }

        for (var i = 0; i < binaryNumber.Length; i++)
        {
            field[i] = binaryNumber[i] == '1';
        }
    }

    public override string ToString()
    {
        
        return field.Aggregate(string.Empty, (current, t) => current + (t ? "1" : "0"));
    }

    public int NumberOfOneBits()
    {
        
        return field.Count(bit => bit);
    }

    public int NumberOfZeroBits()
    {
        
        return field.Count(bit => !bit);
    }

    public bool EvenParity() => NumberOfOneBits() % 2 == 0;

    public bool OddParity() => NumberOfOneBits() % 2 != 0;

    public long ToInt64()
    {
        
        if (field.Length > 64)
        {
            throw new InvalidOperationException("Value is too big to fit into Int64");
        }

        var sequence = ToString();
        return Convert.ToInt64(sequence, 2);
    }

    public int ToInt32()
    {
        
        if (field.Length > 32)
        {
            throw new InvalidOperationException("Value is too big to fit into Int32");
        }

        var sequence = ToString();
        return Convert.ToInt32(sequence, 2);
    }

    public void ResetField()
    {
        for (var i = 0; i < field.Length; i++)
        {
            field[i] = false;
        }
    }

    public void SetAll(bool flag)
    {
        for (var i = 0; i < field.Length; i++)
        {
            field[i] = flag;
        }
    }

    public override bool Equals(object? obj)
    {
        if (obj is null)
        {
            return false;
        }

        var otherBitArray = (BitArray)obj;

        if (Length != otherBitArray.Length)
        {
            return false;
        }

        for (var i = 0; i < Length; i++)
        {
            if (field[i] != otherBitArray[i])
            {
                return false;
            }
        }

        return true;
    }

    public override int GetHashCode() => ToInt32();

    private static void ThrowIfSequenceIsInvalid(string sequence)
    {
        if (!Match(sequence))
        {
            throw new ArgumentException("The sequence may only contain ones or zeros");
        }
    }

    private static bool Match(string sequence) => sequence.All(ch => ch == '0' || ch == '1');
}
