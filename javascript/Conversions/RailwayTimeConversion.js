const RailwayTimeConversion = (timeString) => {
  
  if (typeof timeString !== 'string') {
    throw new TypeError('Argument is not a string.')
  }
  
  const [hour, minute, secondWithShift] = timeString.split(':')
  
  const [second, shift] = [
    secondWithShift.substring(0, 2),
    secondWithShift.substring(2)
  ]
  
  if (shift === 'PM') {
    if (parseInt(hour) === 12) {
      return `${hour}:${minute}:${second}`
    } else {
      return `${parseInt(hour) + 12}:${minute}:${second}`
    }
  } else {
    if (parseInt(hour) === 12) {
      return `00:${minute}:${second}`
    } else {
      return `${hour}:${minute}:${second}`
    }
  }
}

export { RailwayTimeConversion }
