def solution(n: int = 1000) -> int:
    
    xmulti = []
    zmulti = []
    z = 3
    x = 5
    temp = 1
    while True:
        result = z * temp
        if result < n:
            zmulti.append(result)
            temp += 1
        else:
            temp = 1
            break
    while True:
        result = x * temp
        if result < n:
            xmulti.append(result)
            temp += 1
        else:
            break
    collection = list(set(xmulti + zmulti))
    return sum(collection)

if __name__ == "__main__":
    print(f"{solution() = }")
