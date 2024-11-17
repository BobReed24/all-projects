import os

def solution(filename: str = "input.txt") -> int:
    
    with open(os.path.join(os.path.dirname(__file__), filename)) as input_file:
        matrix = [
            [int(element) for element in line.split(",")]
            for line in input_file.readlines()
        ]

    rows = len(matrix)
    cols = len(matrix[0])

    minimal_path_sums = [[-1 for _ in range(cols)] for _ in range(rows)]
    for i in range(rows):
        minimal_path_sums[i][0] = matrix[i][0]

    for j in range(1, cols):
        for i in range(rows):
            minimal_path_sums[i][j] = minimal_path_sums[i][j - 1] + matrix[i][j]

        for i in range(1, rows):
            minimal_path_sums[i][j] = min(
                minimal_path_sums[i][j], minimal_path_sums[i - 1][j] + matrix[i][j]
            )

        for i in range(rows - 2, -1, -1):
            minimal_path_sums[i][j] = min(
                minimal_path_sums[i][j], minimal_path_sums[i + 1][j] + matrix[i][j]
            )

    return min(minimal_path_sums_row[-1] for minimal_path_sums_row in minimal_path_sums)

if __name__ == "__main__":
    print(f"{solution() = }")
