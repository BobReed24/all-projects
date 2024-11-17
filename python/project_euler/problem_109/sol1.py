from itertools import combinations_with_replacement

def solution(limit: int = 100) -> int:
    
    singles: list[int] = [*list(range(1, 21)), 25]
    doubles: list[int] = [2 * x for x in range(1, 21)] + [50]
    triples: list[int] = [3 * x for x in range(1, 21)]
    all_values: list[int] = singles + doubles + triples + [0]

    num_checkouts: int = 0
    double: int
    throw1: int
    throw2: int
    checkout_total: int

    for double in doubles:
        for throw1, throw2 in combinations_with_replacement(all_values, 2):
            checkout_total = double + throw1 + throw2
            if checkout_total < limit:
                num_checkouts += 1

    return num_checkouts

if __name__ == "__main__":
    print(f"{solution() = }")
