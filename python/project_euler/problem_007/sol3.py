import itertools
import math

def is_prime(number: int) -> bool:
    
    if 1 < number < 4:
        
        return True
    elif number < 2 or number % 2 == 0 or number % 3 == 0:
        
        return False

    for i in range(5, int(math.sqrt(number) + 1), 6):
        if number % i == 0 or number % (i + 2) == 0:
            return False
    return True

def prime_generator():
    
    num = 2
    while True:
        if is_prime(num):
            yield num
        num += 1

def solution(nth: int = 10001) -> int:
    
    return next(itertools.islice(prime_generator(), nth - 1, nth))

if __name__ == "__main__":
    print(f"{solution() = }")
