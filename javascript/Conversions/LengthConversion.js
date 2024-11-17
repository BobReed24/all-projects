const lengthConversion = (length, fromUnit, toUnit) => {
  
  const meters = {
    mm: 0.001,
    cm: 0.01,
    m: 1,
    km: 1000,
    inch: 0.0254,
    ft: 0.3048,
    yd: 0.9144,
    mi: 1609.34
  }

  if (!(fromUnit in meters) || !(toUnit in meters)) {
    throw new Error('Invalid units')
  }

  const metersFrom = length * meters[fromUnit]
  const convertedLength = metersFrom / meters[toUnit]

  return convertedLength
}

export { lengthConversion }
