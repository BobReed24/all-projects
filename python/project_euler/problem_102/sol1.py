from __future__ import annotations

from pathlib import Path

def vector_product(point1: tuple[int, int], point2: tuple[int, int]) -> int:
    
    return point1[0] * point2[1] - point1[1] * point2[0]

def contains_origin(x1: int, y1: int, x2: int, y2: int, x3: int, y3: int) -> bool:
    
    point_a: tuple[int, int] = (x1, y1)
    point_a_to_b: tuple[int, int] = (x2 - x1, y2 - y1)
    point_a_to_c: tuple[int, int] = (x3 - x1, y3 - y1)
    a: float = -vector_product(point_a, point_a_to_b) / vector_product(
        point_a_to_c, point_a_to_b
    )
    b: float = +vector_product(point_a, point_a_to_c) / vector_product(
        point_a_to_c, point_a_to_b
    )

    return a > 0 and b > 0 and a + b < 1

def solution(filename: str = "p102_triangles.txt") -> int:
    
    data: str = Path(__file__).parent.joinpath(filename).read_text(encoding="utf-8")

    triangles: list[list[int]] = []
    for line in data.strip().split("\n"):
        triangles.append([int(number) for number in line.split(",")])

    ret: int = 0
    triangle: list[int]

    for triangle in triangles:
        ret += contains_origin(*triangle)

    return ret

if __name__ == "__main__":
    print(f"{solution() = }")
