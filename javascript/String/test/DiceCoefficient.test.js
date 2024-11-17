import { diceCoefficient } from '../DiceCoefficient'

describe('diceCoefficient', () => {
  it('should calculate edit distance between two strings', () => {
    
    expect(diceCoefficient('abc', 'abc')).toBe(1)
    expect(diceCoefficient('', '')).toBe(1)

    expect(diceCoefficient('a', '')).toBe(0)
    expect(diceCoefficient('', 'a')).toBe(0)

    expect(diceCoefficient('skate', 'ate')).toBe(0.66)

    expect(diceCoefficient('money', 'honey')).toBe(0.75)

    expect(diceCoefficient('love', 'hate')).toBe(0)

    expect(diceCoefficient('skilled', 'killed')).toBe(0.9)
  })
})
