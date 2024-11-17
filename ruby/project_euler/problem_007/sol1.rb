def is_prime?(number)   
    value = true
    if number > 1 and number < 4
        
        value = true
    elsif number < 2 or number % 2 == 0 or number % 3 == 0
    
        value = false
    end
    end_range = (Math.sqrt(number) + 1).to_i
    
    for i in (5..end_range).step(6)
        if number % i == 0 or number % (i + 2) == 0
            value = false
        end
    end
    result = value
end

def solution(nth = 10001)
  primes = Array.new()
  num = 2
  while primes.length < nth
    if is_prime?(num)
      primes.append(num)
    end
    num += 1
  end
  primes[primes.length - 1]
end

answer = solution()
p answer