from __future__ import annotations

COLLATZ_SEQUENCE_LENGTHS = {1: 1}

def collatz_sequence_length(n: int) -> int:
    
    if n in COLLATZ_SEQUENCE_LENGTHS:
        return COLLATZ_SEQUENCE_LENGTHS[n]
    next_n = n // 2 if n % 2 == 0 else 3 * n + 1
    sequence_length = collatz_sequence_length(next_n) + 1
    COLLATZ_SEQUENCE_LENGTHS[n] = sequence_length
    return sequence_length

def solution(n: int = 1000000) -> int:
    
    result = max((collatz_sequence_length(i), i) for i in range(1, n))
    return result[1]

if __name__ == "__main__":
    print(solution(int(input().strip())))
