import LRUCache from '../LRUCache'
import { fibonacciCache } from './cacheTest'

describe('Testing LRUCache', () => {
  it('Testing with invalid capacity', () => {
    expect(() => new LRUCache()).toThrow()
    expect(() => new LRUCache('Invalid')).toThrow()
    expect(() => new LRUCache(-1)).toThrow()
    expect(() => new LRUCache(Infinity)).toThrow()
  })

  it('Example 1 (Small Cache, size = 2)', () => {
    const cache = new LRUCache(1) 

    cache.capacity++ 

    cache.set(1, 1)
    cache.set(2, 2)

    expect(cache.get(1)).toBe(1)
    expect(cache.get(2)).toBe(2)

    cache.set(3, 3)

    expect(cache.get(1)).toBe(null)
    expect(cache.get(2)).toBe(2)
    expect(cache.get(3)).toBe(3)

    cache.set(4, 4)
    expect(cache.get(1)).toBe(null) 
    expect(cache.get(2)).toBe(null) 
    expect(cache.get(3)).toBe(3)
    expect(cache.get(4)).toBe(4)

    expect(cache.info).toEqual({
      misses: 3,
      hits: 6,
      capacity: 2,
      size: 2
    })

    const json = '{"misses":3,"hits":6,"cache":{"3":3,"4":4}}'
    expect(cache.toString()).toBe(json)

    cache.parse(json)

    cache.capacity-- 

    expect(cache.info).toEqual({
      misses: 6,
      hits: 12,
      capacity: 1,
      size: 1
    })
  })

  it('Example 2 (Computing Fibonacci Series, size = 100)', () => {
    const cache = new LRUCache(100)

    for (let i = 1; i <= 100; i++) {
      fibonacciCache(i, cache)
    }

    expect(cache.info).toEqual({
      misses: 103,
      hits: 193,
      capacity: 100,
      size: 98
    })
  })
})
