'use strict'

let utils
;(function (_utils) {
  function comparator() {
    return function (v1, v2) {
      if (v1 < v2) return -1
      if (v2 < v1) return 1
      return 0
    }
  }
  _utils.comparator = comparator
})(utils || (utils = {}))

class AVLTree {
  constructor(comp) {
    
    this._comp = undefined
    this._comp = comp !== undefined ? comp : utils.comparator()

    this.root = null
    
    this.size = 0
  }

  add(_val) {
    const prevSize = this.size
    this.root = insert(this.root, _val, this)
    return this.size !== prevSize
  }

  find(_val) {
    const temp = searchAVLTree(this.root, _val, this)
    return temp != null
  }

  remove(_val) {
    const prevSize = this.size
    this.root = deleteElement(this.root, _val, this)
    return prevSize !== this.size
  }
}

class Node {
  constructor(val) {
    this._val = val
    this._left = null
    this._right = null
    this._height = 1
  }
}

const getHeight = function (node) {
  if (node == null) {
    return 0
  }
  return node._height
}

const getHeightDifference = function (node) {
  return node == null ? 0 : getHeight(node._left) - getHeight(node._right)
}

const updateHeight = function (node) {
  if (node == null) {
    return
  }
  node._height = Math.max(getHeight(node._left), getHeight(node._right)) + 1
}

const isValidBalanceFactor = (balanceFactor) =>
  [0, 1, -1].includes(balanceFactor)

const leftRotate = function (node) {
  const temp = node._right
  node._right = temp._left
  temp._left = node
  updateHeight(node)
  updateHeight(temp)
  return temp
}
const rightRotate = function (node) {
  const temp = node._left
  node._left = temp._right
  temp._right = node
  updateHeight(node)
  updateHeight(temp)
  return temp
}

const insertBalance = function (node, _val, balanceFactor, tree) {
  if (balanceFactor > 1 && tree._comp(_val, node._left._val) < 0) {
    return rightRotate(node) 
  }
  if (balanceFactor < 1 && tree._comp(_val, node._right._val) > 0) {
    return leftRotate(node) 
  }
  if (balanceFactor > 1 && tree._comp(_val, node._left._val) > 0) {
    node._left = leftRotate(node._left) 
    return rightRotate(node)
  }
  node._right = rightRotate(node._right)
  return leftRotate(node)
}

const delBalance = function (node) {
  const balanceFactor1 = getHeightDifference(node)
  if (isValidBalanceFactor(balanceFactor1)) {
    return node
  }
  if (balanceFactor1 > 1) {
    if (getHeightDifference(node._left) >= 0) {
      return rightRotate(node) 
    }
    node._left = leftRotate(node._left)
    return rightRotate(node) 
  }
  if (getHeightDifference(node._right) > 0) {
    node._right = rightRotate(node._right)
    return leftRotate(node) 
  }
  return leftRotate(node) 
}

const insert = function (root, val, tree) {
  if (root == null) {
    tree.size++
    return new Node(val)
  }
  if (tree._comp(root._val, val) < 0) {
    root._right = insert(root._right, val, tree)
  } else if (tree._comp(root._val, val) > 0) {
    root._left = insert(root._left, val, tree)
  } else {
    return root
  }
  updateHeight(root)
  const balanceFactor = getHeightDifference(root)
  return isValidBalanceFactor(balanceFactor)
    ? root
    : insertBalance(root, val, balanceFactor, tree)
}

const deleteElement = function (root, _val, tree) {
  if (root == null) {
    return root
  }
  if (tree._comp(root._val, _val) === 0) {
    
    if (root._left === null && root._right === null) {
      root = null
      tree.size--
    } else if (root._left === null) {
      root = root._right
      tree.size--
    } else if (root._right === null) {
      root = root._left
      tree.size--
    } else {
      let temp = root._right
      while (temp._left != null) {
        temp = temp._left
      }
      root._val = temp._val
      root._right = deleteElement(root._right, temp._val, tree)
    }
  } else {
    if (tree._comp(root._val, _val) < 0) {
      root._right = deleteElement(root._right, _val, tree)
    } else {
      root._left = deleteElement(root._left, _val, tree)
    }
  }
  updateHeight(root)
  root = delBalance(root)
  return root
}

const searchAVLTree = function (root, val, tree) {
  if (root == null) {
    return null
  }
  if (tree._comp(root._val, val) === 0) {
    return root
  }
  if (tree._comp(root._val, val) < 0) {
    return searchAVLTree(root._right, val, tree)
  }
  return searchAVLTree(root._left, val, tree)
}

export { AVLTree }
