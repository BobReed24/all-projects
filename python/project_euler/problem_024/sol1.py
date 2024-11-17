from itertools import permutations

def solution():
    
    result = list(map("".join, permutations("0123456789")))
    return result[999999]

if __name__ == "__main__":
    print(solution())
