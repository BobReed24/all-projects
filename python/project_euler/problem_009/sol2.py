def solution(n: int = 1000) -> int:
    
    product = -1
    candidate = 0
    for a in range(1, n // 3):
        
        b = (n * n - 2 * a * n) // (2 * n - 2 * a)
        c = n - a - b
        if c * c == (a * a + b * b):
            candidate = a * b * c
            product = max(product, candidate)
    return product

if __name__ == "__main__":
    print(f"{solution() = }")
