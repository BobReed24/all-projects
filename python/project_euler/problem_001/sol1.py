def solution(n: int = 1000) -> int:
    
    return sum(e for e in range(3, n) if e % 3 == 0 or e % 5 == 0)

if __name__ == "__main__":
    print(f"{solution() = }")
