from math import isclose, sqrt

def next_point(
    point_x: float, point_y: float, incoming_gradient: float
) -> tuple[float, float, float]:
    
    normal_gradient = point_y / 4 / point_x
    s2 = 2 * normal_gradient / (1 + normal_gradient * normal_gradient)
    c2 = (1 - normal_gradient * normal_gradient) / (
        1 + normal_gradient * normal_gradient
    )
    outgoing_gradient = (s2 - c2 * incoming_gradient) / (c2 + s2 * incoming_gradient)

    quadratic_term = outgoing_gradient**2 + 4
    linear_term = 2 * outgoing_gradient * (point_y - outgoing_gradient * point_x)
    constant_term = (point_y - outgoing_gradient * point_x) ** 2 - 100

    x_minus = (
        -linear_term - sqrt(linear_term**2 - 4 * quadratic_term * constant_term)
    ) / (2 * quadratic_term)
    x_plus = (
        -linear_term + sqrt(linear_term**2 - 4 * quadratic_term * constant_term)
    ) / (2 * quadratic_term)

    next_x = x_minus if isclose(x_plus, point_x) else x_plus
    next_y = point_y + outgoing_gradient * (next_x - point_x)

    return next_x, next_y, outgoing_gradient

def solution(first_x_coord: float = 1.4, first_y_coord: float = -9.6) -> int:
    
    num_reflections: int = 0
    point_x: float = first_x_coord
    point_y: float = first_y_coord
    gradient: float = (10.1 - point_y) / (0.0 - point_x)

    while not (-0.01 <= point_x <= 0.01 and point_y > 0):
        point_x, point_y, gradient = next_point(point_x, point_y, gradient)
        num_reflections += 1

    return num_reflections

if __name__ == "__main__":
    print(f"{solution() = }")
