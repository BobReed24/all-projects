def least_divisible_repunit(divisor: int) -> int:
    
    if divisor % 5 == 0 or divisor % 2 == 0:
        return 0
    repunit = 1
    repunit_index = 1
    while repunit:
        repunit = (10 * repunit + 1) % divisor
        repunit_index += 1
    return repunit_index

def solution(limit: int = 1000000) -> int:
    
    divisor = limit - 1
    if divisor % 2 == 0:
        divisor += 1
    while least_divisible_repunit(divisor) <= limit:
        divisor += 2
    return divisor

if __name__ == "__main__":
    print(f"{solution() = }")
