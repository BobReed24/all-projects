from __future__ import annotations

from collections.abc import Callable

Matrix = list[list[float | int]]

def solve(matrix: Matrix, vector: Matrix) -> Matrix:
    
    size: int = len(matrix)
    augmented: Matrix = [[0 for _ in range(size + 1)] for _ in range(size)]
    row: int
    row2: int
    col: int
    col2: int
    pivot_row: int
    ratio: float

    for row in range(size):
        for col in range(size):
            augmented[row][col] = matrix[row][col]

        augmented[row][size] = vector[row][0]

    row = 0
    col = 0
    while row < size and col < size:
        
        pivot_row = max((abs(augmented[row2][col]), row2) for row2 in range(col, size))[
            1
        ]
        if augmented[pivot_row][col] == 0:
            col += 1
            continue
        else:
            augmented[row], augmented[pivot_row] = augmented[pivot_row], augmented[row]

        for row2 in range(row + 1, size):
            ratio = augmented[row2][col] / augmented[row][col]
            augmented[row2][col] = 0
            for col2 in range(col + 1, size + 1):
                augmented[row2][col2] -= augmented[row][col2] * ratio

        row += 1
        col += 1

    for col in range(1, size):
        for row in range(col):
            ratio = augmented[row][col] / augmented[col][col]
            for col2 in range(col, size + 1):
                augmented[row][col2] -= augmented[col][col2] * ratio

    return [
        [round(augmented[row][size] / augmented[row][row], 10)] for row in range(size)
    ]

def interpolate(y_list: list[int]) -> Callable[[int], int]:
    
    size: int = len(y_list)
    matrix: Matrix = [[0 for _ in range(size)] for _ in range(size)]
    vector: Matrix = [[0] for _ in range(size)]
    coeffs: Matrix
    x_val: int
    y_val: int
    col: int

    for x_val, y_val in enumerate(y_list):
        for col in range(size):
            matrix[x_val][col] = (x_val + 1) ** (size - col - 1)
        vector[x_val][0] = y_val

    coeffs = solve(matrix, vector)

    def interpolated_func(var: int) -> int:
        
        return sum(
            round(coeffs[x_val][0]) * (var ** (size - x_val - 1))
            for x_val in range(size)
        )

    return interpolated_func

def question_function(variable: int) -> int:
    
    return (
        1
        - variable
        + variable**2
        - variable**3
        + variable**4
        - variable**5
        + variable**6
        - variable**7
        + variable**8
        - variable**9
        + variable**10
    )

def solution(func: Callable[[int], int] = question_function, order: int = 10) -> int:
    
    data_points: list[int] = [func(x_val) for x_val in range(1, order + 1)]

    polynomials: list[Callable[[int], int]] = [
        interpolate(data_points[:max_coeff]) for max_coeff in range(1, order + 1)
    ]

    ret: int = 0
    poly: Callable[[int], int]
    x_val: int

    for poly in polynomials:
        x_val = 1
        while func(x_val) == poly(x_val):
            x_val += 1

        ret += poly(x_val)

    return ret

if __name__ == "__main__":
    print(f"{solution() = }")
