import math

def check_partition_perfect(positive_integer: int) -> bool:
    
    exponent = math.log2(math.sqrt(4 * positive_integer + 1) / 2 + 1 / 2)

    return exponent == int(exponent)

def solution(max_proportion: float = 1 / 12345) -> int:
    
    total_partitions = 0
    perfect_partitions = 0

    integer = 3
    while True:
        partition_candidate = (integer**2 - 1) / 4
        
        if partition_candidate == int(partition_candidate):
            partition_candidate = int(partition_candidate)
            total_partitions += 1
            if check_partition_perfect(partition_candidate):
                perfect_partitions += 1
        if (
            perfect_partitions > 0
            and perfect_partitions / total_partitions < max_proportion
        ):
            return int(partition_candidate)
        integer += 1

if __name__ == "__main__":
    print(f"{solution() = }")
