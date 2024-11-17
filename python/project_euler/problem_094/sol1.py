def solution(max_perimeter: int = 10**9) -> int:
    
    prev_value = 1
    value = 2

    perimeters_sum = 0
    i = 0
    perimeter = 0
    while perimeter <= max_perimeter:
        perimeters_sum += perimeter

        prev_value += 2 * value
        value += prev_value

        perimeter = 2 * value + 2 if i % 2 == 0 else 2 * value - 2
        i += 1

    return perimeters_sum

if __name__ == "__main__":
    print(f"{solution() = }")
