def lucas(number)
  golden_ratio = (1 + 5**0.5) / 2
  (golden_ratio**number).round.to_i
rescue StandardError
  'Error: Provide number only!'
end

puts lucas(4)

puts lucas(3)

puts lucas('3')

puts lucas(2)

