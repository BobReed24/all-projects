from math import factorial

DIGIT_FACTORIAL: dict[str, int] = {str(digit): factorial(digit) for digit in range(10)}

def digit_factorial_sum(number: int) -> int:
    
    if not isinstance(number, int):
        raise TypeError("Parameter number must be int")

    if number < 0:
        raise ValueError("Parameter number must be greater than or equal to 0")

    return sum(DIGIT_FACTORIAL[digit] for digit in str(number))

def solution(chain_length: int = 60, number_limit: int = 1000000) -> int:
    
    if not isinstance(chain_length, int) or not isinstance(number_limit, int):
        raise TypeError("Parameters chain_length and number_limit must be int")

    if chain_length <= 0 or number_limit <= 0:
        raise ValueError(
            "Parameters chain_length and number_limit must be greater than 0"
        )

    chains_counter = 0
    
    chain_sets_lengths: dict[int, int] = {}

    for start_chain_element in range(1, number_limit):
        
        chain_set = set()
        chain_set_length = 0

        chain_element = start_chain_element
        while (
            chain_element not in chain_sets_lengths
            and chain_element not in chain_set
            and chain_set_length <= chain_length
        ):
            chain_set.add(chain_element)
            chain_set_length += 1
            chain_element = digit_factorial_sum(chain_element)

        if chain_element in chain_sets_lengths:
            chain_set_length += chain_sets_lengths[chain_element]

        chain_sets_lengths[start_chain_element] = chain_set_length

        if chain_set_length == chain_length:
            chains_counter += 1

    return chains_counter

if __name__ == "__main__":
    import doctest

    doctest.testmod()
    print(f"{solution()}")
