def solution(n: int = 1000) -> int:
    
    f1, f2 = 1, 1
    index = 2
    while True:
        i = 0
        f = f1 + f2
        f1, f2 = f2, f
        index += 1
        for _ in str(f):
            i += 1
        if i == n:
            break
    return index

if __name__ == "__main__":
    print(solution(int(str(input()).strip())))
