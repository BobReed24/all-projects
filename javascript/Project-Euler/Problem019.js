import { isLeapYear } from '../Maths/LeapYear'

function problem19() {
  let sundaysCount = 0 
  let dayOfWeek = 2 

  for (let year = 1901; year <= 2000; year++) {
    for (let month = 1; month <= 12; month++) {
      if (dayOfWeek === 0) {
        
        sundaysCount++
      }

      let daysInMonth = 31
      if (month === 4 || month === 6 || month === 9 || month === 11) {
        
        daysInMonth = 30
      } else if (month === 2) {
        
        daysInMonth = isLeapYear(year) ? 29 : 28
      }

      dayOfWeek = (dayOfWeek + daysInMonth) % 7 
    }
  }

  return sundaysCount
}

export { problem19 }
