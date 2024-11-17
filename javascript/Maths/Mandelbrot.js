export function getRGBData(
  imageWidth = 800,
  imageHeight = 600,
  figureCenterX = -0.6,
  figureCenterY = 0,
  figureWidth = 3.2,
  maxStep = 50,
  useDistanceColorCoding = true
) {
  if (imageWidth <= 0) {
    throw new Error('imageWidth should be greater than zero')
  }

  if (imageHeight <= 0) {
    throw new Error('imageHeight should be greater than zero')
  }

  if (maxStep <= 0) {
    throw new Error('maxStep should be greater than zero')
  }

  const rgbData = []
  const figureHeight = (figureWidth / imageWidth) * imageHeight

  for (let imageX = 0; imageX < imageWidth; imageX++) {
    rgbData[imageX] = []
    for (let imageY = 0; imageY < imageHeight; imageY++) {
      
      const figureX = figureCenterX + (imageX / imageWidth - 0.5) * figureWidth
      const figureY =
        figureCenterY + (imageY / imageHeight - 0.5) * figureHeight

      const distance = getDistance(figureX, figureY, maxStep)

      rgbData[imageX][imageY] = useDistanceColorCoding
        ? colorCodedColorMap(distance)
        : blackAndWhiteColorMap(distance)
    }
  }

  return rgbData
}

function blackAndWhiteColorMap(distance) {
  return distance >= 1 ? [0, 0, 0] : [255, 255, 255]
}

function colorCodedColorMap(distance) {
  if (distance >= 1) {
    return [0, 0, 0]
  } else {
    
    const hue = 360 * distance
    const saturation = 1
    const val = 255
    const hi = Math.floor(hue / 60) % 6
    const f = hue / 60 - Math.floor(hue / 60)

    const v = val
    const p = 0
    const q = Math.floor(val * (1 - f * saturation))
    const t = Math.floor(val * (1 - (1 - f) * saturation))

    switch (hi) {
      case 0:
        return [v, t, p]
      case 1:
        return [q, v, p]
      case 2:
        return [p, v, t]
      case 3:
        return [p, q, v]
      case 4:
        return [t, p, v]
      default:
        return [v, p, q]
    }
  }
}

function getDistance(figureX, figureY, maxStep) {
  let a = figureX
  let b = figureY
  let currentStep = 0
  for (let step = 0; step < maxStep; step++) {
    currentStep = step
    const aNew = a * a - b * b + figureX
    b = 2 * a * b + figureY
    a = aNew

    if (a * a + b * b > 4) {
      break
    }
  }
  return currentStep / (maxStep - 1)
}
