import itertools

def solution(number: int = 1000000) -> int:
    
    partitions = [1]

    for i in itertools.count(len(partitions)):
        item = 0
        for j in itertools.count(1):
            sign = -1 if j % 2 == 0 else +1
            index = (j * j * 3 - j) // 2
            if index > i:
                break
            item += partitions[i - index] * sign
            item %= number
            index += j
            if index > i:
                break
            item += partitions[i - index] * sign
            item %= number

        if item == 0:
            return i
        partitions.append(item)

    return 0

if __name__ == "__main__":
    import doctest

    doctest.testmod()

    print(f"{solution() = }")
