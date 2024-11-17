def solution()
  index_best_result = 0
  for num in 2..1000000
    index_candidate = 0
    n = num
    while n > 1
      if n%2 == 0
        n = n / 2
      else
        n = (3*n) + 1
      end
      index_candidate +=1
    end
    if index_best_result < index_candidate
      index_best_result = index_candidate
      value = num
    end
  end
  result = value
end

answer = solution()
p answer