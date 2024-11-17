def armstrong_number(number)
  num = number
  sum = 0
  len = number.digits.count
  while number != 0
    remainder = number % 10
    sum += remainder**len
    number /= 10
  end

  if num == sum
    "The number 
  else
    "The number 
  end
rescue StandardError
  'Error: Please provide number only!'
end

puts armstrong_number(153)

puts armstrong_number(0)

puts armstrong_number(370)

puts armstrong_number(10)

puts armstrong_number(1634)

puts armstrong_number(123)

puts armstrong_number('153')

puts armstrong_number('a')

