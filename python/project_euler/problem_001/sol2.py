def solution(n: int = 1000) -> int:
    
    total = 0
    terms = (n - 1) // 3
    total += ((terms) * (6 + (terms - 1) * 3)) // 2  
    terms = (n - 1) // 5
    total += ((terms) * (10 + (terms - 1) * 5)) // 2
    terms = (n - 1) // 15
    total -= ((terms) * (30 + (terms - 1) * 15)) // 2
    return total

if __name__ == "__main__":
    print(f"{solution() = }")
