def sorted_squares(nums)
  nums.map! { |num| num**2 }.sort
end
print(sorted_squares([4, -1, -9, 2]))

def bubble_sort(array)
  array_length = array.size
  return array if array_length <= 1

  loop do
    swapped = false
    (array_length - 1).times do |i|
      if array[i] > array[i + 1]
        array[i], array[i + 1] = array[i + 1], array[i]
        swapped = true
      end
    end
    break unless swapped
  end
  array
end

def sorted_squares(nums)
  
  nums.map! { |num| num**2 }
  
  bubble_sort(nums)
end
print(sorted_squares([4, -1, -9, 2]))

def sorted_squares(nums)
  p1 = 0
  p2 = nums.length - 1
  
  max_index = p2
  output = []
  while p1 < p2
    nums1_square = nums[p1] * nums[p1]
    nums2_square = nums[p2] * nums[p2]
    if nums1_square < nums2_square
      output[max_index] = nums2_square
      p2 -= 1
    elsif nums1_square > nums2_square
      output[max_index] = nums1_square
      p1 += 1
    else
      output[max_index] = nums1_square
      max_index -= 1
      output[max_index] = nums2_square
      p1 += 1
      p2 -= 1
    end
    max_index -= 1
  end
  
  output[max_index] = nums[p1] * nums[p2] if p1 == p2
  output
end

print(sorted_squares([4, -1, -9, 2]))
