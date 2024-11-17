struct Heap<Element> {
    let compare: (Element, Element) -> Bool
    private var items : [Element]

    init(_ items : [Element], compare: @escaping (Element, Element) -> Bool) {
        self.compare = compare
        self.items = items
        for index in (0 ..< count / 2).reversed() {
            heapify(index)
        }
    }

    var min: Element? {
        return items.first
    }

    var count: Int {
        return items.count
    }

    var isEmpty: Bool {
        return items.isEmpty
    }

    mutating func extractMin() -> Element? {
        guard let result = items.first else { return nil }

        items.removeFirst()
        heapify(0)
        return result

    }

    mutating func insert(item : Element) {
        items.append(item)
        var i = items.count - 1
        while i > 0 && compare(items[i], items[parent(i)]) {
            items.swapAt(i, parent(i))
            i = parent(i)
        }
    }

    private mutating func heapify(_ index : Int) {
        var minimumIndex = index
        if left(index) < count && compare(items[left(index)], items[minimumIndex]) {
            minimumIndex = left(index)
        }

        if right(index) < count && compare(items[right(index)], items[minimumIndex]) {
            minimumIndex = right(index)
        }

        if minimumIndex != index {
            items.swapAt(minimumIndex, index)
            heapify(minimumIndex)
        }
    }

    private func left(_ index : Int) -> Int {
        return 2 * index + 1
    }

    private func right(_ index: Int) -> Int {
        return 2 * index + 2
    }

    private func parent(_ index: Int) -> Int {
        return (index - 1) / 2
    }
}

extension Heap: ExpressibleByArrayLiteral where Element: Comparable {
    init(arrayLiteral elements: Element...) {
        self.init(elements, compare: <)
    }

    init(_ elements: [Element]) {
        self.init(elements, compare: <)
    }
}
