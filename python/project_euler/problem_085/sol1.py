from __future__ import annotations

from math import ceil, floor, sqrt

def solution(target: int = 2000000) -> int:
    
    triangle_numbers: list[int] = [0]
    idx: int

    for idx in range(1, ceil(sqrt(target * 2) * 1.1)):
        triangle_numbers.append(triangle_numbers[-1] + idx)

    best_product: int = 0
    
    area: int = 0
    
    b_estimate: float
    
    b_floor: int
    
    b_ceil: int
    
    triangle_b_first_guess: int
    
    triangle_b_second_guess: int

    for idx_a, triangle_a in enumerate(triangle_numbers[1:], 1):
        b_estimate = (-1 + sqrt(1 + 8 * target / triangle_a)) / 2
        b_floor = floor(b_estimate)
        b_ceil = ceil(b_estimate)
        triangle_b_first_guess = triangle_numbers[b_floor]
        triangle_b_second_guess = triangle_numbers[b_ceil]

        if abs(target - triangle_b_first_guess * triangle_a) < abs(
            target - best_product
        ):
            best_product = triangle_b_first_guess * triangle_a
            area = idx_a * b_floor

        if abs(target - triangle_b_second_guess * triangle_a) < abs(
            target - best_product
        ):
            best_product = triangle_b_second_guess * triangle_a
            area = idx_a * b_ceil

    return area

if __name__ == "__main__":
    print(f"{solution() = }")
