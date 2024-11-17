def solution(n: int = 4000000) -> int:
    
    even_fibs = []
    a, b = 0, 1
    while b <= n:
        if b % 2 == 0:
            even_fibs.append(b)
        a, b = b, a + b
    return sum(even_fibs)

if __name__ == "__main__":
    print(f"{solution() = }")
