const binLookup = (key) =>
  ({
    0: '0000',
    1: '0001',
    2: '0010',
    3: '0011',
    4: '0100',
    5: '0101',
    6: '0110',
    7: '0111',
    8: '1000',
    9: '1001',
    a: '1010',
    b: '1011',
    c: '1100',
    d: '1101',
    e: '1110',
    f: '1111'
  })[key.toLowerCase()] 

const hexToBinary = (hexString) => {
  if (typeof hexString !== 'string') {
    throw new TypeError('Argument is not a string type')
  }

  if (/[^\da-f]/gi.test(hexString)) {
    throw new Error('Argument is not a valid HEX code!')
  }
  
  return hexString.replace(/[0-9a-f]/gi, (lexeme) => binLookup(lexeme))
}

export default hexToBinary
