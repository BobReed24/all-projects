from collections import defaultdict
from math import gcd

def solution(limit: int = 1500000) -> int:
    
    frequencies: defaultdict = defaultdict(int)
    euclid_m = 2
    while 2 * euclid_m * (euclid_m + 1) <= limit:
        for euclid_n in range((euclid_m % 2) + 1, euclid_m, 2):
            if gcd(euclid_m, euclid_n) > 1:
                continue
            primitive_perimeter = 2 * euclid_m * (euclid_m + euclid_n)
            for perimeter in range(primitive_perimeter, limit + 1, primitive_perimeter):
                frequencies[perimeter] += 1
        euclid_m += 1
    return sum(1 for frequency in frequencies.values() if frequency == 1)

if __name__ == "__main__":
    print(f"{solution() = }")
