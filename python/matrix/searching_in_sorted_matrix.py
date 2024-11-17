from __future__ import annotations

def search_in_a_sorted_matrix(mat: list[list[int]], m: int, n: int, key: float) -> None:
    
    i, j = m - 1, 0
    while i >= 0 and j < n:
        if key == mat[i][j]:
            print(f"Key {key} found at row- {i + 1} column- {j + 1}")
            return
        if key < mat[i][j]:
            i -= 1
        else:
            j += 1
    print(f"Key {key} not found")

def main() -> None:
    mat = [[2, 5, 7], [4, 8, 13], [9, 11, 15], [12, 17, 20]]
    x = int(input("Enter the element to be searched:"))
    print(mat)
    search_in_a_sorted_matrix(mat, len(mat), len(mat[0]), x)

if __name__ == "__main__":
    import doctest

    doctest.testmod()
    main()
