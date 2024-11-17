def single_number(nums)
  result_hash = {}
  nums.each do |num|
    if result_hash[num]
      result_hash[num] += 1
    else
      result_hash[num] = 1
    end
  end

  result_hash.each do |k, v|
    return k if v == 1
  end
end

nums = [2, 2, 1]
puts(single_number(nums))

nums = [4, 1, 2, 1, 2]
puts(single_number(nums))

nums = [1]
puts(single_number(nums))

def single_number(nums)
  nums.find do |num|
    nums.count(num) == 1
  end
end

nums = [2, 2, 1]
puts(single_number(nums))

nums = [4, 1, 2, 1, 2]
puts(single_number(nums))

nums = [1]
puts(single_number(nums))

