function keyFinder(str) {
  
  const wordBank = [
    'I ',
    'You ',
    'We ',
    'They ',
    'He ',
    'She ',
    'It ',
    ' the ',
    'The ',
    ' of ',
    ' is ',
    'Is ',
    ' am ',
    'Am ',
    ' are ',
    'Are ',
    ' have ',
    'Have ',
    ' has ',
    'Has ',
    ' may ',
    'May ',
    ' be ',
    'Be '
  ]
  const inStr = str.toString() 
  let outStr = '' 
  let outStrElement = '' 
  for (let k = 0; k < 26; k++) {
    
    outStr = caesarCipherEncodeAndDecodeEngine(inStr, k) 

    for (let s = 0; s < outStr.length; s++) {
      for (let i = 0; i < wordBank.length; i++) {
        
        for (let w = 0; w < wordBank[i].length; w++) {
          outStrElement += outStr[s + w]
        }
        
        if (wordBank[i] === outStrElement) {
          return k 
        }
        outStrElement = '' 
      } 
    }
  }
  return 0 
}

function caesarCipherEncodeAndDecodeEngine(inStr, numShifted) {
  const shiftNum = numShifted
  let charCode = 0
  let shiftedCharCode = 0
  let result = 0

  return inStr
    .split('')
    .map((char) => {
      charCode = char.charCodeAt()
      shiftedCharCode = charCode + shiftNum
      result = charCode

      if (charCode >= 48 && charCode <= 57) {
        if (shiftedCharCode < 48) {
          let diff = Math.abs(48 - 1 - shiftedCharCode) % 10

          while (diff >= 10) {
            diff = diff % 10
          }
          document.getElementById('diffID').innerHTML = diff

          shiftedCharCode = 57 - diff

          result = shiftedCharCode
        } else if (shiftedCharCode >= 48 && shiftedCharCode <= 57) {
          result = shiftedCharCode
        } else if (shiftedCharCode > 57) {
          let diff = Math.abs(57 + 1 - shiftedCharCode) % 10

          while (diff >= 10) {
            diff = diff % 10
          }
          document.getElementById('diffID').innerHTML = diff

          shiftedCharCode = 48 + diff

          result = shiftedCharCode
        }
      } else if (charCode >= 65 && charCode <= 90) {
        if (shiftedCharCode <= 64) {
          let diff = Math.abs(65 - 1 - shiftedCharCode) % 26

          while (diff % 26 >= 26) {
            diff = diff % 26
          }
          shiftedCharCode = 90 - diff
          result = shiftedCharCode
        } else if (shiftedCharCode >= 65 && shiftedCharCode <= 90) {
          result = shiftedCharCode
        } else if (shiftedCharCode > 90) {
          let diff = Math.abs(shiftedCharCode - 1 - 90) % 26

          while (diff % 26 >= 26) {
            diff = diff % 26
          }
          shiftedCharCode = 65 + diff
          result = shiftedCharCode
        }
      } else if (charCode >= 97 && charCode <= 122) {
        if (shiftedCharCode <= 96) {
          let diff = Math.abs(97 - 1 - shiftedCharCode) % 26

          while (diff % 26 >= 26) {
            diff = diff % 26
          }
          shiftedCharCode = 122 - diff
          result = shiftedCharCode
        } else if (shiftedCharCode >= 97 && shiftedCharCode <= 122) {
          result = shiftedCharCode
        } else if (shiftedCharCode > 122) {
          let diff = Math.abs(shiftedCharCode - 1 - 122) % 26

          while (diff % 26 >= 26) {
            diff = diff % 26
          }
          shiftedCharCode = 97 + diff
          result = shiftedCharCode
        }
      }
      return String.fromCharCode(parseInt(result))
    })
    .join('')
}

export { keyFinder }

