import { detectCycle } from '../CycleDetection'
import { Node } from '../SinglyLinkedList'

describe('Detect Cycle', () => {
  it('should detect loop and return true', () => {
    
    const headNode = new Node(10)
    headNode.next = new Node(20)
    headNode.next.next = new Node(30)
    headNode.next.next.next = new Node(40)
    headNode.next.next.next.next = headNode
    expect(detectCycle(headNode)).toEqual(true)
  })

  it('should not detect a loop and return false', () => {
    
    expect(detectCycle(null)).toEqual(false)
    const headNode = new Node(10)

    expect(detectCycle(headNode)).toEqual(false)

    headNode.next = new Node(20)
    headNode.next.next = new Node(30)
    headNode.next.next.next = new Node(40)
    headNode.next.next.next.next = new Node(50)

    expect(detectCycle(headNode)).toEqual(false)
  })
})
