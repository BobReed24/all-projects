def intersect(arr1, arr2)
  result = []

  if arr1.length < arr2.length
    shorter = arr1
    longer = arr2
  else
    shorter = arr2
    longer = arr1
  end

  shorter.each do |matcher|
    longer.each do |number|
      next if number != matcher

      result.push(number)
      break
    end
  end

  result
end

nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
puts intersect(nums1, nums2)

nums1 = [4, 9, 5]
nums2 = [9, 4, 9, 8, 4]
puts intersect(nums1, nums2)

def intersect(arr1, arr2)
  result = []

  hash = Hash.new(0)

  arr2.each { |num| hash[num] += 1 }

  arr1.each do |num|
    if hash.has_key?(num)
      result << num if hash[num] >= 1
      hash[num] -= 1
    end
  end

  result
end

nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
puts intersect(nums1, nums2)

nums1 = [4, 9, 5]
nums2 = [9, 4, 9, 8, 4]
puts intersect(nums1, nums2)

def intersect(nums1, nums2)
  result = []
  p1 = 0
  p2 = 0
  nums1 = nums1.sort
  nums2 = nums2.sort
  while p1 < nums1.length && p2 < nums2.length
    if nums1[p1] < nums2[p2]
      p1 += 1
    elsif nums1[p1] > nums2[p2]
      p2 += 1
    elsif nums1[p1] == nums2[p2]
      result << nums1[p1]
      p1 += 1
      p2 += 1
    end
  end

  result
end
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
intersect(nums1, nums2)

nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
puts intersect(nums1, nums2)

nums1 = [4, 9, 5]
nums2 = [9, 4, 9, 8, 4]
puts intersect(nums1, nums2)

