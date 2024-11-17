import { isLeapYear } from '../Maths/LeapYear'
import { parseDate } from '../Timing-Functions/ParseDate'

const DateToDay = (dd, mm, yyyy) => {
  return (
    365 * (yyyy - 1) +
    Math.floor((yyyy - 1) / 4) -
    Math.floor((yyyy - 1) / 100) +
    Math.floor((yyyy - 1) / 400) +
    dd +
    Math.floor((367 * mm - 362) / 12) +
    (mm <= 2 ? 0 : isLeapYear(yyyy) ? -1 : -2)
  )
}

const DateDayDifference = (date1, date2) => {
  const firstDate = parseDate(date1)
  const secondDate = parseDate(date2)

  return Math.abs(
    DateToDay(secondDate.day, secondDate.month, secondDate.year) -
      DateToDay(firstDate.day, firstDate.month, firstDate.year)
  )
}

export { DateDayDifference }
