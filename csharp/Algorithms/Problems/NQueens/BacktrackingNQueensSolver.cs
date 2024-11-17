using System;
using System.Collections.Generic;

namespace Algorithms.Problems.NQueens;

public class BacktrackingNQueensSolver
{
    
    public IEnumerable<bool[,]> BacktrackSolve(int n)
    {
        if (n < 0)
        {
            throw new ArgumentException(nameof(n));
        }

        return BacktrackSolve(new bool[n, n], 0);
    }

    private static IEnumerable<bool[,]> BacktrackSolve(bool[,] board, int col)
    {
        var solutions = col < board.GetLength(0) - 1
            ? HandleIntermediateColumn(board, col)
            : HandleLastColumn(board);
        return solutions;
    }

    private static IEnumerable<bool[,]> HandleIntermediateColumn(bool[,] board, int col)
    {
        
        for (var i = 0; i < board.GetLength(0); i++)
        {
            if (CanPlace(board, i, col))
            {
                board[i, col] = true;

                foreach (var solution in BacktrackSolve(board, col + 1))
                {
                    yield return solution;
                }

                board[i, col] = false;
            }
        }
    }

    private static IEnumerable<bool[,]> HandleLastColumn(bool[,] board)
    {
        var n = board.GetLength(0);
        for (var i = 0; i < n; i++)
        {
            if (CanPlace(board, i, n - 1))
            {
                board[i, n - 1] = true;

                yield return (bool[,])board.Clone();

                board[i, n - 1] = false;
            }
        }
    }

    private static bool CanPlace(bool[,] board, int row, int col)
    {
        
        for (var i = 0; i < col; i++)
        {
            if (board[row, i])
            {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i, j])
            {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; j >= 0 && i < board.GetLength(0); i++, j--)
        {
            if (board[i, j])
            {
                return false;
            }
        }

        return true;
    }
}
