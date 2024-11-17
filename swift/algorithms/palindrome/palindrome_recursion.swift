extension String {
    
    func isPalindrome() -> Bool {
        isPalindromeRecursion(
            leftIndex: startIndex,
            rightIndex: index(before: endIndex)
        )
    }
    
    private func isPalindromeRecursion(
        leftIndex: String.Index,
        rightIndex: String.Index
    ) -> Bool {
        guard leftIndex < rightIndex else {
            return true
        }
        guard self[leftIndex].isLetter || self[leftIndex].isNumber else {
            return isPalindromeRecursion(
                leftIndex: index(after: leftIndex),
                rightIndex: rightIndex
            )
        }
        guard self[rightIndex].isLetter || self[rightIndex].isNumber else {
            return isPalindromeRecursion(
                leftIndex: leftIndex,
                rightIndex: index(before: rightIndex)
            )
        }
        guard self[leftIndex].lowercased() == self[rightIndex].lowercased() else {
            return false
        }
        
        return isPalindromeRecursion(
            leftIndex: index(after: leftIndex),
            rightIndex: index(before: rightIndex)
        )
    }
}
