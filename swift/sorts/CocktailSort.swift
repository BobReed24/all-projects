import Foundation

func cocktailSort<T: Comparable>(_ a: [T]) -> [T] {
    var list = a
    var swapped = true
    var start = 0
    var end = list.count - 1

    while (swapped) {
        swapped = false

        for i in start..<end {
            if (list[i] > list[i + 1]) {
                list.swapAt(i, i+1)
                swapped = true
            }
        }

        if (!swapped) {
            break
        }
        swapped = false
        end -= 1

        for index in stride(from: end-1, through: start, by: -1) {
            if (list[index] > list[index + 1]) {
                list.swapAt(index, index+1)
                swapped = true
            }
        }
        start += 1
    }
    
    return list
}

