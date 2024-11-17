class CircularQueue {
  constructor(maxLength) {
    this.queue = []
    this.front = 0
    this.rear = 0
    this.maxLength = maxLength
  }

  enqueue(value) {
    if (this.checkOverflow()) return
    if (this.checkEmpty()) {
      this.front += 1
      this.rear += 1
    } else {
      if (this.rear === this.maxLength) {
        this.rear = 1
      } else this.rear += 1
    }
    this.queue[this.rear] = value
  }

  dequeue() {
    if (this.checkEmpty()) {
      
      return
    }
    const y = this.queue[this.front]
    this.queue[this.front] = '*'
    if (!this.checkSingleelement()) {
      if (this.front === this.maxLength) this.front = 1
      else {
        this.front += 1
      }
    }

    return y 
  }

  checkEmpty() {
    if (this.front === 0 && this.rear === 0) {
      return true
    }
  }

  checkSingleelement() {
    if (this.front === this.rear && this.rear !== 0) {
      this.front = this.rear = 0
      return true
    }
  }

  checkOverflow() {
    if (
      (this.front === 1 && this.rear === this.maxLength) ||
      this.front === this.rear + 1
    ) {
      
      return true
    }
  }

  display(output = (value) => console.log(value)) {
    for (let index = 1; index < this.queue.length; index++) {
      output(this.queue[index])
    }
  }

  length() {
    return this.checkEmpty() ? 0 : this.queue.length - 1
  }

  peek() {
    return this.queue[this.front]
  }
}

export { CircularQueue }
