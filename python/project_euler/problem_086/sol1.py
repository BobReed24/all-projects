from math import sqrt

def solution(limit: int = 1000000) -> int:
    
    num_cuboids: int = 0
    max_cuboid_size: int = 0
    sum_shortest_sides: int

    while num_cuboids <= limit:
        max_cuboid_size += 1
        for sum_shortest_sides in range(2, 2 * max_cuboid_size + 1):
            if sqrt(sum_shortest_sides**2 + max_cuboid_size**2).is_integer():
                num_cuboids += (
                    min(max_cuboid_size, sum_shortest_sides // 2)
                    - max(1, sum_shortest_sides - max_cuboid_size)
                    + 1
                )

    return max_cuboid_size

if __name__ == "__main__":
    print(f"{solution() = }")
