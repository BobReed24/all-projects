const neighborOffsets = [
  [-1, -1],
  [-1, 0],
  [-1, 1],
  [0, -1],
  [0, 1],
  [1, -1],
  [1, 0],
  [1, 1]
]

function isInside(rgbData, location) {
  const x = location[0]
  const y = location[1]
  return x >= 0 && x < rgbData.length && y >= 0 && y < rgbData[0].length
}

function checkLocation(rgbData, location) {
  if (!isInside(rgbData, location)) {
    throw new Error('location should point to a pixel within the rgbData')
  }
}

function* neighbors(rgbData, location) {
  for (const offset of neighborOffsets) {
    const neighborLocation = [location[0] + offset[0], location[1] + offset[1]]
    if (isInside(rgbData, neighborLocation)) {
      yield neighborLocation
    }
  }
}

export function breadthFirstSearch(
  rgbData,
  location,
  targetColor,
  replacementColor
) {
  checkLocation(rgbData, location)

  const queue = []
  queue.push(location)

  while (queue.length > 0) {
    breadthFirstFill(rgbData, location, targetColor, replacementColor, queue)
  }
}

export function depthFirstSearch(
  rgbData,
  location,
  targetColor,
  replacementColor
) {
  checkLocation(rgbData, location)

  depthFirstFill(rgbData, location, targetColor, replacementColor)
}

function breadthFirstFill(
  rgbData,
  location,
  targetColor,
  replacementColor,
  queue
) {
  const currentLocation = queue[0]
  queue.shift()

  if (rgbData[currentLocation[0]][currentLocation[1]] === targetColor) {
    rgbData[currentLocation[0]][currentLocation[1]] = replacementColor
    for (const neighborLocation of neighbors(rgbData, currentLocation)) {
      queue.push(neighborLocation)
    }
  }
}

function depthFirstFill(rgbData, location, targetColor, replacementColor) {
  if (rgbData[location[0]][location[1]] === targetColor) {
    rgbData[location[0]][location[1]] = replacementColor
    for (const neighborLocation of neighbors(rgbData, location)) {
      depthFirstFill(rgbData, neighborLocation, targetColor, replacementColor)
    }
  }
}
