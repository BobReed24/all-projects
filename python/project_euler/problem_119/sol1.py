import math

def digit_sum(n: int) -> int:
    
    return sum(int(digit) for digit in str(n))

def solution(n: int = 30) -> int:
    
    digit_to_powers = []
    for digit in range(2, 100):
        for power in range(2, 100):
            number = int(math.pow(digit, power))
            if digit == digit_sum(number):
                digit_to_powers.append(number)

    digit_to_powers.sort()
    return digit_to_powers[n - 1]

if __name__ == "__main__":
    print(solution())
