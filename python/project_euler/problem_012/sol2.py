def triangle_number_generator():
    for n in range(1, 1000000):
        yield n * (n + 1) // 2

def count_divisors(n):
    divisors_count = 1
    i = 2
    while i * i <= n:
        multiplicity = 0
        while n % i == 0:
            n //= i
            multiplicity += 1
        divisors_count *= multiplicity + 1
        i += 1
    if n > 1:
        divisors_count *= 2
    return divisors_count

def solution():
    
    return next(i for i in triangle_number_generator() if count_divisors(i) > 500)

if __name__ == "__main__":
    print(solution())
