extension String {
    
    func isPalindrome() -> Bool {
        let input = lowercased().filter { $0.isLetter || $0.isNumber }
        return input == String(input.reversed())
    }
}
