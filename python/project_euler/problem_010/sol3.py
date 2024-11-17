def solution(n: int = 2000000) -> int:
    
    primality_list = [0 for i in range(n + 1)]
    primality_list[0] = 1
    primality_list[1] = 1

    for i in range(2, int(n**0.5) + 1):
        if primality_list[i] == 0:
            for j in range(i * i, n + 1, i):
                primality_list[j] = 1
    sum_of_primes = 0
    for i in range(n):
        if primality_list[i] == 0:
            sum_of_primes += i
    return sum_of_primes

if __name__ == "__main__":
    print(f"{solution() = }")
