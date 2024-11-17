function detectCycle(head) {
  
  if (!head) {
    return false
  }

  let slow = head
  let fast = head.next
  while (fast && fast.next) {
    if (fast === slow) {
      return true
    }
    fast = fast.next.next
    slow = slow.next
  }
  return false
}

export { detectCycle }
