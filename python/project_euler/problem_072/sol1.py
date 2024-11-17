import numpy as np

def solution(limit: int = 1_000_000) -> int:
    
    phi = np.arange(-1, limit)

    for i in range(2, limit + 1):
        if phi[i] == i - 1:
            ind = np.arange(2 * i, limit + 1, i)  
            phi[ind] -= phi[ind] // i

    return int(np.sum(phi[2 : limit + 1]))

if __name__ == "__main__":
    print(solution())
