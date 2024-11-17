class TrieNode {
  constructor(key, parent) {
    this.key = key
    this.count = 0
    this.children = Object.create(null)
    if (parent === undefined) {
      this.parent = null
    } else {
      this.parent = parent
    }
  }
}

class Trie {
  constructor() {
    
    this.root = new TrieNode(null, null)
  }

  static findAllWords(root, word, output) {
    if (root === null) return
    if (root.count > 0) {
      if (typeof output === 'object') {
        output.push({ word, count: root.count })
      }
    }
    let key
    for (key in root.children) {
      word += key
      this.findAllWords(root.children[key], word, output)
      word = word.slice(0, -1)
    }
  }

  insert(word) {
    if (typeof word !== 'string') return
    if (word === '') {
      this.root.count += 1
      return
    }
    let node = this.root
    const len = word.length
    let i
    for (i = 0; i < len; i++) {
      if (node.children[word.charAt(i)] === undefined) {
        node.children[word.charAt(i)] = new TrieNode(word.charAt(i), node)
      }
      node = node.children[word.charAt(i)]
    }
    node.count += 1
  }

  findPrefix(word) {
    if (typeof word !== 'string') return null
    let node = this.root
    const len = word.length
    let i
    
    for (i = 0; i < len; i++) {
      if (node.children[word.charAt(i)] === undefined) return null 
      node = node.children[word.charAt(i)]
    }
    return node
  }

  remove(word, count) {
    if (typeof word !== 'string') return
    if (typeof count !== 'number') count = 1
    else if (count <= 0) return

    if (word === '') {
      if (this.root.count >= count) this.root.count -= count
      else this.root.count = 0
      return
    }

    let child = this.root
    const len = word.length
    let i, key
    
    for (i = 0; i < len; i++) {
      key = word.charAt(i)
      if (child.children[key] === undefined) return
      child = child.children[key]
    }

    if (child.count >= count) child.count -= count
    else child.count = 0

    if (
      child.count <= 0 &&
      Object.keys(child.children).length &&
      child.children.constructor === Object
    ) {
      child.parent.children[child.key] = undefined
    }
  }

  findAllWords(prefix) {
    const output = []
    
    const node = this.findPrefix(prefix)
    
    if (node === null) return output
    Trie.findAllWords(node, prefix, output)
    return output
  }

  contains(word) {
    
    const node = this.findPrefix(word)
    
    return node !== null && node.count !== 0
  }

  findOccurrences(word) {
    
    const node = this.findPrefix(word)
    
    if (node === null) return 0
    return node.count
  }
}

export { Trie }
