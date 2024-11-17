import math

BALLS_PER_COLOUR = 10
NUM_COLOURS = 7
NUM_BALLS = BALLS_PER_COLOUR * NUM_COLOURS

def solution(num_picks: int = 20) -> str:
    
    total = math.comb(NUM_BALLS, num_picks)
    missing_colour = math.comb(NUM_BALLS - BALLS_PER_COLOUR, num_picks)

    result = NUM_COLOURS * (1 - missing_colour / total)

    return f"{result:.9f}"

if __name__ == "__main__":
    print(solution(20))
