import os

def solution():
    
    script_dir = os.path.dirname(os.path.realpath(__file__))
    triangle = os.path.join(script_dir, "triangle.txt")

    with open(triangle) as f:
        triangle = f.readlines()

    a = []
    for line in triangle:
        numbers_from_line = []
        for number in line.strip().split(" "):
            numbers_from_line.append(int(number))
        a.append(numbers_from_line)

    for i in range(1, len(a)):
        for j in range(len(a[i])):
            number1 = a[i - 1][j] if j != len(a[i - 1]) else 0
            number2 = a[i - 1][j - 1] if j > 0 else 0
            a[i][j] += max(number1, number2)
    return max(a[-1])

if __name__ == "__main__":
    print(solution())
