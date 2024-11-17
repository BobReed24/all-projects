def solution(num_digits = 1000)
  
  resultn1 = 1
  resultn2 = 1
  result = 2
  index = 3
  value = true
  while value
    resultn2 = resultn1
    resultn1 = result
    if (resultn1 + resultn2).abs.digits.length < num_digits
      value = true
    else
      value = false
    end
    result = resultn1 + resultn2    
    index += 1
  end
  res = index
end

answer = solution()
p answer
  