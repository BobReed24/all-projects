import itertools
from pathlib import Path

def find_secret_passcode(logins: list[str]) -> int:
    
    split_logins = [tuple(login) for login in logins]

    unique_chars = {char for login in split_logins for char in login}

    for permutation in itertools.permutations(unique_chars):
        satisfied = True
        for login in logins:
            if not (
                permutation.index(login[0])
                < permutation.index(login[1])
                < permutation.index(login[2])
            ):
                satisfied = False
                break

        if satisfied:
            return int("".join(permutation))

    raise Exception("Unable to find the secret passcode")

def solution(input_file: str = "keylog.txt") -> int:
    
    logins = Path(__file__).parent.joinpath(input_file).read_text().splitlines()

    return find_secret_passcode(logins)

if __name__ == "__main__":
    print(f"{solution() = }")
