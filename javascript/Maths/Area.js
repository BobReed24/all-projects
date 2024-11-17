const surfaceAreaCube = (side) => {
  validateNumericParam(side, 'side')
  return 6 * side ** 2
}

const surfaceAreaSphere = (radius) => {
  validateNumericParam(radius, 'radius')
  return 4.0 * Math.PI * radius ** 2.0
}

const areaRectangle = (length, width) => {
  validateNumericParam(length, 'Length')
  validateNumericParam(width, 'Width')
  return width * length
}

const areaSquare = (side) => {
  validateNumericParam(side, 'square side')
  return side ** 2
}

const areaTriangle = (base, height) => {
  validateNumericParam(base, 'Base')
  validateNumericParam(height, 'Height')
  return (base * height) / 2.0
}

const areaTriangleWithAllThreeSides = (side1, side2, side3) => {
  validateNumericParam(side1, 'side1')
  validateNumericParam(side2, 'side2')
  validateNumericParam(side3, 'side3')
  if (
    side1 + side2 <= side3 ||
    side1 + side3 <= side2 ||
    side2 + side3 <= side1
  ) {
    throw new TypeError('Invalid Triangle sides.')
  }
  
  const semi = (side1 + side2 + side3) / 2

  const area = Math.sqrt(
    semi * (semi - side1) * (semi - side2) * (semi - side3)
  )
  return Number(area.toFixed(2))
}

const areaParallelogram = (base, height) => {
  validateNumericParam(base, 'Base')
  validateNumericParam(height, 'Height')
  return base * height
}

const areaTrapezium = (base1, base2, height) => {
  validateNumericParam(base1, 'Base One')
  validateNumericParam(base2, 'Base Two')
  validateNumericParam(height, 'Height')
  return (1 / 2) * (base1 + base2) * height
}

const areaCircle = (radius) => {
  validateNumericParam(radius, 'Radius')
  return Math.PI * radius ** 2
}

const areaRhombus = (diagonal1, diagonal2) => {
  validateNumericParam(diagonal1, 'diagonal one')
  validateNumericParam(diagonal2, 'diagonal two')
  return (1 / 2) * diagonal1 * diagonal2
}

const validateNumericParam = (param, paramName = 'param') => {
  if (typeof param !== 'number') {
    throw new TypeError('The ' + paramName + ' should be type Number')
  } else if (param < 0) {
    throw new Error('The ' + paramName + ' only accepts non-negative values')
  }
}

export {
  surfaceAreaCube,
  surfaceAreaSphere,
  areaRectangle,
  areaSquare,
  areaTriangle,
  areaParallelogram,
  areaTrapezium,
  areaCircle,
  areaRhombus,
  areaTriangleWithAllThreeSides
}
