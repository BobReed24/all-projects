from collections import defaultdict
from math import ceil, sqrt

def solution(t_limit: int = 1000000, n_limit: int = 10) -> int:
    
    count: defaultdict = defaultdict(int)

    for outer_width in range(3, (t_limit // 4) + 2):
        if outer_width * outer_width > t_limit:
            hole_width_lower_bound = max(
                ceil(sqrt(outer_width * outer_width - t_limit)), 1
            )
        else:
            hole_width_lower_bound = 1

        hole_width_lower_bound += (outer_width - hole_width_lower_bound) % 2

        for hole_width in range(hole_width_lower_bound, outer_width - 1, 2):
            count[outer_width * outer_width - hole_width * hole_width] += 1

    return sum(1 for n in count.values() if 1 <= n <= n_limit)

if __name__ == "__main__":
    print(f"{solution() = }")
