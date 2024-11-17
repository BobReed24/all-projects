def remove_elements(nums, val)
  nums.delete_if { |num| num == val }
  nums.length
end

puts remove_elements([3, 2, 2, 3], 3)

puts remove_elements([0, 1, 2, 2, 3, 0, 4, 2], 2)

def remove_elements(nums, val)
  result_length = nums.length
  shift_length = 0
  nums.each_with_index do |num, i|
    next unless num == val

    nums.delete_at(i)
    nums.unshift('removed')
    result_length -= 1
    shift_length += 1
  end
  nums.shift(shift_length)
  result_length
end

puts remove_elements([3, 2, 2, 3], 3)

puts remove_elements([0, 1, 2, 2, 3, 0, 4, 2], 2)

def remove_element(nums, val)
  pointer1 = 0

  nums.each_with_index do |num, pointer2|
    if val != num
      nums[pointer1] = nums[pointer2]
      pointer1 += 1
    end
  end

  pointer1
end

puts remove_elements([3, 2, 2, 3], 3)

puts remove_elements([0, 1, 2, 2, 3, 0, 4, 2], 2)

def remove_element(nums, val)
  pointer1 = 0
  pointer2 = nums.length

  while pointer1 < pointer2
    if nums[pointer1] == val
      pointer2 -= 1
      nums[pointer1] = nums[pointer2]
    else
      pointer1 += 1
    end
  end

  pointer1
end

puts remove_elements([3, 2, 2, 3], 3)

puts remove_elements([0, 1, 2, 2, 3, 0, 4, 2], 2)

