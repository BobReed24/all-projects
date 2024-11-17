def solution(limit: int = 1000000) -> int:
    
    primes = set(range(3, limit, 2))
    primes.add(2)
    for p in range(3, limit, 2):
        if p not in primes:
            continue
        primes.difference_update(set(range(p * p, limit, p)))

    phi = [float(n) for n in range(limit + 1)]

    for p in primes:
        for n in range(p, limit + 1, p):
            phi[n] *= 1 - 1 / p

    return int(sum(phi[2:]))

if __name__ == "__main__":
    print(f"{solution() = }")
