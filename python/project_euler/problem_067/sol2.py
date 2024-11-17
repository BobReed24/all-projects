import os

def solution() -> int:
    
    script_dir = os.path.dirname(os.path.realpath(__file__))
    triangle_path = os.path.join(script_dir, "triangle.txt")

    with open(triangle_path) as in_file:
        triangle = [[int(i) for i in line.split()] for line in in_file]

    while len(triangle) != 1:
        last_row = triangle.pop()
        curr_row = triangle[-1]
        for j in range(len(last_row) - 1):
            curr_row[j] += max(last_row[j], last_row[j + 1])
    return triangle[0][0]

if __name__ == "__main__":
    print(solution())
