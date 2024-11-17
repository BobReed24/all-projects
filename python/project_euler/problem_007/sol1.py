from math import sqrt

def is_prime(number: int) -> bool:
    
    if 1 < number < 4:
        
        return True
    elif number < 2 or number % 2 == 0 or number % 3 == 0:
        
        return False

    for i in range(5, int(sqrt(number) + 1), 6):
        if number % i == 0 or number % (i + 2) == 0:
            return False
    return True

def solution(nth: int = 10001) -> int:
    
    count = 0
    number = 1
    while count != nth and number < 3:
        number += 1
        if is_prime(number):
            count += 1
    while count != nth:
        number += 2
        if is_prime(number):
            count += 1
    return number

if __name__ == "__main__":
    print(f"{solution() = }")
