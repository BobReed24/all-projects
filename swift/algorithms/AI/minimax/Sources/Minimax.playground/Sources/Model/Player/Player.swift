public struct Player {
    
    public var type: PlayerType

    public var symbol: PlayerSymbol

    public init(type: PlayerType, symbol: PlayerSymbol) {
        self.type = type
        self.symbol = symbol
    }
}
