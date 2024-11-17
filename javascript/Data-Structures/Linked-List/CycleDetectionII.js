function findCycleStart(head) {
  let length = 0
  let fast = head
  let slow = head

  while (fast !== null && fast.next !== null) {
    fast = fast.next.next
    slow = slow.next
    if (fast === slow) {
      length = cycleLength(slow)
      break
    }
  }

  if (length === 0) {
    
    return null
  }

  let ahead = head
  let behind = head
  
  while (length > 0) {
    ahead = ahead.next
    length--
  }

  while (ahead !== behind) {
    ahead = ahead.next
    behind = behind.next
  }

  return ahead
}

function cycleLength(head) {
  
  let cur = head
  let len = 0
  do {
    cur = cur.next
    len++
  } while (cur != head)
  return len
}

export { findCycleStart }
