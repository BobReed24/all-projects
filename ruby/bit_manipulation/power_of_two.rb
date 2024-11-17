def is_power_of_two(n)
  return false if n < 1

  n & (n - 1) == 0
end

n = 1

puts is_power_of_two(n)
n = 16

puts is_power_of_two(n)
n = 3

puts is_power_of_two(n)
n = 4

puts is_power_of_two(n)
n = 5

puts is_power_of_two(n)
