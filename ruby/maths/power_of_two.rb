def is_power_of_two(n)
  if n == 1
    true
  elsif n.even?
    is_power_of_two(n / 2)
  else
    false
  end
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

def is_power_of_two(n)
  n /= 2 while n.even? && n != 0
  n == 1
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

def is_power_of_two(n)
  result_exponent = Math.log(n) / Math.log(2)
  result_exponent % 1 == 0
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
