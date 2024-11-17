def solution(n: int = 4000000) -> int:
    
    fib = [0, 1]
    i = 0
    while fib[i] <= n:
        fib.append(fib[i] + fib[i + 1])
        if fib[i + 2] > n:
            break
        i += 1
    total = 0
    for j in range(len(fib) - 1):
        if fib[j] % 2 == 0:
            total += fib[j]

    return total

if __name__ == "__main__":
    print(f"{solution() = }")
