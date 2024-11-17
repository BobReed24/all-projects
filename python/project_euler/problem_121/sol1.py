from itertools import product

def solution(num_turns: int = 15) -> int:
    
    total_prob: float = 0.0
    prob: float
    num_blue: int
    num_red: int
    ind: int
    col: int
    series: tuple[int, ...]

    for series in product(range(2), repeat=num_turns):
        num_blue = series.count(1)
        num_red = num_turns - num_blue
        if num_red >= num_blue:
            continue
        prob = 1.0
        for ind, col in enumerate(series, 2):
            if col == 0:
                prob *= (ind - 1) / ind
            else:
                prob *= 1 / ind

        total_prob += prob

    return int(1 / total_prob)

if __name__ == "__main__":
    print(f"{solution() = }")
