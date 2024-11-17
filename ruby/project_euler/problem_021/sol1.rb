def get_divisors(number)
  divisors = []
  (1..(Math.sqrt(number).to_i)).each do |num|
    if (number % num).zero?
      divisors << num
      divisors << number / num
    end
  end
  divisors
end

def get_proper_divisors(number)
  divisors = get_divisors(number)
  divisors.delete(number)
  divisors
end

def d(number)
  get_proper_divisors(number).sum
end

def find_amicable_numbers(limit)
  result = []
  (1...limit).each do |a|
    b = d(a)
    res = d(b)
    result.push(a) if (a == res) && (a != b)
  end
  result
end

puts find_amicable_numbers(10_000).sum
