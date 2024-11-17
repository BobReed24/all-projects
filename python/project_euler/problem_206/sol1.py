def is_square_form(num: int) -> bool:
    
    digit = 9

    while num > 0:
        if num % 10 != digit:
            return False
        num //= 100
        digit -= 1

    return True

def solution() -> int:
    
    num = 138902663

    while not is_square_form(num * num):
        if num % 10 == 3:
            num -= 6  
        else:
            num -= 4  

    return num * 10

if __name__ == "__main__":
    print(f"{solution() = }")
