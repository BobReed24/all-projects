import { degreeToRadian } from './DegreeToRadian.js'

function circularArcLength(radius, degrees) {
  return radius * degreeToRadian(degrees)
}

function circularArcArea(radius, degrees) {
  return (Math.pow(radius, 2) * degreeToRadian(degrees)) / 2
}

export { circularArcLength, circularArcArea }
