import math

def solution(n: int = 100) -> int:
    
    sum_of_squares = sum(i * i for i in range(1, n + 1))
    square_of_sum = int(math.pow(sum(range(1, n + 1)), 2))
    return square_of_sum - sum_of_squares

if __name__ == "__main__":
    print(f"{solution() = }")
