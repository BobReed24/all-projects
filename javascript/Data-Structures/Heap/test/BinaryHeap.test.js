import { BinaryHeap, minHeapComparator } from '../BinaryHeap'

describe('BinaryHeap', () => {
  describe('MinHeap', () => {
    let minHeap

    beforeEach(() => {
      
      minHeap = new BinaryHeap(minHeapComparator)
      minHeap.insert(4)
      minHeap.insert(3)
      minHeap.insert(6)
      minHeap.insert(1)
      minHeap.insert(8)
      minHeap.insert(2)
    })

    it('should initialize a heap from an input array', () => {
      
      expect(minHeap.heap).toEqual([1, 3, 2, 4, 8, 6])
    })

    it('should show the top value in the heap', () => {
      
      const minValue = minHeap.peek()
      expect(minValue).toEqual(1)
    })

    it('should remove and return the top value in the heap', () => {
      
      const minValue = minHeap.extractTop()
      expect(minValue).toEqual(1)
      expect(minHeap.heap).toEqual([2, 3, 6, 4, 8])
    })

    it('should handle insertion of duplicate values', () => {
      
      minHeap.insert(2)
      expect(minHeap.heap).toEqual([1, 3, 2, 4, 8, 6, 2])
    })

    it('should handle an empty heap', () => {
      
      const emptyHeap = new BinaryHeap(minHeapComparator)
      expect(emptyHeap.peek()).toBeUndefined()
      expect(emptyHeap.extractTop()).toBeUndefined()
    })

    it('should handle extracting all elements from the heap', () => {
      
      const extractedValues = []
      while (!minHeap.empty()) {
        extractedValues.push(minHeap.extractTop())
      }
      expect(extractedValues).toEqual([1, 2, 3, 4, 6, 8])
    })

    it('should insert elements in ascending order', () => {
      
      const ascendingHeap = new BinaryHeap(minHeapComparator)
      ascendingHeap.insert(4)
      ascendingHeap.insert(3)
      ascendingHeap.insert(2)
      ascendingHeap.insert(1)
      expect(ascendingHeap.extractTop()).toEqual(1)
      expect(ascendingHeap.extractTop()).toEqual(2)
      expect(ascendingHeap.extractTop()).toEqual(3)
      expect(ascendingHeap.extractTop()).toEqual(4)
    })
  })
})
