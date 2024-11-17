def binary_to_decimal(n)
  decimal = 0
  base = 1
  until n.zero?
    x = n % 10
    n /= 10
    decimal += x * base
    base *= 2
  end
  decimal
end

puts 'Decimal value of 110011 is ' + binary_to_decimal(110_011).to_s

puts 'Decimal value of 11110 is ' + binary_to_decimal(11_110).to_s

puts 'Decimal value of 101 is ' + binary_to_decimal(101).to_s

