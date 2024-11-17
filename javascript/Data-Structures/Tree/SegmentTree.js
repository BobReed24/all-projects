class SegmentTree {
  size
  tree
  constructor(arr) {
    
    this.size = arr.length
    this.tree = new Array(2 * arr.length)
    this.tree.fill(0)

    this.build(arr)
  }

  build(arr) {
    const { size, tree } = this
    
    for (let i = 0; i < size; i++) {
      tree[size + i] = arr[i]
    }

    for (let i = size - 1; i > 0; --i) {
      
      tree[i] = tree[i * 2] + tree[i * 2 + 1]
    }
  }

  update(index, value) {
    const { size, tree } = this

    index += size
    
    tree[index] = value

    for (let i = index; i > 1; i >>= 1) {
      
      tree[i >> 1] = tree[i] + tree[i ^ 1]
    }
  }

  query(left, right) {
    const { size, tree } = this
    
    right++
    let res = 0

    for (left += size, right += size; left < right; left >>= 1, right >>= 1) {
      
      if ((left & 1) > 0) {
        res += tree[left++]
      }

      if ((right & 1) > 0) {
        res += tree[--right]
      }
    }

    return res
  }
}

export { SegmentTree }
