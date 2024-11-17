def solution(n: int = 1000) -> int:
    
    return sum(i for i in range(n) if i % 3 == 0 or i % 5 == 0)

if __name__ == "__main__":
    print(f"{solution() = }")
