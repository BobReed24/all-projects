class Node {
  constructor(element) {
    this.element = element
    this.next = null
    this.prev = null
  }
}

class DoubleLinkedList {
  constructor() {
    this.length = 0
    this.head = null
    this.tail = null
  }

  append(element) {
    const node = new Node(element)

    if (!this.head) {
      this.head = node
      this.tail = node
    } else {
      node.prev = this.tail
      this.tail.next = node
      this.tail = node
    }

    this.length++
  }

  insert(position, element) {
    
    if (position >= 0 && position <= this.length) {
      const node = new Node(element)
      let current = this.head
      let previous = 0
      let index = 0

      if (position === 0) {
        if (!this.head) {
          this.head = node
          this.tail = node
        } else {
          node.next = current
          current.prev = node
          this.head = node
        }
      } else if (position === this.length) {
        current = this.tail
        current.next = node
        node.prev = current
        this.tail = node
      } else {
        while (index++ < position) {
          previous = current
          current = current.next
        }

        node.next = current
        previous.next = node

        current.prev = node
        node.prev = previous
      }

      this.length++
      return true
    } else {
      return false
    }
  }

  removeAt(position) {
    
    if (position > -1 && position < this.length) {
      let current = this.head
      let previous = 0
      let index = 0

      if (position === 0) {
        this.head = current.next

        if (this.length === 1) {
          this.tail = null
        } else {
          this.head.prev = null
        }
      } else if (position === this.length - 1) {
        current = this.tail
        this.tail = current.prev
        this.tail.next = null
      } else {
        while (index++ < position) {
          previous = current
          current = current.next
        }

        previous.next = current.next
        current.next.prev = previous
      }

      this.length--
      return current.element
    } else {
      return null
    }
  }

  indexOf(elm) {
    let current = this.head
    let index = -1

    while (current) {
      if (elm === current.element) {
        return ++index
      }

      index++
      current = current.next
    }

    return -1
  }

  isPresent(elm) {
    return this.indexOf(elm) !== -1
  }

  delete(elm) {
    return this.removeAt(this.indexOf(elm))
  }

  deleteHead() {
    this.removeAt(0)
  }

  deleteTail() {
    this.removeAt(this.length - 1)
  }

  toString() {
    let current = this.head
    let string = ''

    while (current) {
      string += current.element + (current.next ? '\n' : '')
      current = current.next
    }

    return string
  }

  toArray() {
    const arr = []
    let current = this.head

    while (current) {
      arr.push(current.element)
      current = current.next
    }

    return arr
  }

  isEmpty() {
    return this.length === 0
  }

  size() {
    return this.length
  }

  getHead() {
    return this.head
  }

  getTail() {
    return this.tail
  }

  iterator() {
    let currentNode = this.getHead()
    if (currentNode === null) return -1

    const iterate = function* () {
      while (currentNode) {
        yield currentNode.element
        currentNode = currentNode.next
      }
    }
    return iterate()
  }

  log() {
    let currentNode = this.getHead()
    while (currentNode) {
      console.log(currentNode.element)
      currentNode = currentNode.next
    }
  }
}

export { DoubleLinkedList }
