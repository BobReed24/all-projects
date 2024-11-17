def solution(n: int = 4000000) -> int:
    
    i = 1
    j = 2
    total = 0
    while j <= n:
        if j % 2 == 0:
            total += j
        i, j = j, i + j

    return total

if __name__ == "__main__":
    print(f"{solution() = }")
