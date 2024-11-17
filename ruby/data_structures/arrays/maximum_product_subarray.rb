def max_product(nums)
  return nums[0] if nums.length == 1

  cur_min = 1
  cur_max = 1
  max = -11

  nums.each do |val|
    tmp_cur_max = cur_max
    cur_max = [val, val * cur_max, val * cur_min].max
    cur_min = [val, val * tmp_cur_max, val * cur_min].min

    max = [max, cur_max].max
  end

  max
end

nums = [2, 3, -2, 4]
puts max_product(nums)

nums = [-2, 0, -1]
puts max_product(nums)

