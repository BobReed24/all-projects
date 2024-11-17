const S = [
  7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 5, 9, 14, 20, 5,
  9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11,
  16, 23, 4, 11, 16, 23, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15,
  21
]

const K = [
  0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee, 0xf57c0faf, 0x4787c62a,
  0xa8304613, 0xfd469501, 0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be,
  0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821, 0xf61e2562, 0xc040b340,
  0x265e5a51, 0xe9b6c7aa, 0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
  0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed, 0xa9e3e905, 0xfcefa3f8,
  0x676f02d9, 0x8d2a4c8a, 0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c,
  0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70, 0x289b7ec6, 0xeaa127fa,
  0xd4ef3085, 0x04881d05, 0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665,
  0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039, 0x655b59c3, 0x8f0ccc92,
  0xffeff47d, 0x85845dd1, 0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1,
  0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391
]

function chunkify(array, size) {
  const chunks = []
  for (let i = 0; i < array.length; i += size) {
    chunks.push(array.slice(i, i + size))
  }
  return chunks
}

function rotateLeft(bits, turns) {
  return (bits << turns) | (bits >>> (32 - turns))
}

function u8ToU32(u8Array) {
  const uint32Array = new Uint32Array(u8Array.length / 4)

  for (let i = 0; i < u8Array.length; i += 4) {
    uint32Array[i / 4] =
      (u8Array[i] |
        (u8Array[i + 1] << 8) |
        (u8Array[i + 2] << 16) |
        (u8Array[i + 3] << 24)) >>>
      0
  }

  return uint32Array
}

function u32ToU8(u32Array) {
  const uint8Array = new Uint8Array(u32Array.length * 4)

  for (let i = 0; i < u32Array.length; i++) {
    uint8Array[i * 4] = u32Array[i] & 0xff
    uint8Array[i * 4 + 1] = (u32Array[i] >> 8) & 0xff
    uint8Array[i * 4 + 2] = (u32Array[i] >> 16) & 0xff
    uint8Array[i * 4 + 3] = (u32Array[i] >> 24) & 0xff
  }

  return uint8Array
}

function padEnd(u8Array, size) {
  const result = new Uint8Array(size)
  result.set(u8Array)
  result.fill(0, u8Array.length)

  return result
}

function preProcess(message) {
  
  let m = padEnd(
    message,
    message.length + 1 + (56 - ((message.length + 1) % 64)) + 8
  )

  m[message.length] = 1 << 7

  m = u8ToU32(m)

  let ml = message.length * 8
  m[m.length - 2] = ml & 0xffffffff
  m[m.length - 1] = (ml / 0x100000000) | 0

  return m
}

function MD5(message) {
  
  let [a0, b0, c0, d0] = [
    0x67452301 >>> 0,
    0xefcdab89 >>> 0,
    0x98badcfe >>> 0,
    0x10325476 >>> 0
  ]

  const words = Array.from(preProcess(message))
  const chunks = chunkify(words, 16)

  chunks.forEach(function (chunk, _) {
    
    let [A, B, C, D] = [a0, b0, c0, d0]

    for (let i = 0; i < 64; i++) {
      let [F, g] = [0, 0]

      if (i <= 15) {
        F = (B & C) | (~B & D)
        g = i
      } else if (i <= 31) {
        F = (D & B) | (~D & C)
        g = (5 * i + 1) % 16
      } else if (i <= 47) {
        F = B ^ C ^ D
        g = (3 * i + 5) % 16
      } else {
        F = C ^ (B | ~D)
        g = (7 * i) % 16
      }

      F = (F + A + K[i] + chunk[g]) >>> 0
      A = D
      D = C
      C = B
      B = ((B + rotateLeft(F, S[i])) & 0xffffffff) >>> 0
    }

    a0 = (a0 + A) >>> 0
    b0 = (b0 + B) >>> 0
    c0 = (c0 + C) >>> 0
    d0 = (d0 + D) >>> 0
  })

  return u32ToU8([a0, b0, c0, d0])
}

export { MD5 }
