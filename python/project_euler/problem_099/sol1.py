import os
from math import log10

def solution(data_file: str = "base_exp.txt") -> int:
    
    largest: float = 0
    result = 0
    for i, line in enumerate(open(os.path.join(os.path.dirname(__file__), data_file))):
        a, x = list(map(int, line.split(",")))
        if x * log10(a) > largest:
            largest = x * log10(a)
            result = i + 1
    return result

if __name__ == "__main__":
    print(solution())
