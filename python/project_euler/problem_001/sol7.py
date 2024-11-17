def solution(n: int = 1000) -> int:
    
    result = 0
    for i in range(n):
        if i % 3 == 0 or i % 5 == 0:
            result += i
    return result

if __name__ == "__main__":
    print(f"{solution() = }")
