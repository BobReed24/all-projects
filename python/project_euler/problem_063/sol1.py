def solution(max_base: int = 10, max_power: int = 22) -> int:
    
    bases = range(1, max_base)
    powers = range(1, max_power)
    return sum(
        1 for power in powers for base in bases if len(str(base**power)) == power
    )

if __name__ == "__main__":
    print(f"{solution(10, 22) = }")
