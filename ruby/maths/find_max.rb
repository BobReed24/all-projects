def find_max(*array)
  max = array[0]
  array.each do |a|
    max = a if a >= max
  end
  "The Max of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

def predefined_max(*array)
  "The Max of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

def predefined_sort_last_max(*array)
  "The Max of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

puts find_max(11, 29, 33)

puts find_max(-221, -852, -1100, -10)

puts find_max(5, '95', 2)

puts predefined_max(51, 82, 39)

puts predefined_max(-11, -51, -10, -10)

puts predefined_max('x', 5, 95, 2)

puts predefined_sort_last_max(1, 2, 3)

puts predefined_sort_last_max(-21, -52, -100, -1)

puts predefined_sort_last_max(5, 95, 2, 'a')

