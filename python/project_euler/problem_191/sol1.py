cache: dict[tuple[int, int, int], int] = {}

def _calculate(days: int, absent: int, late: int) -> int:
    
    if late == 3 or absent == 2:
        return 0

    if days == 0:
        return 1

    key = (days, absent, late)
    if key in cache:
        return cache[key]

    state_late = _calculate(days - 1, absent, late + 1)

    state_absent = _calculate(days - 1, absent + 1, 0)

    state_ontime = _calculate(days - 1, absent, 0)

    prizestrings = state_late + state_absent + state_ontime

    cache[key] = prizestrings
    return prizestrings

def solution(days: int = 30) -> int:
    
    return _calculate(days, absent=0, late=0)

if __name__ == "__main__":
    print(solution())
