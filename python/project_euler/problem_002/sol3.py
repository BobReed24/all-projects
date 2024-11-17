def solution(n: int = 4000000) -> int:
    
    if n <= 1:
        return 0
    a = 0
    b = 2
    count = 0
    while 4 * b + a <= n:
        a, b = b, 4 * b + a
        count += a
    return count + b

if __name__ == "__main__":
    print(f"{solution() = }")
