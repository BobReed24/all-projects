LIMIT = 10**8

def is_palindrome(n: int) -> bool:
    
    if n % 10 == 0:
        return False
    s = str(n)
    return s == s[::-1]

def solution() -> int:
    
    answer = set()
    first_square = 1
    sum_squares = 5
    while sum_squares < LIMIT:
        last_square = first_square + 1
        while sum_squares < LIMIT:
            if is_palindrome(sum_squares):
                answer.add(sum_squares)
            last_square += 1
            sum_squares += last_square**2
        first_square += 1
        sum_squares = first_square**2 + (first_square + 1) ** 2

    return sum(answer)

if __name__ == "__main__":
    print(solution())
