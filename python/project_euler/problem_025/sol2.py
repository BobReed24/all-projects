from collections.abc import Generator

def fibonacci_generator() -> Generator[int, None, None]:
    
    a, b = 0, 1
    while True:
        a, b = b, a + b
        yield b

def solution(n: int = 1000) -> int:
    
    answer = 1
    gen = fibonacci_generator()
    while len(str(next(gen))) < n:
        answer += 1
    return answer + 1

if __name__ == "__main__":
    print(solution(int(str(input()).strip())))
