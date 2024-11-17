import math

def prime_sieve(n: int) -> list:
    
    is_prime = [True] * n
    is_prime[0] = False
    is_prime[1] = False
    is_prime[2] = True

    for i in range(3, int(n**0.5 + 1), 2):
        index = i * 2
        while index < n:
            is_prime[index] = False
            index = index + i

    primes = [2]

    for i in range(3, n, 2):
        if is_prime[i]:
            primes.append(i)

    return primes

def solution(limit: int = 999_966_663_333) -> int:
    
    primes_upper_bound = math.floor(math.sqrt(limit)) + 100
    primes = prime_sieve(primes_upper_bound)

    matches_sum = 0
    prime_index = 0
    last_prime = primes[prime_index]

    while (last_prime**2) <= limit:
        next_prime = primes[prime_index + 1]

        lower_bound = last_prime**2
        upper_bound = next_prime**2

        current = lower_bound + last_prime
        while upper_bound > current <= limit:
            matches_sum += current
            current += last_prime

        while (upper_bound - next_prime) > limit:
            upper_bound -= next_prime

        current = upper_bound - next_prime
        while current > lower_bound:
            matches_sum += current
            current -= next_prime

        current = 0
        while upper_bound > current <= limit:
            if current <= lower_bound:
                
                current += last_prime * next_prime
                continue

            if current > limit:
                break

            matches_sum -= current * 2

            current += last_prime * next_prime

        last_prime = next_prime
        prime_index += 1

    return matches_sum

if __name__ == "__main__":
    print(solution())
