from math import isqrt

def slow_calculate_prime_numbers(max_number: int) -> list[int]:
    
    is_prime = [True] * max_number

    for i in range(2, isqrt(max_number - 1) + 1):
        if is_prime[i]:
            
            for j in range(i**2, max_number, i):
                is_prime[j] = False

    return [i for i in range(2, max_number) if is_prime[i]]

def calculate_prime_numbers(max_number: int) -> list[int]:
    
    if max_number <= 2:
        return []

    is_prime = [True] * (max_number // 2)

    for i in range(3, isqrt(max_number - 1) + 1, 2):
        if is_prime[i // 2]:
            
            is_prime[i**2 // 2 :: i] = [False] * (
                
                len(range(i**2 // 2, max_number // 2, i))
            )

    return [2] + [2 * i + 1 for i in range(1, max_number // 2) if is_prime[i]]

def slow_solution(max_number: int = 10**8) -> int:
    
    prime_numbers = slow_calculate_prime_numbers(max_number // 2)

    semiprimes_count = 0
    left = 0
    right = len(prime_numbers) - 1
    while left <= right:
        while prime_numbers[left] * prime_numbers[right] >= max_number:
            right -= 1
        semiprimes_count += right - left + 1
        left += 1

    return semiprimes_count

def while_solution(max_number: int = 10**8) -> int:
    
    prime_numbers = calculate_prime_numbers(max_number // 2)

    semiprimes_count = 0
    left = 0
    right = len(prime_numbers) - 1
    while left <= right:
        while prime_numbers[left] * prime_numbers[right] >= max_number:
            right -= 1
        semiprimes_count += right - left + 1
        left += 1

    return semiprimes_count

def solution(max_number: int = 10**8) -> int:
    
    prime_numbers = calculate_prime_numbers(max_number // 2)

    semiprimes_count = 0
    right = len(prime_numbers) - 1
    for left in range(len(prime_numbers)):
        if left > right:
            break
        for r in range(right, left - 2, -1):
            if prime_numbers[left] * prime_numbers[r] < max_number:
                break
        right = r
        semiprimes_count += right - left + 1

    return semiprimes_count

def benchmark() -> None:
    
    from timeit import timeit

    print("Running performance benchmarks...")

    print(f"slow_solution : {timeit('slow_solution()', globals=globals(), number=10)}")
    print(f"while_sol     : {timeit('while_solution()', globals=globals(), number=10)}")
    print(f"solution      : {timeit('solution()', globals=globals(), number=10)}")

if __name__ == "__main__":
    print(f"Solution: {solution()}")
    benchmark()
