def gcd(a, b)
  b.zero? ? a : gcd(b, a % b)
end

def lcm(a, b)
  (a * b) / gcd(a, b)
end

result = 1

20.times do |i|
  result = lcm(result, i + 1)
end

p result
