from __future__ import annotations

from functools import lru_cache
from math import ceil

NUM_PRIMES = 100

primes = set(range(3, NUM_PRIMES, 2))
primes.add(2)
prime: int

for prime in range(3, ceil(NUM_PRIMES**0.5), 2):
    if prime not in primes:
        continue
    primes.difference_update(set(range(prime * prime, NUM_PRIMES, prime)))

@lru_cache(maxsize=100)
def partition(number_to_partition: int) -> set[int]:
    
    if number_to_partition < 0:
        return set()
    elif number_to_partition == 0:
        return {1}

    ret: set[int] = set()
    prime: int
    sub: int

    for prime in primes:
        if prime > number_to_partition:
            continue
        for sub in partition(number_to_partition - prime):
            ret.add(sub * prime)

    return ret

def solution(number_unique_partitions: int = 5000) -> int | None:
    
    for number_to_partition in range(1, NUM_PRIMES):
        if len(partition(number_to_partition)) > number_unique_partitions:
            return number_to_partition
    return None

if __name__ == "__main__":
    print(f"{solution() = }")
