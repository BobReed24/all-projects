def _modexpt(base: int, exponent: int, modulo_value: int) -> int:
    
    if exponent == 1:
        return base
    if exponent % 2 == 0:
        x = _modexpt(base, exponent // 2, modulo_value) % modulo_value
        return (x * x) % modulo_value
    else:
        return (base * _modexpt(base, exponent - 1, modulo_value)) % modulo_value

def solution(base: int = 1777, height: int = 1855, digits: int = 8) -> int:
    
    result = base
    for _ in range(1, height):
        result = _modexpt(base, result, 10**digits)

    return result

if __name__ == "__main__":
    print(f"{solution() = }")
