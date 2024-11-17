from itertools import count

def solution(min_block_length: int = 50) -> int:
    
    fill_count_functions = [1] * min_block_length

    for n in count(min_block_length):
        fill_count_functions.append(1)

        for block_length in range(min_block_length, n + 1):
            for block_start in range(n - block_length):
                fill_count_functions[n] += fill_count_functions[
                    n - block_start - block_length - 1
                ]

            fill_count_functions[n] += 1

        if fill_count_functions[n] > 1_000_000:
            break

    return n

if __name__ == "__main__":
    print(f"{solution() = }")
