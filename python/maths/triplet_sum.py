from __future__ import annotations

from itertools import permutations
from random import randint
from timeit import repeat

def make_dataset() -> tuple[list[int], int]:
    arr = [randint(-1000, 1000) for i in range(10)]
    r = randint(-5000, 5000)
    return (arr, r)

dataset = make_dataset()

def triplet_sum1(arr: list[int], target: int) -> tuple[int, ...]:
    
    for triplet in permutations(arr, 3):
        if sum(triplet) == target:
            return tuple(sorted(triplet))
    return (0, 0, 0)

def triplet_sum2(arr: list[int], target: int) -> tuple[int, int, int]:
    
    arr.sort()
    n = len(arr)
    for i in range(n - 1):
        left, right = i + 1, n - 1
        while left < right:
            if arr[i] + arr[left] + arr[right] == target:
                return (arr[i], arr[left], arr[right])
            elif arr[i] + arr[left] + arr[right] < target:
                left += 1
            elif arr[i] + arr[left] + arr[right] > target:
                right -= 1
    return (0, 0, 0)

def solution_times() -> tuple[float, float]:
    setup_code = 
    test_code1 = 
    test_code2 = 
    times1 = repeat(setup=setup_code, stmt=test_code1, repeat=5, number=10000)
    times2 = repeat(setup=setup_code, stmt=test_code2, repeat=5, number=10000)
    return (min(times1), min(times2))

if __name__ == "__main__":
    from doctest import testmod

    testmod()
    times = solution_times()
    print(f"The time for naive implementation is {times[0]}.")
    print(f"The time for optimized implementation is {times[1]}.")
