def find_min(*array)
  min = array[0]
  array.each do |a|
    min = a if a <= min
  end
  "The Min of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

def predefined_min(*array)
  "The Min of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

def predefined_sort_first_min(*array)
  "The Min of the following elements 
rescue StandardError
  'Error: Please provide number only!'
end

puts find_min(11, 29, 33)

puts find_min(-221, -852, -1100, -10)

puts find_min(5, '95', 2)

puts predefined_min(51, 82, 39)

puts predefined_min(-11, -51, -10, -10)

puts predefined_min('x', 5, 95, 2)

puts predefined_sort_first_min(1, 2, 3)

puts predefined_sort_first_min(-21, -52, -100, -1)

puts predefined_sort_first_min(5, 95, 2, 'a')

