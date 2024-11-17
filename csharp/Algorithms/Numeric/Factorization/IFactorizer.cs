namespace Algorithms.Numeric.Factorization;

public interface IFactorizer
{
    
    bool TryFactor(int n, out int factor);
}
