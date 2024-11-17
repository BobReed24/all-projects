function base64ToBuffer(b64) {
  
  const base64Table =
    'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
  
  const paddingIdx = b64.indexOf('=')
  
  const b64NoPadding = paddingIdx !== -1 ? b64.slice(0, paddingIdx) : b64
  
  const bufferLength = Math.floor((b64NoPadding.length * 6) / 8)
  
  const result = new ArrayBuffer(bufferLength)
  
  const byteView = new Uint8Array(result)

  for (let i = 0, j = 0; i < b64NoPadding.length; i += 4, j += 3) {
    
    const b64Char1 = base64Table.indexOf(b64NoPadding[i])
    const b64Char2 = base64Table.indexOf(b64NoPadding[i + 1])
    let b64Char3 = base64Table.indexOf(b64NoPadding[i + 2])
    let b64Char4 = base64Table.indexOf(b64NoPadding[i + 3])

    if (b64Char3 === -1) b64Char3 = 0
    if (b64Char4 === -1) b64Char4 = 0

    const byte1 = (b64Char1 << 2) + ((b64Char2 & 48) >> 4)
    const byte2 = ((b64Char2 & 15) << 4) + ((b64Char3 & 60) >> 2)
    const byte3 = ((b64Char3 & 3) << 6) + b64Char4

    byteView[j] = byte1
    byteView[j + 1] = byte2
    byteView[j + 2] = byte3
  }

  return result
}

export { base64ToBuffer }
