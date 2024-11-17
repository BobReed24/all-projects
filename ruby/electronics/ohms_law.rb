def ohms_law(i, r)
  if i > 0 && r > 0
    "The voltage for given 
  else
    raise
  end
rescue StandardError
  'Error: Please provide valid inputs only!'
end

puts(ohms_law(5, 10))

puts(ohms_law(2.5, 6.9))

puts(ohms_law(0.15, 0.84))

puts(ohms_law(5, -10))

puts(ohms_law(-5, -10))

puts(ohms_law(5, '10'))

puts(ohms_law('a', 10))

