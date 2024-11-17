def solution(limit: int = 50000000) -> int:
    
    ret = set()
    prime_square_limit = int((limit - 24) ** (1 / 2))

    primes = set(range(3, prime_square_limit + 1, 2))
    primes.add(2)
    for p in range(3, prime_square_limit + 1, 2):
        if p not in primes:
            continue
        primes.difference_update(set(range(p * p, prime_square_limit + 1, p)))

    for prime1 in primes:
        square = prime1 * prime1
        for prime2 in primes:
            cube = prime2 * prime2 * prime2
            if square + cube >= limit - 16:
                break
            for prime3 in primes:
                tetr = prime3 * prime3 * prime3 * prime3
                total = square + cube + tetr
                if total >= limit:
                    break
                ret.add(total)

    return len(ret)

if __name__ == "__main__":
    print(f"{solution() = }")
