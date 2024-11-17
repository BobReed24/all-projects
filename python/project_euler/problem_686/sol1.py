import math

def log_difference(number: int) -> float:
    
    log_number = math.log(2, 10) * number
    difference = round((log_number - int(log_number)), 15)

    return difference

def solution(number: int = 678910) -> int:
    
    power_iterator = 90
    position = 0

    lower_limit = math.log(1.23, 10)
    upper_limit = math.log(1.24, 10)
    previous_power = 0

    while position < number:
        difference = log_difference(power_iterator)

        if difference >= upper_limit:
            power_iterator += 93

        elif difference < lower_limit:
            power_iterator += 196

        else:
            previous_power = power_iterator
            power_iterator += 196
            position += 1

    return previous_power

if __name__ == "__main__":
    import doctest

    doctest.testmod()

    print(f"{solution() = }")
