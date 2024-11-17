import Foundation

public func convertBinaryToDecimal(binary: String) -> Int? {
    if let _ = Int(binary) {
        var decimal = 0

        let digits = binary.map { Int(String($0))! }.reversed()
        print(digits)
        var power = 1

        for digit in digits {
            decimal += digit * power

            power *= 2
        }

        return decimal
    }

    return nil
}