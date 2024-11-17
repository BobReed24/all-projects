def two_sum(nums, target)
  result_array = []

  nums.count.times do |i|
    nums.count.times do |j|
      next unless i != j && i < j

      current_sum = nums[i] + nums[j]

      return [i, j] if current_sum == target
    end
  end
end

print(two_sum([2, 7, 11, 15], 9))

print(two_sum([3, 2, 4], 6))

print(two_sum([3, 3], 6))

def two_sum(nums, target)
  nums.each_with_index do |num, i|
    target_difference = target - num

    nums.each_with_index do |num, j|
      return [i, j] if i != j && num == target_difference
    end
  end
end

print(two_sum([2, 7, 11, 15], 9))

print(two_sum([3, 2, 4], 6))

print(two_sum([3, 3], 6))

