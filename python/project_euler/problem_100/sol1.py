def solution(min_total: int = 10**12) -> int:
    
    prev_numerator = 1
    prev_denominator = 0

    numerator = 1
    denominator = 1

    while numerator <= 2 * min_total - 1:
        prev_numerator += 2 * numerator
        numerator += 2 * prev_numerator

        prev_denominator += 2 * denominator
        denominator += 2 * prev_denominator

    return (denominator + 1) // 2

if __name__ == "__main__":
    print(f"{solution() = }")
