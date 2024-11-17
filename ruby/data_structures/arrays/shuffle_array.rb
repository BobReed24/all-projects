def shuffle(nums, n)
  result = []
  (0..n - 1).count do |i|
    result.push(nums[i], nums[i + n])
  end
  result
end

nums = [2, 5, 1, 3, 4, 7]
n = 3
print(shuffle(nums, n))

nums = [1, 2, 3, 4, 4, 3, 2, 1]
n = 4
print(shuffle(nums, n))

nums = [1, 1, 2, 2]
n = 2
print(shuffle(nums, n))

def shuffle(nums, n)
  current_index = 1
  (0..n - 1).each do |i|
    nums.insert(current_index, nums.delete_at(i + n))
    current_index += 2
  end
  nums
end

nums = [2, 5, 1, 3, 4, 7]
n = 3
print(shuffle(nums, n))

nums = [1, 2, 3, 4, 4, 3, 2, 1]
n = 4
print(shuffle(nums, n))

nums = [1, 1, 2, 2]
n = 2
print(shuffle(nums, n))

def shuffle(nums, n)
  result = []
  p1 = 0
  p2 = n

  while p1 < n
    result.push(nums[p1], nums[p2])
    p1 += 1
    p2 += 1
  end

  result
end

nums = [2, 5, 1, 3, 4, 7]
n = 3
print(shuffle(nums, n))

nums = [1, 2, 3, 4, 4, 3, 2, 1]
n = 4
print(shuffle(nums, n))

nums = [1, 1, 2, 2]
n = 2
print(shuffle(nums, n))

