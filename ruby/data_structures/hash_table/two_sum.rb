def two_sum(nums, target)
  hash = {}

  nums.each_with_index do |num, i|
    hash[num] = i
  end

  nums.each_with_index do |num, i|
    difference_target = target - num

    return [i, hash[difference_target]] if hash[difference_target] && hash[difference_target] != i
  end
end

nums = [2, 7, 11, 15]
target = 9
print(two_sum(nums, target))

nums = [3, 2, 4]
target = 6
print(two_sum(nums, target))

nums = [3, 3]
target = 6
print(two_sum(nums, target))

