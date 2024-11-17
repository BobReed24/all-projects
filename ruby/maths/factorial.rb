def factorial(n)
  return nil if n < 0

  fac = 1

  while n > 0
    fac *= n
    n -= 1
  end

  fac
end

puts '4! = ' + factorial(4).to_s

puts '0! = ' + factorial(0).to_s

puts '10! = ' + factorial(10).to_s

