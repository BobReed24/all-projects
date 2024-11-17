def solution(length: int = 50) -> int:
    
    ways_number = [1] * (length + 1)

    for row_length in range(length + 1):
        for tile_length in range(2, 5):
            for tile_start in range(row_length - tile_length + 1):
                ways_number[row_length] += ways_number[
                    row_length - tile_start - tile_length
                ]

    return ways_number[length]

if __name__ == "__main__":
    print(f"{solution() = }")
