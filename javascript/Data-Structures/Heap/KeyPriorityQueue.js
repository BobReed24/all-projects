const getParentPosition = (position) => Math.floor((position - 1) / 2)
const getChildrenPositions = (position) => [2 * position + 1, 2 * position + 2]

class KeyPriorityQueue {
  
  constructor() {
    this._heap = []
    this.priorities = new Map()
  }

  isEmpty() {
    return this._heap.length === 0
  }

  push(key, priority) {
    this._heap.push(key)
    this.priorities.set(key, priority)
    this._shiftUp(this._heap.length - 1)
  }

  pop() {
    this._swap(0, this._heap.length - 1)
    const key = this._heap.pop()
    this.priorities.delete(key)
    this._shiftDown(0)
    return key
  }

  contains(key) {
    return this.priorities.has(key)
  }

  update(key, priority) {
    const currPos = this._heap.indexOf(key)
    
    if (currPos === -1) return this.push(key, priority)
    
    this.priorities.set(key, priority)
    const parentPos = getParentPosition(currPos)
    const currPriority = this._getPriorityOrInfinite(currPos)
    const parentPriority = this._getPriorityOrInfinite(parentPos)
    const [child1Pos, child2Pos] = getChildrenPositions(currPos)
    const child1Priority = this._getPriorityOrInfinite(child1Pos)
    const child2Priority = this._getPriorityOrInfinite(child2Pos)

    if (parentPos >= 0 && parentPriority > currPriority) {
      this._shiftUp(currPos)
    } else if (child1Priority < currPriority || child2Priority < currPriority) {
      this._shiftDown(currPos)
    }
  }

  _getPriorityOrInfinite(position) {
    
    if (position >= 0 && position < this._heap.length)
      return this.priorities.get(this._heap[position])
    else return Infinity
  }

  _shiftUp(position) {
    
    let currPos = position
    let parentPos = getParentPosition(currPos)
    let currPriority = this._getPriorityOrInfinite(currPos)
    let parentPriority = this._getPriorityOrInfinite(parentPos)

    while (parentPos >= 0 && parentPriority > currPriority) {
      this._swap(currPos, parentPos)
      currPos = parentPos
      parentPos = getParentPosition(currPos)
      currPriority = this._getPriorityOrInfinite(currPos)
      parentPriority = this._getPriorityOrInfinite(parentPos)
    }
  }

  _shiftDown(position) {
    
    let currPos = position
    let [child1Pos, child2Pos] = getChildrenPositions(currPos)
    let child1Priority = this._getPriorityOrInfinite(child1Pos)
    let child2Priority = this._getPriorityOrInfinite(child2Pos)
    let currPriority = this._getPriorityOrInfinite(currPos)

    if (currPriority === Infinity) {
      return
    }

    while (child1Priority < currPriority || child2Priority < currPriority) {
      if (child1Priority < currPriority && child1Priority < child2Priority) {
        this._swap(child1Pos, currPos)
        currPos = child1Pos
      } else {
        this._swap(child2Pos, currPos)
        currPos = child2Pos
      }
      ;[child1Pos, child2Pos] = getChildrenPositions(currPos)
      child1Priority = this._getPriorityOrInfinite(child1Pos)
      child2Priority = this._getPriorityOrInfinite(child2Pos)
      currPriority = this._getPriorityOrInfinite(currPos)
    }
  }

  _swap(position1, position2) {
    
    ;[this._heap[position1], this._heap[position2]] = [
      this._heap[position2],
      this._heap[position1]
    ]
  }
}

export { KeyPriorityQueue }
