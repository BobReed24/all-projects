class Queue {
  #size

  constructor() {
    this.head = null
    this.tail = null
    this.#size = 0

    return Object.seal(this)
  }

  get length() {
    return this.#size
  }

  enqueue(data) {
    const node = { data, next: null }

    if (!this.head && !this.tail) {
      this.head = node
      this.tail = node
    } else {
      this.tail.next = node
      this.tail = node
    }

    return ++this.#size
  }

  dequeue() {
    if (this.isEmpty()) {
      throw new Error('Queue is Empty')
    }

    const firstData = this.peekFirst()

    this.head = this.head.next

    if (!this.head) {
      this.tail = null
    }

    this.#size--

    return firstData
  }

  peekFirst() {
    if (this.isEmpty()) {
      throw new Error('Queue is Empty')
    }

    return this.head.data
  }

  peekLast() {
    if (this.isEmpty()) {
      throw new Error('Queue is Empty')
    }

    return this.tail.data
  }

  toArray() {
    const array = []
    let node = this.head

    while (node) {
      array.push(node.data)
      node = node.next
    }

    return array
  }

  isEmpty() {
    return this.length === 0
  }
}

export default Queue
