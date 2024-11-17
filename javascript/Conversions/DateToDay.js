import { parseDate } from '../Timing-Functions/ParseDate'

const daysNameArr = [
  'Saturday',
  'Sunday',
  'Monday',
  'Tuesday',
  'Wednesday',
  'Thursday',
  'Friday'
]

const DateToDay = (date) => {
  
  const dateStruct = parseDate(date)
  let year = dateStruct.year
  let month = dateStruct.month
  let day = dateStruct.day

  if (month < 3) {
    year--
    month += 12
  }

  const yearDigits = year % 100
  const century = Math.floor(year / 100)

  const weekDay =
    (day +
      Math.floor((month + 1) * 2.6) +
      yearDigits +
      Math.floor(yearDigits / 4) +
      Math.floor(century / 4) +
      5 * century) %
    7
  return daysNameArr[weekDay] 
}

export { DateToDay }
