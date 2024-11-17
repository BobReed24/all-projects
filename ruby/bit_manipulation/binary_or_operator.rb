def binary_or(x, y)
  raise 'Input must only contain positive integers' if (x < 0) || (y < 0)

  '0b' + (x | y).to_s(2)
end

begin
  binary_or(-1, 0)
rescue StandardError => e
  puts e.message
end

puts binary_or(1, 1)

puts binary_or(0, 1)

puts binary_or(1024, 1024)

puts binary_or(0, 1023)

puts binary_or(16, 58)

