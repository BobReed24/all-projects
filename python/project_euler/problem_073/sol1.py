from math import gcd

def solution(max_d: int = 12_000) -> int:
    
    fractions_number = 0
    for d in range(max_d + 1):
        for n in range(d // 3 + 1, (d + 1) // 2):
            if gcd(n, d) == 1:
                fractions_number += 1
    return fractions_number

if __name__ == "__main__":
    print(f"{solution() = }")
