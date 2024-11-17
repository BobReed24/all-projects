from math import isqrt

def is_prime(number: int) -> bool:
    
    return all(number % divisor != 0 for divisor in range(2, isqrt(number) + 1))

def solution(max_prime: int = 10**6) -> int:
    
    primes_count = 0
    cube_index = 1
    prime_candidate = 7
    while prime_candidate < max_prime:
        primes_count += is_prime(prime_candidate)

        cube_index += 1
        prime_candidate += 6 * cube_index

    return primes_count

if __name__ == "__main__":
    print(f"{solution() = }")
