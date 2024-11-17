def rob(nums, i = nums.length - 1)
  return 0 if i < 0

  [rob(nums, i - 2) + nums[i], rob(nums, i - 1)].max
end

nums = [1, 2, 3, 1]
puts rob(nums)

nums = [2, 7, 9, 3, 1]
puts rob(nums)

def rob(nums)
  dp = Array.new(nums.size + 1)

  (nums.size + 1).times do |i|
    dp[i] = if i == 0
              0
            elsif i == 1
              nums[0]
            else
              [dp[i - 2] + nums[i - 1], dp[i - 1]].max
            end
  end

  dp[-1]
end

nums = [1, 2, 3, 1]
puts rob(nums)

nums = [2, 7, 9, 3, 1]
puts rob(nums)

