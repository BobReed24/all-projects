def solution(num: int = 100) -> int:
    
    fact = 1
    result = 0
    for i in range(1, num + 1):
        fact *= i

    for j in str(fact):
        result += int(j)

    return result

if __name__ == "__main__":
    print(solution(int(input("Enter the Number: ").strip())))
