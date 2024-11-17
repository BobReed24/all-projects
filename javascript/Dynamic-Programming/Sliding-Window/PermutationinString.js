export function PermutationinString(s1, s2) {
  if (s1.length > s2.length) return false
  let start = 0
  let end = s1.length - 1
  const s1Set = SetHash()
  const s2Set = SetHash()
  for (let i = 0; i < s1.length; i++) {
    s1Set[s1[i]]++
    s2Set[s2[i]]++
  }
  if (equals(s1Set, s2Set)) return true
  while (end < s2.length - 1) {
    if (equals(s1Set, s2Set)) return true
    end++
    const c1 = s2[start]
    const c2 = s2[end]
    if (s2Set[c1] > 0) s2Set[c1]--
    s2Set[c2]++
    start++
    if (equals(s1Set, s2Set)) return true
  }
  return false
}
function equals(a, b) {
  return JSON.stringify(a) === JSON.stringify(b)
}

function SetHash() {
  const set = new Set()
  const alphabets = 'abcdefghijklmnopqrstuvwxyz'
  for (let i = 0; i < alphabets.length; i++) {
    set[alphabets[i]] = 0
  }
  return set
}

