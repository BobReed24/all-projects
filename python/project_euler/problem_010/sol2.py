import math
from collections.abc import Iterator
from itertools import takewhile

def is_prime(number: int) -> bool:
    
    if 1 < number < 4:
        
        return True
    elif number < 2 or number % 2 == 0 or number % 3 == 0:
        
        return False

    for i in range(5, int(math.sqrt(number) + 1), 6):
        if number % i == 0 or number % (i + 2) == 0:
            return False
    return True

def prime_generator() -> Iterator[int]:
    
    num = 2
    while True:
        if is_prime(num):
            yield num
        num += 1

def solution(n: int = 2000000) -> int:
    
    return sum(takewhile(lambda x: x < n, prime_generator()))

if __name__ == "__main__":
    print(f"{solution() = }")
