from itertools import combinations, product

def is_right(x1: int, y1: int, x2: int, y2: int) -> bool:
    
    if x1 == y1 == 0 or x2 == y2 == 0:
        return False
    a_square = x1 * x1 + y1 * y1
    b_square = x2 * x2 + y2 * y2
    c_square = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
    return (
        a_square + b_square == c_square
        or a_square + c_square == b_square
        or b_square + c_square == a_square
    )

def solution(limit: int = 50) -> int:
    
    return sum(
        1
        for pt1, pt2 in combinations(product(range(limit + 1), repeat=2), 2)
        if is_right(*pt1, *pt2)
    )

if __name__ == "__main__":
    print(f"{solution() = }")
