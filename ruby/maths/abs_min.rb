def abs_min(x, y)
  num = x - y
  min_value = ((x + y - num.abs) / 2)
  "The Abs Min of 
rescue StandardError
  'Error: Provide number only!'
end

puts abs_min(10, 20)

puts abs_min(-10, -1)

puts abs_min(9, -121)

puts abs_min(2, '-1')

puts abs_min('3', '5')

puts abs_min('a', '5')

