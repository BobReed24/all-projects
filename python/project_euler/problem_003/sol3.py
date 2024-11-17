def solution(n: int = 600851475143) -> int:
    
    try:
        n = int(n)
    except (TypeError, ValueError):
        raise TypeError("Parameter n must be int or castable to int.")
    if n <= 0:
        raise ValueError("Parameter n must be greater than or equal to one.")
    i = 2
    ans = 0
    if n == 2:
        return 2
    while n > 2:
        while n % i != 0:
            i += 1
        ans = i
        while n % i == 0:
            n = n // i
        i += 1
    return int(ans)

if __name__ == "__main__":
    print(f"{solution() = }")
