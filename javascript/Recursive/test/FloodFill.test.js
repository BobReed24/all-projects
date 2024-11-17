import { breadthFirstSearch, depthFirstSearch } from '../FloodFill'

const black = [0, 0, 0]
const green = [0, 255, 0]
const violet = [255, 0, 255]
const white = [255, 255, 255]
const orange = [255, 128, 0]

describe('FloodFill', () => {
  it('should calculate the correct colors using breadth-first approach', () => {
    expect(testBreadthFirst([1, 1], green, orange, [1, 1])).toEqual(orange)
    expect(testBreadthFirst([1, 1], green, orange, [0, 1])).toEqual(violet)
    expect(testBreadthFirst([1, 1], green, orange, [6, 4])).toEqual(white)
  })

  it('should calculate the correct colors using depth-first approach', () => {
    expect(testDepthFirst([1, 1], green, orange, [1, 1])).toEqual(orange)
    expect(testDepthFirst([1, 1], green, orange, [0, 1])).toEqual(violet)
    expect(testDepthFirst([1, 1], green, orange, [6, 4])).toEqual(white)
  })
})

describe.each([breadthFirstSearch, depthFirstSearch])('%o', (floodFillFun) => {
  it.each([
    [1, -1],
    [-1, 1],
    [0, 7],
    [7, 0]
  ])('throws for start position [%i, %i]', (location) => {
    expect(() =>
      floodFillFun(generateTestRgbData(), location, green, orange)
    ).toThrowError()
  })
})

function testBreadthFirst(
  fillLocation,
  targetColor,
  replacementColor,
  testLocation
) {
  const rgbData = generateTestRgbData()
  breadthFirstSearch(rgbData, fillLocation, targetColor, replacementColor)
  return rgbData[testLocation[0]][testLocation[1]]
}

function testDepthFirst(
  fillLocation,
  targetColor,
  replacementColor,
  testLocation
) {
  const rgbData = generateTestRgbData()
  depthFirstSearch(rgbData, fillLocation, targetColor, replacementColor)
  return rgbData[testLocation[0]][testLocation[1]]
}

function generateTestRgbData() {
  const layout = [
    [violet, violet, green, green, black, green, green],
    [violet, green, green, black, green, green, green],
    [green, green, green, black, green, green, green],
    [black, black, green, black, white, white, green],
    [violet, violet, black, violet, violet, white, white],
    [green, green, green, violet, violet, violet, violet],
    [violet, violet, violet, violet, violet, violet, violet]
  ]

  const transposed = []
  for (let x = 0; x < layout[0].length; x++) {
    transposed[x] = []
    for (let y = 0; y < layout.length; y++) {
      transposed[x][y] = layout[y][x]
    }
  }

  return transposed
}
