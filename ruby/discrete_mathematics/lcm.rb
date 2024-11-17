p 'Least Common Multiple'

p 'Enter first number'
value_one = gets.chomp.to_i

p 'Enter second number'
value_two = gets.chomp.to_i

def gcd(first, second)
  if second != 0
    gcd(second, first % second)
  else
    first
  end
end

def lcm(first, second)
  (first * second) / gcd(first, second)
end

p "Least Common Multiple is: 
