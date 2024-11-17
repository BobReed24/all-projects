import sys

sys.set_int_max_str_digits(0)

def check(number: int) -> bool:
    
    check_last = [0] * 11
    check_front = [0] * 11

    for _ in range(9):
        check_last[int(number % 10)] = 1
        number = number // 10
    
    f = True

    for x in range(9):
        if not check_last[x + 1]:
            f = False
    if not f:
        return f

    number = int(str(number)[:9])

    for _ in range(9):
        check_front[int(number % 10)] = 1
        number = number // 10

    for x in range(9):
        if not check_front[x + 1]:
            f = False
    return f

def check1(number: int) -> bool:
    
    check_last = [0] * 11

    for _ in range(9):
        check_last[int(number % 10)] = 1
        number = number // 10
    
    f = True

    for x in range(9):
        if not check_last[x + 1]:
            f = False
    return f

def solution() -> int:
    
    a = 1
    b = 1
    c = 2
    
    a1 = 1
    b1 = 1
    c1 = 2
    
    tocheck = [0] * 1000000
    m = 1000000000

    for x in range(1000000):
        c1 = (a1 + b1) % m
        a1 = b1 % m
        b1 = c1 % m
        if check1(b1):
            tocheck[x + 3] = 1

    for x in range(1000000):
        c = a + b
        a = b
        b = c
        
        if tocheck[x + 3] and check(b):
            return x + 3  
    return -1

if __name__ == "__main__":
    print(f"{solution() = }")
