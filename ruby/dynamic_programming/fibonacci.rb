def fibonacci(number, memo_hash = {})
  return number if number <= 1

  memo_hash[0] = 0
  memo_hash[1] = 1

  memoize(number, memo_hash)
end

def memoize(number, memo_hash)
  return memo_hash[number] if memo_hash.key? number

  memo_hash[number] = memoize(number - 1, memo_hash) + memoize(number - 2, memo_hash)

  memoize(number, memo_hash)
end

n = 2
fibonacci(n)

n = 3
fibonacci(n)

n = 4
fibonacci(n)

