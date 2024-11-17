from __future__ import annotations

import numpy as np

def get_totients(max_one: int) -> list[int]:
    
    totients = np.arange(max_one)

    for i in range(2, max_one):
        if totients[i] == i:
            x = np.arange(i, max_one, i)  
            totients[x] -= totients[x] // i

    return totients.tolist()

def has_same_digits(num1: int, num2: int) -> bool:
    
    return sorted(str(num1)) == sorted(str(num2))

def solution(max_n: int = 10000000) -> int:
    
    min_numerator = 1  
    min_denominator = 0  
    totients = get_totients(max_n + 1)

    for i in range(2, max_n + 1):
        t = totients[i]

        if i * min_denominator < min_numerator * t and has_same_digits(i, t):
            min_numerator = i
            min_denominator = t

    return min_numerator

if __name__ == "__main__":
    print(f"{solution() = }")
