def solution(m: int = 100) -> int:
    
    memo = [[0 for _ in range(m)] for _ in range(m + 1)]
    for i in range(m + 1):
        memo[i][0] = 1

    for n in range(m + 1):
        for k in range(1, m):
            memo[n][k] += memo[n][k - 1]
            if n > k:
                memo[n][k] += memo[n - k - 1][k]

    return memo[m][m - 1] - 1

if __name__ == "__main__":
    print(solution(int(input("Enter a number: ").strip())))
