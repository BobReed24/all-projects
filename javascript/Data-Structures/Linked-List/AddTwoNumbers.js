import { Node } from './SinglyLinkedList.js'

class AddTwoNumbers {
  constructor() {
    this.dummyNode = new Node(0)
  }

  solution(firstList, secondList) {
    let firstRunner = firstList
    let secondRunner = secondList
    let tail = this.dummyNode
    let carry = 0
    while (firstRunner != null || secondRunner != null) {
      const firstNumber = firstRunner ? firstRunner.data : 0
      const secondNumber = secondRunner ? secondRunner.data : 0
      const sum = carry + firstNumber + secondNumber
      carry = parseInt(sum / 10)
      tail.next = new Node(sum % 10)
      tail = tail.next
      if (firstRunner) {
        firstRunner = firstRunner.next
      }
      if (secondRunner) {
        secondRunner = secondRunner.next
      }
    }
    if (carry > 0) {
      tail.next = new Node(carry % 10)
    }

    return this.dummyNode.next
  }

  solutionToArray() {
    const list = []
    let currentNode = this.dummyNode.next
    while (currentNode) {
      list.push(currentNode.data)
      currentNode = currentNode.next
    }

    return list
  }
}

export { AddTwoNumbers }
