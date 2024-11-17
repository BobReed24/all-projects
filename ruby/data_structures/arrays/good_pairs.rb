def num_identical_pairs(nums)
  count = 0
  nums.each_with_index do |num, i|
    target = num
    nums.each_with_index do |num, j|
      next if i >= j

      count += 1 if num == target
    end
  end
  count
end

nums = [1, 2, 3, 1, 1, 3]
puts(num_identical_pairs(nums))

nums = [1, 1, 1, 1]
puts(num_identical_pairs(nums))

nums = [1, 2, 3]
puts(num_identical_pairs(nums))

