using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms.Problems.StableMarriage;

public static class GaleShapley
{
    
    public static void Match(Proposer[] proposers, Accepter[] accepters)
    {
        if (proposers.Length != accepters.Length)
        {
            throw new ArgumentException("Collections must have equal count");
        }

        while (proposers.Any(m => !IsEngaged(m)))
        {
            DoSingleMatchingRound(proposers.Where(m => !IsEngaged(m)));
        }
    }

    private static bool IsEngaged(Proposer proposer) => proposer.EngagedTo is not null;

    private static void DoSingleMatchingRound(IEnumerable<Proposer> proposers)
    {
        foreach (var newProposer in proposers)
        {
            var accepter = newProposer.PreferenceOrder.First!.Value;

            if (accepter.EngagedTo is null)
            {
                Engage(newProposer, accepter);
            }
            else
            {
                if (accepter.PrefersOverCurrent(newProposer))
                {
                    Free(accepter.EngagedTo);
                    Engage(newProposer, accepter);
                }
            }

            newProposer.PreferenceOrder.RemoveFirst();
        }
    }

    private static void Free(Proposer proposer)
    {
        proposer.EngagedTo = null;
    }

    private static void Engage(Proposer proposer, Accepter accepter)
    {
        proposer.EngagedTo = accepter;
        accepter.EngagedTo = proposer;
    }
}
