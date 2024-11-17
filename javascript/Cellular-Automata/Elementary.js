export function getNextElementaryGeneration(generation, rule) {
  const NUM_ELEMENTARY_NEIGHBORHOOD_STATES = 8
  const MIN_RULE = 0
  const MAX_RULE = 255

  if (!Number.isInteger(rule)) {
    throw new Error(
      `Rule must be an integer between the values 0 and 255 (got ${rule})`
    )
  }
  if (rule < MIN_RULE || rule > MAX_RULE) {
    throw new RangeError(
      `Rule must be an integer between the values 0 and 255 (got ${rule})`
    )
  }

  const binaryRule = rule
    .toString(2)
    .padStart(NUM_ELEMENTARY_NEIGHBORHOOD_STATES, '0')
  const ruleData = binaryRule.split('').map((bit) => Number.parseInt(bit)) 
  const output = new Array(generation.length)
  const LEFT_DEAD = 4 
  const MIDDLE_DEAD = 2 
  const RIGHT_DEAD = 1 

  for (let i = 0; i < generation.length; i++) {
    let neighborhoodValue = LEFT_DEAD | MIDDLE_DEAD | RIGHT_DEAD

    if (i - 1 > 0 && generation[i - 1] === 1) {
      neighborhoodValue ^= LEFT_DEAD
    }

    if (generation[i] === 1) {
      neighborhoodValue ^= MIDDLE_DEAD
    }

    if (i + 1 < generation.length && generation[i + 1] === 1) {
      neighborhoodValue ^= RIGHT_DEAD
    }

    output[i] = ruleData[neighborhoodValue]
  }

  return output
}
