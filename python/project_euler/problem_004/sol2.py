def solution(n: int = 998001) -> int:
    
    answer = 0
    for i in range(999, 99, -1):  
        for j in range(999, 99, -1):
            product_string = str(i * j)
            if product_string == product_string[::-1] and i * j < n:
                answer = max(answer, i * j)
    return answer

if __name__ == "__main__":
    print(f"{solution() = }")
