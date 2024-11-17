using System;

namespace Algorithms.Numeric;

public class GaussJordanElimination
{
    private int RowCount { get; set; }

    public bool Solve(double[,] matrix)
    {
        RowCount = matrix.GetUpperBound(0) + 1;

        if (!CanMatrixBeUsed(matrix))
        {
            throw new ArgumentException("Please use a n*(n+1) matrix with Length > 0.");
        }

        var pivot = PivotMatrix(ref matrix);
        if (!pivot)
        {
            return false;
        }

        Elimination(ref matrix);

        return ElementaryReduction(ref matrix);
    }

    private bool CanMatrixBeUsed(double[,] matrix) => matrix?.Length == RowCount * (RowCount + 1) && RowCount > 1;

    private bool PivotMatrix(ref double[,] matrix)
    {
        for (var col = 0; col + 1 < RowCount; col++)
        {
            if (matrix[col, col] == 0)
            {
                
                var rowToSwap = FindNonZeroCoefficient(ref matrix, col);

                if (matrix[rowToSwap, col] != 0)
                {
                    var tmp = new double[RowCount + 1];
                    for (var i = 0; i < RowCount + 1; i++)
                    {
                        
                        tmp[i] = matrix[rowToSwap, i];
                        matrix[rowToSwap, i] = matrix[col, i];
                        matrix[col, i] = tmp[i];
                    }
                }
                else
                {
                    
                    return false;
                }
            }
        }

        return true;
    }

    private int FindNonZeroCoefficient(ref double[,] matrix, int col)
    {
        var rowToSwap = col + 1;

        for (; rowToSwap < RowCount; rowToSwap++)
        {
            if (matrix[rowToSwap, col] != 0)
            {
                return rowToSwap;
            }
        }

        return col + 1;
    }

    private void Elimination(ref double[,] matrix)
    {
        for (var srcRow = 0; srcRow + 1 < RowCount; srcRow++)
        {
            for (var destRow = srcRow + 1; destRow < RowCount; destRow++)
            {
                var df = matrix[srcRow, srcRow];
                var sf = matrix[destRow, srcRow];

                for (var i = 0; i < RowCount + 1; i++)
                {
                    matrix[destRow, i] = matrix[destRow, i] * df - matrix[srcRow, i] * sf;
                }
            }
        }
    }

    private bool ElementaryReduction(ref double[,] matrix)
    {
        for (var row = RowCount - 1; row >= 0; row--)
        {
            var element = matrix[row, row];
            if (element == 0)
            {
                return false;
            }

            for (var i = 0; i < RowCount + 1; i++)
            {
                matrix[row, i] /= element;
            }

            for (var destRow = 0; destRow < row; destRow++)
            {
                matrix[destRow, RowCount] -= matrix[destRow, row] * matrix[row, RowCount];
                matrix[destRow, row] = 0;
            }
        }

        return true;
    }
}
