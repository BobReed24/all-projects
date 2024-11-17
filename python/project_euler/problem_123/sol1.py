from __future__ import annotations

from collections.abc import Generator

def sieve() -> Generator[int, None, None]:
    
    factor_map: dict[int, int] = {}
    prime = 2
    while True:
        factor = factor_map.pop(prime, None)
        if factor:
            x = factor + prime
            while x in factor_map:
                x += factor
            factor_map[x] = factor
        else:
            factor_map[prime * prime] = prime
            yield prime
        prime += 1

def solution(limit: float = 1e10) -> int:
    
    primes = sieve()

    n = 1
    while True:
        prime = next(primes)
        if (2 * prime * n) > limit:
            return n
        
        next(primes)
        n += 2

if __name__ == "__main__":
    print(solution())
