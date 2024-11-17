const Node = (function Node() {
  
  class Node {
    constructor(val) {
      this.value = val
      this.left = null
      this.right = null
    }

    search(val) {
      if (this.value === val) {
        return this
      } else if (val < this.value && this.left !== null) {
        return this.left.search(val)
      } else if (val > this.value && this.right !== null) {
        return this.right.search(val)
      }
      return null
    }

    visit(output = (value) => console.log(value)) {
      
      if (this.left !== null) {
        this.left.visit()
      }
      
      output(this.value)
      
      if (this.right !== null) {
        this.right.visit()
      }
    }

    addNode(n) {
      if (n.value < this.value) {
        if (this.left === null) {
          this.left = n
        } else {
          this.left.addNode(n)
        }
      } else if (n.value > this.value) {
        if (this.right === null) {
          this.right = n
        } else {
          this.right.addNode(n)
        }
      }
    }

    removeNode(val) {
      if (val === this.value) {
        if (!this.left && !this.right) {
          return null
        } else {
          if (this.left) {
            const leftMax = maxVal(this.left)
            this.value = leftMax
            this.left = this.left.removeNode(leftMax)
          } else {
            const rightMin = minVal(this.right)
            this.value = rightMin
            this.right = this.right.removeNode(rightMin)
          }
        }
      } else if (val < this.value) {
        this.left = this.left && this.left.removeNode(val)
      } else if (val > this.value) {
        this.right = this.right && this.right.removeNode(val)
      }
      return this
    }
  }

  const maxVal = function (node) {
    if (!node.right) {
      return node.value
    }
    return maxVal(node.right)
  }

  const minVal = function (node) {
    if (!node.left) {
      return node.value
    }
    return minVal(node.left)
  }
  
  return Node
})()

const Tree = (function () {
  class Tree {
    constructor() {
      
      this.root = null
    }

    traverse() {
      if (!this.root) {
        
        return
      }
      this.root.visit()
    }

    search(val) {
      const found = this.root.search(val)
      if (found !== null) {
        return found.value
      }
      
      return null
    }

    addValue(val) {
      const n = new Node(val)
      if (this.root === null) {
        this.root = n
      } else {
        this.root.addNode(n)
      }
    }

    removeValue(val) {
      
      this.root = this.root && this.root.removeNode(val)
    }
  }

  return Tree
})()

export { Tree }
