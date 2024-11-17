class Stack {
  constructor() {
    
    this.top = 0
    
    this.stack = []
  }

  push(value) {
    this.stack[this.top] = value
    this.top++
  }

  pop() {
    if (this.top === 0) {
      return 'Stack is Empty'
    }

    this.top--
    const result = this.stack[this.top]
    this.stack = this.stack.splice(0, this.top)
    return result
  }

  size() {
    return this.top
  }

  peek() {
    return this.stack[this.top - 1]
  }

  view(output = (value) => console.log(value)) {
    for (let i = 0; i < this.top; i++) {
      output(this.stack[i])
    }
  }
}

export { Stack }
