def num_identical_pairs(nums)
  hash = Hash.new(0)

  nums.each do |num|
    hash[num] = hash[num] + 1
  end

  counter = 0
  
  hash.values.each do |val|
    counter += (val * (val - 1) / 2)
  end

  counter
end

nums = [1, 2, 3, 1, 1, 3]
puts(num_identical_pairs(nums))

nums = [1, 1, 1, 1]
puts(num_identical_pairs(nums))

nums = [1, 2, 3]
puts(num_identical_pairs(nums))

