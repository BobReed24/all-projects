class Queue {
  constructor() {
    this.inputStack = []
    this.outputStack = []
  }

  enqueue(item) {
    this.inputStack.push(item)
  }

  dequeue() {
    
    this.outputStack = []
    while (this.inputStack.length > 0) {
      this.outputStack.push(this.inputStack.pop())
    }
    
    if (this.outputStack.length > 0) {
      const top = this.outputStack.pop()
      
      this.inputStack = []
      while (this.outputStack.length > 0) {
        this.inputStack.push(this.outputStack.pop())
      }
      return top
    }
  }
}

export { Queue }
