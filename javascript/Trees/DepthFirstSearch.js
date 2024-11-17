function traverseDFS(tree, rootValue) {
  const stack = []
  const res = []
  stack.push(searchDFS(tree, rootValue))
  
  if (!stack[0]) return res
  while (stack.length) {
    const curr = stack.pop()
    res.push(curr.value)
    if (curr.left) {
      stack.push(tree[curr.left])
    }
    if (curr.right) {
      stack.push(tree[curr.right])
    }
  }
  return res.reverse()
}

function searchDFS(tree, value) {
  const stack = []
  stack.push(tree[0])
  while (stack.length !== 0) {
    for (let i = 0; i < stack.length; i++) {
      const node = stack.pop()
      if (node.value === value) {
        return node
      }
      if (node.right) {
        stack.push(tree[node.right])
      }
      if (node.left) {
        stack.push(tree[node.left])
      }
    }
  }
  return null
}

export { searchDFS, traverseDFS }
