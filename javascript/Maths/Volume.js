const volCuboid = (width, length, height) => {
  isNumber(width, 'Width')
  isNumber(length, 'Length')
  isNumber(height, 'Height')
  return width * length * height
}

const volCube = (length) => {
  isNumber(length, 'Length')
  return length ** 3
}

const volCone = (radius, height) => {
  isNumber(radius, 'Radius')
  isNumber(height, 'Height')
  return (Math.PI * radius ** 2 * height) / 3.0
}

const volPyramid = (baseLength, baseWidth, height) => {
  isNumber(baseLength, 'BaseLength')
  isNumber(baseWidth, 'BaseWidth')
  isNumber(height, 'Height')
  return (baseLength * baseWidth * height) / 3.0
}

const volCylinder = (radius, height) => {
  isNumber(radius, 'Radius')
  isNumber(height, 'Height')
  return Math.PI * radius ** 2 * height
}

const volTriangularPrism = (baseLengthTriangle, heightTriangle, height) => {
  isNumber(baseLengthTriangle, 'BaseLengthTriangle')
  isNumber(heightTriangle, 'HeightTriangle')
  isNumber(height, 'Height')
  return (1 / 2) * baseLengthTriangle * heightTriangle * height
}

const volPentagonalPrism = (pentagonalLength, pentagonalBaseLength, height) => {
  isNumber(pentagonalLength, 'PentagonalLength')
  isNumber(pentagonalBaseLength, 'PentagonalBaseLength')
  isNumber(height, 'Height')
  return (5 / 2) * pentagonalLength * pentagonalBaseLength * height
}

const volSphere = (radius) => {
  isNumber(radius, 'Radius')
  return (4 / 3) * Math.PI * radius ** 3
}

const volHemisphere = (radius) => {
  isNumber(radius, 'Radius')
  return (2.0 * Math.PI * radius ** 3) / 3.0
}

const isNumber = (number, noName = 'number') => {
  if (typeof number !== 'number') {
    throw new TypeError('The ' + noName + ' should be Number type')
  } else if (number < 0 || !Number.isFinite(number)) {
    throw new Error('The ' + noName + ' only accepts positive values')
  }
}

export {
  volCuboid,
  volCube,
  volCone,
  volPyramid,
  volCylinder,
  volTriangularPrism,
  volPentagonalPrism,
  volSphere,
  volHemisphere
}
