function bufferToBase64(binaryData) {
  
  const base64Table =
    'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
  
  const padding = 3 - (binaryData.byteLength % 3)
  
  const byteView = new Uint8Array(binaryData)
  let result = ''

  for (let i = 0; i < byteView.byteLength; i += 3) {
    
    const char1 = (byteView[i] & 252) >> 2
    const char2 = ((byteView[i] & 3) << 4) + ((byteView[i + 1] & 240) >> 4)
    const char3 = ((byteView[i + 1] & 15) << 2) + ((byteView[i + 2] & 192) >> 6)
    const char4 = byteView[i + 2] & 63

    result +=
      base64Table[char1] +
      base64Table[char2] +
      base64Table[char3] +
      base64Table[char4]
  }

  if (padding !== 3) {
    const paddedResult =
      result.slice(0, result.length - padding) + '='.repeat(padding)
    return paddedResult
  }

  return result
}

export { bufferToBase64 }
