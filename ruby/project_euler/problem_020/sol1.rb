def factorial(number)
  number.downto(1).reduce(:*)
end

number = 100
puts factorial(number).digits.sum
