export function hsvToRgb(hue, saturation, value) {
  if (hue < 0 || hue > 360) {
    throw new Error('hue should be between 0 and 360')
  }

  if (saturation < 0 || saturation > 1) {
    throw new Error('saturation should be between 0 and 1')
  }

  if (value < 0 || value > 1) {
    throw new Error('value should be between 0 and 1')
  }

  const chroma = value * saturation
  const hueSection = hue / 60
  const secondLargestComponent = chroma * (1 - Math.abs((hueSection % 2) - 1))
  const matchValue = value - chroma

  return getRgbBySection(hueSection, chroma, matchValue, secondLargestComponent)
}

export function rgbToHsv(red, green, blue) {
  if (red < 0 || red > 255) {
    throw new Error('red should be between 0 and 255')
  }

  if (green < 0 || green > 255) {
    throw new Error('green should be between 0 and 255')
  }

  if (blue < 0 || blue > 255) {
    throw new Error('blue should be between 0 and 255')
  }

  const dRed = red / 255
  const dGreen = green / 255
  const dBlue = blue / 255
  const value = Math.max(Math.max(dRed, dGreen), dBlue)
  const chroma = value - Math.min(Math.min(dRed, dGreen), dBlue)
  const saturation = value === 0 ? 0 : chroma / value
  let hue

  if (chroma === 0) {
    hue = 0
  } else if (value === dRed) {
    hue = 60 * ((dGreen - dBlue) / chroma)
  } else if (value === dGreen) {
    hue = 60 * (2 + (dBlue - dRed) / chroma)
  } else {
    hue = 60 * (4 + (dRed - dGreen) / chroma)
  }

  hue = (hue + 360) % 360

  return [hue, saturation, value]
}

export function approximatelyEqualHsv(hsv1, hsv2) {
  const bHue = Math.abs(hsv1[0] - hsv2[0]) < 0.2
  const bSaturation = Math.abs(hsv1[1] - hsv2[1]) < 0.002
  const bValue = Math.abs(hsv1[2] - hsv2[2]) < 0.002

  return bHue && bSaturation && bValue
}

function getRgbBySection(
  hueSection,
  chroma,
  matchValue,
  secondLargestComponent
) {
  function convertToInt(input) {
    return Math.round(255 * input)
  }

  let red
  let green
  let blue

  if (hueSection >= 0 && hueSection <= 1) {
    red = convertToInt(chroma + matchValue)
    green = convertToInt(secondLargestComponent + matchValue)
    blue = convertToInt(matchValue)
  } else if (hueSection > 1 && hueSection <= 2) {
    red = convertToInt(secondLargestComponent + matchValue)
    green = convertToInt(chroma + matchValue)
    blue = convertToInt(matchValue)
  } else if (hueSection > 2 && hueSection <= 3) {
    red = convertToInt(matchValue)
    green = convertToInt(chroma + matchValue)
    blue = convertToInt(secondLargestComponent + matchValue)
  } else if (hueSection > 3 && hueSection <= 4) {
    red = convertToInt(matchValue)
    green = convertToInt(secondLargestComponent + matchValue)
    blue = convertToInt(chroma + matchValue)
  } else if (hueSection > 4 && hueSection <= 5) {
    red = convertToInt(secondLargestComponent + matchValue)
    green = convertToInt(matchValue)
    blue = convertToInt(chroma + matchValue)
  } else {
    red = convertToInt(chroma + matchValue)
    green = convertToInt(matchValue)
    blue = convertToInt(secondLargestComponent + matchValue)
  }

  return [red, green, blue]
}
