from __future__ import annotations

def get_pascal_triangle_unique_coefficients(depth: int) -> set[int]:
    
    coefficients = {1}
    previous_coefficients = [1]
    for _ in range(2, depth + 1):
        coefficients_begins_one = [*previous_coefficients, 0]
        coefficients_ends_one = [0, *previous_coefficients]
        previous_coefficients = []
        for x, y in zip(coefficients_begins_one, coefficients_ends_one):
            coefficients.add(x + y)
            previous_coefficients.append(x + y)
    return coefficients

def get_squarefrees(unique_coefficients: set[int]) -> set[int]:
    
    non_squarefrees = set()
    for number in unique_coefficients:
        divisor = 2
        copy_number = number
        while divisor**2 <= copy_number:
            multiplicity = 0
            while copy_number % divisor == 0:
                copy_number //= divisor
                multiplicity += 1
            if multiplicity >= 2:
                non_squarefrees.add(number)
                break
            divisor += 1

    return unique_coefficients.difference(non_squarefrees)

def solution(n: int = 51) -> int:
    
    unique_coefficients = get_pascal_triangle_unique_coefficients(n)
    squarefrees = get_squarefrees(unique_coefficients)
    return sum(squarefrees)

if __name__ == "__main__":
    print(f"{solution() = }")
