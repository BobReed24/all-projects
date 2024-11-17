def fibonacci(n)
  golden_ratio = (1 + 5**0.5) / 2
  ((golden_ratio**n + 1) / 5**0.5).to_i
end

n = 2
puts(fibonacci(n))

n = 3
puts(fibonacci(n))

n = 4
puts(fibonacci(n))

