import os

def solution():
    
    total_sum = 0
    temp_sum = 0
    with open(os.path.dirname(__file__) + "/p022_names.txt") as file:
        name = str(file.readlines()[0])
        name = name.replace('"', "").split(",")

    name.sort()
    for i in range(len(name)):
        for j in name[i]:
            temp_sum += ord(j) - ord("A") + 1
        total_sum += (i + 1) * temp_sum
        temp_sum = 0
    return total_sum

if __name__ == "__main__":
    print(solution())
