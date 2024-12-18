def set_bit(x, position)
  raise 'position must be >= 0' if position < 0

  x | (1 << position)
end

puts set_bit(0, 0)

puts set_bit(0, 4)

puts set_bit(8, 3)

puts set_bit(8, 4)

begin
  puts set_bit(8, -4)
rescue StandardError => e
  puts e.message
end

def clear_bit(x, position)
  raise 'position must be > 0' if position < 0

  x & ~(1 << position)
end

puts clear_bit(0, 0)

puts clear_bit(0, 4)

puts clear_bit(8, 3)

puts clear_bit(24, 4)

begin
  puts clear_bit(0, -4)
rescue StandardError => e
  puts e.message
end

def flip_bit(x, position)
  raise 'position must be > 0' if position < 0

  x ^ (1 << position)
end

puts flip_bit(0, 0)

puts flip_bit(0, 4)

puts flip_bit(8, 3)

puts flip_bit(24, 4)

begin
  puts flip_bit(0, -4)
rescue StandardError => e
  puts e.message
end

def is_bit_set(x, position)
  raise 'position must be > 0' if position < 0

  ((x >> position) & 1) == 1
end

puts is_bit_set(0, 0)

puts is_bit_set(1, 0)

puts is_bit_set(8, 3)

puts is_bit_set(24, 4)

begin
  puts is_bit_set(0, -4)
rescue StandardError => e
  puts e.message
end

