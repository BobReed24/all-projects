def solution() -> int:
    
    return next(
        iter(
            [
                a * b * (1000 - a - b)
                for a in range(1, 999)
                for b in range(a, 999)
                if (a * a + b * b == (1000 - a - b) ** 2)
            ]
        )
    )

if __name__ == "__main__":
    print(f"{solution() = }")
