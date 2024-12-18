def decimal_to_binary(n)
  bin = []

  until n.zero?
    bin << n % 2
    n /= 2
  end

  bin.reverse.join
end

puts 'Binary value of 4 is ' + decimal_to_binary(4).to_s

puts 'Binary value of 31 is ' + decimal_to_binary(31).to_s

puts 'Binary value of 64 is ' + decimal_to_binary(64).to_s

def decimal_to_binary(d)
  binary = (d % 2).to_s

  return binary if d == 0
  return 1.to_s if d == 1

  decimal_to_binary(d / 2).to_s + binary
end

puts 'Binary value of 4 is ' + decimal_to_binary(4).to_s

puts 'Binary value of 31 is ' + decimal_to_binary(31).to_s

puts 'Binary value of 64 is ' + decimal_to_binary(64).to_s

