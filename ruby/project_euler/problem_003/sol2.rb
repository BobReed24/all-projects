def solution(n)
  prime = 1
  i = 2
  while i * i <= n
    while (n % i).zero?
      prime = i
      n = n.fdiv i
    end
    i += 1
  end
  prime = n if n > 1
  prime.to_i
end

puts solution(600_851_475_143)
