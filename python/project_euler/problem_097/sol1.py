def solution(n: int = 10) -> str:
    
    if not isinstance(n, int) or n < 0:
        raise ValueError("Invalid input")
    modulus = 10**n
    number = 28433 * (pow(2, 7830457, modulus)) + 1
    return str(number % modulus)

if __name__ == "__main__":
    from doctest import testmod

    testmod()
    print(f"{solution(10) = }")
