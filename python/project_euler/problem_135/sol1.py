def solution(limit: int = 1000000) -> int:
    
    limit = limit + 1
    frequency = [0] * limit
    for first_term in range(1, limit):
        for n in range(first_term, limit, first_term):
            common_difference = first_term + n / first_term
            if common_difference % 4:  
                continue
            else:
                common_difference /= 4
                if (
                    first_term > common_difference
                    and first_term < 4 * common_difference
                ):  
                    frequency[n] += 1  

    count = sum(1 for x in frequency[1:limit] if x == 10)

    return count

if __name__ == "__main__":
    print(f"{solution() = }")
