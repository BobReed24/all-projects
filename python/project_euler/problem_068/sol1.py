from itertools import permutations

def solution(gon_side: int = 5) -> int:
    
    if gon_side < 3 or gon_side > 5:
        raise ValueError("gon_side must be in the range [3, 5]")

    small_numbers = list(range(gon_side + 1, 0, -1))
    big_numbers = list(range(gon_side + 2, gon_side * 2 + 1))

    for perm in permutations(small_numbers + big_numbers):
        numbers = generate_gon_ring(gon_side, list(perm))
        if is_magic_gon(numbers):
            return int("".join(str(n) for n in numbers))

    msg = f"Magic {gon_side}-gon ring is impossible"
    raise ValueError(msg)

def generate_gon_ring(gon_side: int, perm: list[int]) -> list[int]:
    
    result = [0] * (gon_side * 3)
    result[0:3] = perm[0:3]
    perm.append(perm[1])

    magic_number = 1 if gon_side < 5 else 2

    for i in range(1, len(perm) // 3 + magic_number):
        result[3 * i] = perm[2 * i + 1]
        result[3 * i + 1] = result[3 * i - 1]
        result[3 * i + 2] = perm[2 * i + 2]

    return result

def is_magic_gon(numbers: list[int]) -> bool:
    
    if len(numbers) % 3 != 0:
        raise ValueError("a gon ring should have a length that is a multiple of 3")

    if min(numbers[::3]) != numbers[0]:
        return False

    total = sum(numbers[:3])

    return all(sum(numbers[i : i + 3]) == total for i in range(3, len(numbers), 3))

if __name__ == "__main__":
    print(solution())
