def solution(length: int = 50) -> int:
    
    ways_number = [1] * (length + 1)

    for row_length in range(3, length + 1):
        for block_length in range(3, row_length + 1):
            for block_start in range(row_length - block_length):
                ways_number[row_length] += ways_number[
                    row_length - block_start - block_length - 1
                ]

            ways_number[row_length] += 1

    return ways_number[length]

if __name__ == "__main__":
    print(f"{solution() = }")
