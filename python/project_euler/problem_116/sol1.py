def solution(length: int = 50) -> int:
    
    different_colour_ways_number = [[0] * 3 for _ in range(length + 1)]

    for row_length in range(length + 1):
        for tile_length in range(2, 5):
            for tile_start in range(row_length - tile_length + 1):
                different_colour_ways_number[row_length][tile_length - 2] += (
                    different_colour_ways_number[row_length - tile_start - tile_length][
                        tile_length - 2
                    ]
                    + 1
                )

    return sum(different_colour_ways_number[length])

if __name__ == "__main__":
    print(f"{solution() = }")
