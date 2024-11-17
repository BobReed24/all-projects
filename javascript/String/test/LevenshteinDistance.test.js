import { levenshteinDistance } from '../LevenshteinDistance'

describe('levenshteinDistance', () => {
  it('should calculate edit distance between two strings', () => {
    expect(levenshteinDistance('', '')).toBe(0)
    expect(levenshteinDistance('a', '')).toBe(1)
    expect(levenshteinDistance('', 'a')).toBe(1)
    expect(levenshteinDistance('abc', '')).toBe(3)
    expect(levenshteinDistance('', 'abc')).toBe(3)

    expect(levenshteinDistance('igloo', 'gloo')).toBe(1)

    expect(levenshteinDistance('firm', 'forge')).toBe(3)

    expect(levenshteinDistance('fighting', 'sitting')).toBe(3)

    expect(levenshteinDistance('ball', 'baseball')).toBe(4)

    expect(levenshteinDistance('baseball', 'foot')).toBe(8)
  })
})
