import { LinkedList } from './SinglyLinkedList.js'

function mergeLinkedLists(list1, list2) {
  const mergedList = new LinkedList()

  let current1 = list1.headNode
  let current2 = list2.headNode

  while (current1 || current2) {
    if (!current1) {
      mergedList.addLast(current2.data)
      current2 = current2.next
    } else if (!current2) {
      mergedList.addLast(current1.data)
      current1 = current1.next
    } else {
      if (current1.data < current2.data) {
        mergedList.addLast(current1.data)
        current1 = current1.next
      } else {
        mergedList.addLast(current2.data)
        current2 = current2.next
      }
    }
  }

  return mergedList
}

export { mergeLinkedLists }
