import decimal

def solution() -> int:
    
    answer = 0
    decimal_context = decimal.Context(prec=105)
    for i in range(2, 100):
        number = decimal.Decimal(i)
        sqrt_number = number.sqrt(decimal_context)
        if len(str(sqrt_number)) > 1:
            answer += int(str(sqrt_number)[0])
            sqrt_number_str = str(sqrt_number)[2:101]
            answer += sum(int(x) for x in sqrt_number_str)
    return answer

if __name__ == "__main__":
    import doctest

    doctest.testmod()
    print(f"{solution() = }")
