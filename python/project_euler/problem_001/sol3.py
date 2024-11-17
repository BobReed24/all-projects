def solution(n: int = 1000) -> int:
    
    total = 0
    num = 0
    while 1:
        num += 3
        if num >= n:
            break
        total += num
        num += 2
        if num >= n:
            break
        total += num
        num += 1
        if num >= n:
            break
        total += num
        num += 3
        if num >= n:
            break
        total += num
        num += 1
        if num >= n:
            break
        total += num
        num += 2
        if num >= n:
            break
        total += num
        num += 3
        if num >= n:
            break
        total += num
    return total

if __name__ == "__main__":
    print(f"{solution() = }")
