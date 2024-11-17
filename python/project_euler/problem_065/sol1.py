def sum_digits(num: int) -> int:
    
    digit_sum = 0
    while num > 0:
        digit_sum += num % 10
        num //= 10
    return digit_sum

def solution(max_n: int = 100) -> int:
    
    pre_numerator = 1
    cur_numerator = 2

    for i in range(2, max_n + 1):
        temp = pre_numerator
        e_cont = 2 * i // 3 if i % 3 == 0 else 1
        pre_numerator = cur_numerator
        cur_numerator = e_cont * pre_numerator + temp

    return sum_digits(cur_numerator)

if __name__ == "__main__":
    print(f"{solution() = }")
