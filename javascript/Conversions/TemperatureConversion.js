const celsiusToFahrenheit = (celsius) => {
  
  return Math.round((celsius * 9) / 5 + 32)
}

const celsiusToKelvin = (celsius) => {
  
  return Math.round(celsius + 273.15)
}

const celsiusToRankine = (celsius) => {
  
  return Math.round((celsius * 9) / 5 + 491.67)
}

const fahrenheitToCelsius = (fahrenheit) => {
  
  return Math.round(((fahrenheit - 32) * 5) / 9)
}

const fahrenheitToKelvin = (fahrenheit) => {
  
  return Math.round(((fahrenheit - 32) * 5) / 9 + 273.15)
}

const fahrenheitToRankine = (fahrenheit) => {
  
  return Math.round(fahrenheit + 459.67)
}

const kelvinToCelsius = (kelvin) => {
  
  return Math.round(kelvin - 273.15)
}

const kelvinToFahrenheit = (kelvin) => {
  
  return Math.round(((kelvin - 273.15) * 9) / 5 + 32)
}

const kelvinToRankine = (kelvin) => {
  
  return Math.round((kelvin * 9) / 5)
}

const rankineToCelsius = (rankine) => {
  
  return Math.round(((rankine - 491.67) * 5) / 9)
}

const rankineToFahrenheit = (rankine) => {
  
  return Math.round(rankine - 459.67)
}

const rankineToKelvin = (rankine) => {
  
  return Math.round((rankine * 5) / 9)
}

const reaumurToKelvin = (reaumur) => {
  
  return Math.round(reaumur * 1.25 + 273.15)
}

const reaumurToFahrenheit = (reaumur) => {
  
  return Math.round(reaumur * 2.25 + 32)
}

const reaumurToCelsius = (reaumur) => {
  
  return Math.round(reaumur * 1.25)
}

const reaumurToRankine = (reaumur) => {
  
  return Math.round(reaumur * 2.25 + 32 + 459.67)
}

export {
  celsiusToFahrenheit,
  celsiusToKelvin,
  celsiusToRankine,
  fahrenheitToCelsius,
  fahrenheitToKelvin,
  fahrenheitToRankine,
  kelvinToCelsius,
  kelvinToFahrenheit,
  kelvinToRankine,
  rankineToCelsius,
  rankineToFahrenheit,
  rankineToKelvin,
  reaumurToCelsius,
  reaumurToFahrenheit,
  reaumurToKelvin,
  reaumurToRankine
}
