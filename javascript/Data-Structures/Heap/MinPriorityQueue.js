class MinPriorityQueue {
  
  constructor(c) {
    this.heap = []
    this.capacity = c
    this.size = 0
  }

  insert(key) {
    if (this.isFull()) return
    this.heap[this.size + 1] = key
    let k = this.size + 1
    while (k > 1) {
      if (this.heap[k] < this.heap[Math.floor(k / 2)]) {
        const temp = this.heap[k]
        this.heap[k] = this.heap[Math.floor(k / 2)]
        this.heap[Math.floor(k / 2)] = temp
      }
      k = Math.floor(k / 2)
    }
    this.size++
  }

  peek() {
    return this.heap[1]
  }

  isEmpty() {
    return this.size === 0
  }

  isFull() {
    return this.size === this.capacity
  }

  print(output = (value) => console.log(value)) {
    output(this.heap.slice(1))
  }

  heapReverse() {
    const heapSort = []
    while (this.size > 0) {
      
      ;[this.heap[1], this.heap[this.size]] = [
        this.heap[this.size],
        this.heap[1]
      ]
      heapSort.push(this.heap.pop())
      this.size--
      this.sink()
    }
    
    this.heap = [undefined, ...heapSort.reverse()]
    this.size = heapSort.length
  }

  sink() {
    let k = 1
    while (2 * k <= this.size || 2 * k + 1 <= this.size) {
      let minIndex
      if (this.heap[2 * k] >= this.heap[k]) {
        if (2 * k + 1 <= this.size && this.heap[2 * k + 1] >= this.heap[k]) {
          break
        } else if (2 * k + 1 > this.size) {
          break
        }
      }
      if (2 * k + 1 > this.size) {
        minIndex = this.heap[2 * k] < this.heap[k] ? 2 * k : k
      } else {
        if (
          this.heap[k] > this.heap[2 * k] ||
          this.heap[k] > this.heap[2 * k + 1]
        ) {
          minIndex = this.heap[2 * k] < this.heap[2 * k + 1] ? 2 * k : 2 * k + 1
        } else {
          minIndex = k
        }
      }
      const temp = this.heap[k]
      this.heap[k] = this.heap[minIndex]
      this.heap[minIndex] = temp
      k = minIndex
    }
  }

  delete() {
    
    if (this.isEmpty()) return
    if (this.size === 1) {
      this.size--
      return this.heap.pop()
    }
    const min = this.heap[1]
    this.heap[1] = this.heap.pop()
    this.size--
    this.sink()
    return min
  }
}

export { MinPriorityQueue }
