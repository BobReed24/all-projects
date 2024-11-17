const haversineDistance = (
  latitude1 = 0,
  longitude1 = 0,
  latitude2 = 0,
  longitude2 = 0
) => {
  validateLatOrLong(latitude1)
  validateLatOrLong(latitude2)
  validateLatOrLong(longitude1)
  validateLatOrLong(longitude2)
  const earthRadius = 6371e3 
  const pi = Math.PI
  const cos1 = (latitude1 * pi) / 180.0
  const cos2 = (latitude2 * pi) / 180.0
  const deltaLatitude = ((latitude2 - latitude1) * pi) / 180.0
  const deltaLongitude = ((longitude2 - longitude1) * pi) / 180.0

  const alpha =
    Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
    Math.cos(cos1) *
      Math.cos(cos2) *
      Math.sin(deltaLongitude / 2) *
      Math.sin(deltaLongitude / 2)
  const constant = 2 * Math.atan2(Math.sqrt(alpha), Math.sqrt(1 - alpha))
  return earthRadius * constant
}

const validateLatOrLong = (value) => {
  if (typeof value !== 'number') {
    throw new TypeError('The value of latitude or longitude should be a number')
  }
}

export { haversineDistance }
