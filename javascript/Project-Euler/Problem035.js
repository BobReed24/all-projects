import { sieveOfEratosthenes } from '../Maths/SieveOfEratosthenesIntArray'

function problem35(n) {
  if (n < 2) {
    throw new Error('Invalid input')
  }
  
  const list = sieveOfEratosthenes(n).filter(
    (prime) => !prime.toString().match(/[024568]/)
  )

  const result = list.filter((number, _idx, arr) => {
    const str = String(number)
    for (let i = 0; i < str.length; i++) {
      
      const rotation = str.slice(i) + str.slice(0, i)
      if (!arr.includes(Number(rotation))) {
        
        return false
      }
    }
    return true 
  })

  return result.length + 2 
}

export { problem35 }
