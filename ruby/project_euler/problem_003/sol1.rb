def get_factors(number)
  factors = []
  (1..Math.sqrt(number).to_i).each do |num|
    if (number % num).zero?
      factors << num
      factors << number / num
    end
  end
  factors
end

def prime?(number)
  get_factors(number).length == 2
end

def largest_prime_factor(number)
  prime_factors = get_factors(number).select { |factor| prime?(factor) }
  prime_factors.max
end

puts largest_prime_factor(600_851_475_143)
