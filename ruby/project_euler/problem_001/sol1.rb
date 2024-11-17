def divisible_by_three_or_five?(number)
  (number % 3).zero? || (number % 5).zero?
end

sum = 0
(1...1000).each do |i|
  sum += i if divisible_by_three_or_five?(i)
end

p sum
