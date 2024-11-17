from math import factorial

def solution(num: int = 100) -> int:
    
    return sum(int(x) for x in str(factorial(num)))

if __name__ == "__main__":
    print(solution(int(input("Enter the Number: ").strip())))
