def solution(n: int = 1000) -> int:
    
    a = 3
    result = 0
    while a < n:
        if a % 3 == 0 or a % 5 == 0:
            result += a
        elif a % 15 == 0:
            result -= a
        a += 1
    return result

if __name__ == "__main__":
    print(f"{solution() = }")
