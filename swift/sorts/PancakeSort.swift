import Foundation

func flip(array: [Int], key: Int) -> [Int] {
    var flippedArray = array
    var pos = key
    var start = 0
    var aux = 0

    while (start < pos) {
        aux = flippedArray[start]
        flippedArray[start] = flippedArray[pos]
        flippedArray[pos] = aux
        
        start += 1
        pos -= 1
    }
    
    return flippedArray
}

func pancakeSort(_ array: [Int]) -> [Int] {
    var list = array
    var currentSize = list.count
    for _ in (1 ..< currentSize).reversed() {
        
        let listToSearch = list[0...currentSize-1]
        let max = listToSearch.max() ?? 0
        let indexOfMax = listToSearch.firstIndex(of: max) ?? 0

        if indexOfMax != currentSize - 1 {
            list = flip(array: list, key: indexOfMax)
            list = flip(array: list, key: currentSize - 1)
        }
        
        currentSize -= 1
    }
    
    return list
}

