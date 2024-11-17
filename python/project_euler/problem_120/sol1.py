def solution(n: int = 1000) -> int:
    
    return sum(2 * a * ((a - 1) // 2) for a in range(3, n + 1))

if __name__ == "__main__":
    print(solution())
