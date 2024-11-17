def collatz_conjecture(number)
  n = number
  nums = []
  nums.push(number)

  while number > 1
    if number.even?
      number /= 2
      nums.push(number)
    else
      number = 3 * number + 1
      nums.push(number)
    end
  end

  "The 3N + 1 series of 
rescue StandardError
  'Error: Please provide number only!'
end

puts collatz_conjecture(12)

puts collatz_conjecture(6)

puts collatz_conjecture(100)

puts collatz_conjecture('12')

puts collatz_conjecture('a')

