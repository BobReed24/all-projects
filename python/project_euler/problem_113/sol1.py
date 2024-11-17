def choose(n: int, r: int) -> int:
    
    ret = 1.0
    for i in range(1, r + 1):
        ret *= (n + 1 - i) / i
    return round(ret)

def non_bouncy_exact(n: int) -> int:
    
    return choose(8 + n, n) + choose(9 + n, n) - 10

def non_bouncy_upto(n: int) -> int:
    
    return sum(non_bouncy_exact(i) for i in range(1, n + 1))

def solution(num_digits: int = 100) -> int:
    
    return non_bouncy_upto(num_digits)

if __name__ == "__main__":
    print(f"{solution() = }")
