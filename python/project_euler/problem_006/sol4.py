def solution(n: int = 100) -> int:
    
    sum_of_squares = n * (n + 1) * (2 * n + 1) / 6
    square_of_sum = (n * (n + 1) / 2) ** 2
    return int(square_of_sum - sum_of_squares)

if __name__ == "__main__":
    print(f"{solution() = }")
