def two_sum(numbers, target)
  i = 0
  j = numbers.length - 1

  while i < j
    sum = numbers[i] + numbers[j]

    if target < sum
      j -= 1
    elsif target > sum
      i += 1
    else
      return [i + 1, j + 1]
    end
  end
end

nums = [2, 7, 11, 15]
target = 9
print(two_sum(nums, target))

nums = [2, 3, 4]
target = 6
print(two_sum(nums, target))

nums = [-1, 0]
target = -1
print(two_sum(nums, target))

