from itertools import count
from math import asin, pi, sqrt

def circle_bottom_arc_integral(point: float) -> float:
    
    return (
        (1 - 2 * point) * sqrt(point - point**2) + 2 * point + asin(sqrt(1 - point))
    ) / 4

def concave_triangle_area(circles_number: int) -> float:
    
    intersection_y = (circles_number + 1 - sqrt(2 * circles_number)) / (
        2 * (circles_number**2 + 1)
    )
    intersection_x = circles_number * intersection_y

    triangle_area = intersection_x * intersection_y / 2
    concave_region_area = circle_bottom_arc_integral(
        1 / 2
    ) - circle_bottom_arc_integral(intersection_x)

    return triangle_area + concave_region_area

def solution(fraction: float = 1 / 1000) -> int:
    
    l_section_area = (1 - pi / 4) / 4

    for n in count(1):
        if concave_triangle_area(n) / l_section_area < fraction:
            return n

    return -1

if __name__ == "__main__":
    print(f"{solution() = }")
