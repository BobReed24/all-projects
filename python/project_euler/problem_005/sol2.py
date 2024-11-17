from maths.greatest_common_divisor import greatest_common_divisor

def lcm(x: int, y: int) -> int:
    
    return (x * y) // greatest_common_divisor(x, y)

def solution(n: int = 20) -> int:
    
    g = 1
    for i in range(1, n + 1):
        g = lcm(g, i)
    return g

if __name__ == "__main__":
    print(f"{solution() = }")
