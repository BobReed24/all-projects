DIGIT_FACTORIALS = {
    "0": 1,
    "1": 1,
    "2": 2,
    "3": 6,
    "4": 24,
    "5": 120,
    "6": 720,
    "7": 5040,
    "8": 40320,
    "9": 362880,
}

CACHE_SUM_DIGIT_FACTORIALS = {145: 145}

CHAIN_LENGTH_CACHE = {
    145: 0,
    169: 3,
    36301: 3,
    1454: 3,
    871: 2,
    45361: 2,
    872: 2,
}

def sum_digit_factorials(n: int) -> int:
    
    if n in CACHE_SUM_DIGIT_FACTORIALS:
        return CACHE_SUM_DIGIT_FACTORIALS[n]
    ret = sum(DIGIT_FACTORIALS[let] for let in str(n))
    CACHE_SUM_DIGIT_FACTORIALS[n] = ret
    return ret

def chain_length(n: int, previous: set | None = None) -> int:
    
    previous = previous or set()
    if n in CHAIN_LENGTH_CACHE:
        return CHAIN_LENGTH_CACHE[n]
    next_number = sum_digit_factorials(n)
    if next_number in previous:
        CHAIN_LENGTH_CACHE[n] = 0
        return 0
    else:
        previous.add(n)
        ret = 1 + chain_length(next_number, previous)
        CHAIN_LENGTH_CACHE[n] = ret
        return ret

def solution(num_terms: int = 60, max_start: int = 1000000) -> int:
    
    return sum(1 for i in range(1, max_start) if chain_length(i) == num_terms)

if __name__ == "__main__":
    print(f"{solution() = }")
