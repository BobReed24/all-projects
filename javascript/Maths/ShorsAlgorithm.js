function ShorsAlgorithm(num) {
  const N = BigInt(num)

  while (true) {
    
    const g = BigInt(Math.floor(Math.random() * (num - 1)) + 2)

    let K = gcd(g, N)
    if (K !== 1) return K

    const p = findP(g, N)

    if (p % 2n === 1n) continue

    const base = g ** (p / 2n) 
    const upper = base + 1n 
    const lower = base - 1n 

    if (upper % N === 0n || lower % N === 0n) continue

    K = gcd(upper, N)
    if (K !== 1) return K 
    return gcd(lower, N) 
  }
}

function findP(A, B) {
  let p = 1n
  while (!isValidP(A, B, p)) p++
  return p
}

function isValidP(A, B, p) {
  
  return (A ** p - 1n) % B === 0n
}

function gcd(A, B) {
  while (B !== 0n) {
    ;[A, B] = [B, A % B]
  }

  return Number(A)
}

export { ShorsAlgorithm }
