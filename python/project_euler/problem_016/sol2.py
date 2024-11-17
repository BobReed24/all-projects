def solution(power: int = 1000) -> int:
    
    n = 2**power
    r = 0
    while n:
        r, n = r + n % 10, n // 10
    return r

if __name__ == "__main__":
    print(solution(int(str(input()).strip())))
