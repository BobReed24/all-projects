def solution(n: int = 100) -> int:
    
    sum_cubes = (n * (n + 1) // 2) ** 2
    sum_squares = n * (n + 1) * (2 * n + 1) // 6
    return sum_cubes - sum_squares

if __name__ == "__main__":
    print(f"{solution() = }")
