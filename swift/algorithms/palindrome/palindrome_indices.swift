extension String {
    
    func isPalindrome() -> Bool {
        var leftIndex = startIndex
        var rightIndex = index(before: endIndex)
        
        while leftIndex < rightIndex {
            guard self[leftIndex].isLetter || self[leftIndex].isNumber else {
                leftIndex = index(after: leftIndex)
                continue
            }
            guard self[rightIndex].isLetter || self[rightIndex].isNumber else {
                rightIndex = index(before: rightIndex)
                continue
            }
            guard self[leftIndex].lowercased() == self[rightIndex].lowercased() else {
                return false
            }
            
            leftIndex = index(after: leftIndex)
            rightIndex = index(before: rightIndex)
        }
        
        return true
    }
}
