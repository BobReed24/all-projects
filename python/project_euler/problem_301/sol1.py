def solution(exponent: int = 30) -> int:
    
    fibonacci_index = exponent + 2
    phi = (1 + 5**0.5) / 2
    fibonacci = (phi**fibonacci_index - (phi - 1) ** fibonacci_index) / 5**0.5

    return int(fibonacci)

if __name__ == "__main__":
    print(f"{solution() = }")
