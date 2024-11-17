def factorial(number)
  if number < 0
    'Please check your input number! The given number is a negative number.'
  elsif number == 0
    "The factorial of 
  else
    result = (1..number).inject(:*)
    "The factorial of 
  end
rescue StandardError
  'Error: Please provide integer only!'
end

puts factorial(0)

puts factorial(4)

puts factorial(10)

puts factorial(1)

puts factorial(-5)

puts factorial('a')

puts factorial('2')

