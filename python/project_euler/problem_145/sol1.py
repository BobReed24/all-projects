EVEN_DIGITS = [0, 2, 4, 6, 8]
ODD_DIGITS = [1, 3, 5, 7, 9]

def slow_reversible_numbers(
    remaining_length: int, remainder: int, digits: list[int], length: int
) -> int:
    
    if remaining_length == 0:
        if digits[0] == 0 or digits[-1] == 0:
            return 0

        for i in range(length // 2 - 1, -1, -1):
            remainder += digits[i] + digits[length - i - 1]

            if remainder % 2 == 0:
                return 0

            remainder //= 10

        return 1

    if remaining_length == 1:
        if remainder % 2 == 0:
            return 0

        result = 0
        for digit in range(10):
            digits[length // 2] = digit
            result += slow_reversible_numbers(
                0, (remainder + 2 * digit) // 10, digits, length
            )
        return result

    result = 0
    for digit1 in range(10):
        digits[(length + remaining_length) // 2 - 1] = digit1

        if (remainder + digit1) % 2 == 0:
            other_parity_digits = ODD_DIGITS
        else:
            other_parity_digits = EVEN_DIGITS

        for digit2 in other_parity_digits:
            digits[(length - remaining_length) // 2] = digit2
            result += slow_reversible_numbers(
                remaining_length - 2,
                (remainder + digit1 + digit2) // 10,
                digits,
                length,
            )
    return result

def slow_solution(max_power: int = 9) -> int:
    
    result = 0
    for length in range(1, max_power + 1):
        result += slow_reversible_numbers(length, 0, [0] * length, length)
    return result

def reversible_numbers(
    remaining_length: int, remainder: int, digits: list[int], length: int
) -> int:
    
    if (length - 1) % 4 == 0:
        return 0

    return slow_reversible_numbers(remaining_length, remainder, digits, length)

def solution(max_power: int = 9) -> int:
    
    result = 0
    for length in range(1, max_power + 1):
        result += reversible_numbers(length, 0, [0] * length, length)
    return result

def benchmark() -> None:
    
    from timeit import timeit

    print("Running performance benchmarks...")

    print(f"slow_solution : {timeit('slow_solution()', globals=globals(), number=10)}")
    print(f"solution      : {timeit('solution()', globals=globals(), number=10)}")

if __name__ == "__main__":
    print(f"Solution : {solution()}")
    benchmark()

