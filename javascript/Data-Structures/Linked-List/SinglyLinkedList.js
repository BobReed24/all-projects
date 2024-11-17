class Node {
  constructor(data) {
    this.data = data
    this.next = null
  }
}

class LinkedList {
  constructor(listOfValues) {
    this.headNode = null
    this.tailNode = null
    this.length = 0

    if (listOfValues instanceof Array) {
      for (const value of listOfValues) {
        this.addLast(value)
      }
    }
  }

  initiateNodeAndIndex() {
    return { currentNode: this.headNode, currentIndex: 0 }
  }

  size() {
    return this.length
  }

  head() {
    return this.headNode?.data ?? null
  }

  tail() {
    return this.tailNode?.data ?? null
  }

  isEmpty() {
    return this.length === 0
  }

  addLast(element) {
    
    if (this.headNode === null) {
      return this.addFirst(element)
    }
    const node = new Node(element)
    
    this.tailNode.next = node
    this.tailNode = node
    this.length++
    return this.size()
  }

  addFirst(element) {
    const node = new Node(element)
    
    if (this.headNode === null) {
      this.tailNode = node
    }
    
    node.next = this.headNode
    this.headNode = node
    this.length++
    return this.size()
  }

  removeFirst() {
    
    if (this.headNode === null) {
      return null
    }
    
    const removedNode = this.headNode
    this.headNode = this.headNode.next
    this.length--
    
    if (this.isEmpty()) {
      this.tailNode = null
    }
    return removedNode?.data
  }

  removeLast() {
    if (this.isEmpty()) return null
    
    if (this.length === 1) {
      return this.removeFirst()
    }
    
    const removedNode = this.tailNode
    let { currentNode } = this.initiateNodeAndIndex()
    while (currentNode.next.next) {
      currentNode = currentNode.next
    }
    currentNode.next = null
    this.tailNode = currentNode
    this.length--
    return removedNode.data
  }

  remove(element) {
    if (this.isEmpty()) return null
    let { currentNode } = this.initiateNodeAndIndex()
    let removedNode = null
    
    if (currentNode.data === element) {
      return this.removeFirst()
    }
    
    if (this.tailNode.data === element) {
      return this.removeLast()
    }
    
    while (currentNode.next) {
      if (currentNode.next.data === element) {
        removedNode = currentNode.next
        currentNode.next = currentNode.next.next
        this.length--
        return removedNode.data
      }
      currentNode = currentNode.next
    }
    return removedNode?.data || null
  }

  indexOf(element) {
    if (this.isEmpty()) return -1
    let { currentNode, currentIndex } = this.initiateNodeAndIndex()
    while (currentNode) {
      if (currentNode.data === element) {
        return currentIndex
      }
      currentNode = currentNode.next
      currentIndex++
    }
    return -1
  }

  elementAt(index) {
    if (index >= this.length || index < 0) {
      throw new RangeError('Out of Range index')
    }
    let { currentIndex, currentNode } = this.initiateNodeAndIndex()
    while (currentIndex < index) {
      currentIndex++
      currentNode = currentNode.next
    }
    return currentNode.data
  }

  addAt(index, element) {
    
    if (index > this.length || index < 0) {
      throw new RangeError('Out of Range index')
    }
    if (index === 0) return this.addFirst(element)
    if (index === this.length) return this.addLast(element)
    let { currentIndex, currentNode } = this.initiateNodeAndIndex()
    const node = new Node(element)

    while (currentIndex !== index - 1) {
      currentIndex++
      currentNode = currentNode.next
    }

    const tempNode = currentNode.next
    currentNode.next = node
    node.next = tempNode
    
    this.length++
    return this.size()
  }

  removeAt(index) {
    
    if (index < 0 || index >= this.length) {
      throw new RangeError('Out of Range index')
    }
    if (index === 0) return this.removeFirst()
    if (index === this.length - 1) return this.removeLast()

    let { currentIndex, currentNode } = this.initiateNodeAndIndex()
    while (currentIndex !== index - 1) {
      currentIndex++
      currentNode = currentNode.next
    }
    const removedNode = currentNode.next
    currentNode.next = currentNode.next.next
    this.length--
    return removedNode.data
  }

  findMiddle() {
    
    let fast = this.headNode
    let slow = this.headNode

    while (fast !== null && fast.next !== null) {
      fast = fast.next.next
      slow = slow.next
    }
    return slow
  }

  clean() {
    this.headNode = null
    this.tailNode = null
    this.length = 0
  }

  get() {
    const list = []
    let { currentNode } = this.initiateNodeAndIndex()
    while (currentNode) {
      list.push(currentNode.data)
      currentNode = currentNode.next
    }
    return list
  }

  rotateListRight(k) {
    if (!this.headNode) return
    let current = this.headNode
    let tail = this.tailNode
    let count = 1
    while (current.next) {
      count++
      current = current.next
    }
    current.next = this.headNode
    tail = current
    k %= count
    while (count - k > 0) {
      tail = tail.next
      count--
    }
    this.headNode = tail.next
    tail.next = null
  }

  iterator() {
    let { currentNode } = this.initiateNodeAndIndex()
    if (currentNode === null) return -1

    const iterate = function* () {
      while (currentNode) {
        yield currentNode.data
        currentNode = currentNode.next
      }
    }
    return iterate()
  }

  log() {
    console.log(JSON.stringify(this.headNode, null, 2))
  }

  reverse() {
    let head = this.headNode
    let prev = null
    let next = null
    while (head) {
      next = head.next
      head.next = prev
      prev = head
      head = next
    }
    this.tailNode = this.headNode
    this.headNode = prev
  }
}

export { Node, LinkedList }
