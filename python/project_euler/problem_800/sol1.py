from math import isqrt, log2

def calculate_prime_numbers(max_number: int) -> list[int]:
    
    is_prime = [True] * max_number
    for i in range(2, isqrt(max_number - 1) + 1):
        if is_prime[i]:
            for j in range(i**2, max_number, i):
                is_prime[j] = False

    return [i for i in range(2, max_number) if is_prime[i]]

def solution(base: int = 800800, degree: int = 800800) -> int:
    
    upper_bound = degree * log2(base)
    max_prime = int(upper_bound)
    prime_numbers = calculate_prime_numbers(max_prime)

    hybrid_integers_count = 0
    left = 0
    right = len(prime_numbers) - 1
    while left < right:
        while (
            prime_numbers[right] * log2(prime_numbers[left])
            + prime_numbers[left] * log2(prime_numbers[right])
            > upper_bound
        ):
            right -= 1
        hybrid_integers_count += right - left
        left += 1

    return hybrid_integers_count

if __name__ == "__main__":
    print(f"{solution() = }")
