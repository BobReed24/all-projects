from collections import defaultdict

def solution(max_base: int = 5) -> int:
    
    freqs = defaultdict(list)
    num = 0

    while True:
        digits = get_digits(num)
        freqs[digits].append(num)

        if len(freqs[digits]) == max_base:
            base = freqs[digits][0] ** 3
            return base

        num += 1

def get_digits(num: int) -> str:
    
    return "".join(sorted(str(num**3)))

if __name__ == "__main__":
    print(f"{solution() = }")
