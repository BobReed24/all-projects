def abs_max(x, y)
  num = x - y
  max_value = ((x + y + num.abs) / 2)
  "The Abs Max of 
rescue StandardError
  'Error: Provide number only!'
end

puts abs_max(10, 20)

puts abs_max(-10, -1)

puts abs_max(9, -121)

puts abs_max(2, '-1')

puts abs_max('3', '5')

puts abs_max('a', '5')

