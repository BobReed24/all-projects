def next_greater_element(nums1, nums2)
  nums1.each_with_index do |nums1_value, pointer1|
    max = 0
    pos_nums2 = nums2.find_index(nums1_value)

    nums2[pos_nums2..nums2.count].each do |nums2_value|
      if nums2_value > nums1_value
        max = nums2_value
        break
      end
    end

    nums1[pointer1] = (nums1_value < max ? max : -1)
  end

  nums1
end

nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]
print next_greater_element(nums1, nums2)

nums1 = [2, 4]
nums2 = [1, 2, 3, 4]
print next_greater_element(nums1, nums2)

