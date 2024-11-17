DIGITS_SQUARED = [sum(int(c, 10) ** 2 for c in i.__str__()) for i in range(100000)]

def next_number(number: int) -> int:
    
    sum_of_digits_squared = 0
    while number:
        
        sum_of_digits_squared += DIGITS_SQUARED[number % 100000]
        number //= 100000

    return sum_of_digits_squared

CHAINS: list[bool | None] = [None] * 10000000
CHAINS[0] = True
CHAINS[57] = False

def chain(number: int) -> bool:
    
    if CHAINS[number - 1] is not None:
        return CHAINS[number - 1]  

    number_chain = chain(next_number(number))
    CHAINS[number - 1] = number_chain

    while number < 10000000:
        CHAINS[number - 1] = number_chain
        number *= 10

    return number_chain

def solution(number: int = 10000000) -> int:
    
    for i in range(1, number):
        if CHAINS[i] is None:
            chain(i + 1)

    return CHAINS[:number].count(False)

if __name__ == "__main__":
    import doctest

    doctest.testmod()
    print(f"{solution() = }")
