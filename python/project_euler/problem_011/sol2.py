import os

def solution():
    
    with open(os.path.dirname(__file__) + "/grid.txt") as f:
        grid = []
        for _ in range(20):
            grid.append([int(x) for x in f.readline().split()])

        maximum = 0

        for i in range(20):
            for j in range(17):
                temp = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3]
                maximum = max(maximum, temp)

        for i in range(17):
            for j in range(20):
                temp = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j]
                maximum = max(maximum, temp)

        for i in range(17):
            for j in range(17):
                temp = (
                    grid[i][j]
                    * grid[i + 1][j + 1]
                    * grid[i + 2][j + 2]
                    * grid[i + 3][j + 3]
                )
                maximum = max(maximum, temp)

        for i in range(17):
            for j in range(3, 20):
                temp = (
                    grid[i][j]
                    * grid[i + 1][j - 1]
                    * grid[i + 2][j - 2]
                    * grid[i + 3][j - 3]
                )
                maximum = max(maximum, temp)
        return maximum

if __name__ == "__main__":
    print(solution())
